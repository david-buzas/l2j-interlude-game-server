package net.sf.l2j.messaging.consumer;

import net.sf.l2j.config.MessagingConfiguration;
import net.sf.l2j.messaging.factory.HandlerFactory;
import net.sf.l2j.messaging.handler.Handler;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.json.JSONObject;

import java.time.Duration;
import java.util.Arrays;
import java.util.Properties;

public class KafkaMessageConsumer implements Consumer {
    private final KafkaConsumer<String, String> consumer;
    private final String[] topics;
    private static boolean consume = true;
    private Duration pollInterval;
    private final String key;

    public KafkaMessageConsumer(MessagingConfiguration config, String key) {
        Properties properties = new Properties();
        properties.put("bootstrap.servers", config.getBootstrapServers());
        properties.put("key.deserializer", config.getKeyDeserializer());
        properties.put("value.deserializer", config.getValueDeserializer());
        properties.put("group.id", config.getConsumerGroup());

        consumer = new KafkaConsumer<>(properties);
        topics = config.getSubscribedTopics().split(",");
        this.key = key;

        setPollInterval(config.getConsumerPollInterval());
    }

    public void consume() {
        consumer.subscribe(Arrays.asList(topics));

        while (consume) {
            // Start consuming messages
            ConsumerRecords<String, String> records = consumer.poll(pollInterval);
            for (ConsumerRecord<String, String> record : records) {
                String key = record.key() != null ? record.key() : "";

                if (!key.equals("*") && !key.equals(this.key)) {
                    continue;
                }

                String value = record.value() != null ? record.value() : "{}";

                JSONObject jsonObject = new JSONObject(value);

                String command = jsonObject.has("command") ? jsonObject.getString("command") : "";
                String message = jsonObject.has("message") ? jsonObject.getString("message") : "";

                Handler handler = HandlerFactory.create(record.topic());
                handler.handleMessage(command, message, jsonObject);
            }

            // Commit the offsets manually
            consumer.commitSync();
        }

        // Close the consumer
        consumer.close();
    }

    public void stopConsumer() {
        consume = false;
    }

    public void setPollInterval(int milliseconds) {
        pollInterval = Duration.ofMillis(milliseconds);
    }
}
