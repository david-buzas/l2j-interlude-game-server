package net.sf.l2j.messaging.consumer;

import net.sf.l2j.config.MessagingConfiguration;
import net.sf.l2j.messaging.factory.HandlerFactory;
import net.sf.l2j.messaging.handler.Handler;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.time.Duration;
import java.util.Arrays;
import java.util.Properties;

public class KafkaMessageConsumer implements Consumer {
    private final KafkaConsumer<String, String> consumer;
    private final String[] topics;
    private static boolean consume = true;
    private Duration pollInterval;

    public KafkaMessageConsumer(MessagingConfiguration config) {
        Properties properties = new Properties();
        properties.put("bootstrap.servers", config.getBootstrapServers());
        properties.put("key.deserializer", config.getKeyDeserializer());
        properties.put("value.deserializer", config.getValueDeserializer());
        properties.put("group.id", config.getConsumerGroup());

        this.consumer = new KafkaConsumer<>(properties);
        this.topics = config.getSubscribedTopics().split(",");

        this.setPollInterval(config.getConsumerPollInterval());
    }

    public void consume() {
        this.consumer.subscribe(Arrays.asList(this.topics));

        while (consume) {
            // Start consuming messages
            ConsumerRecords<String, String> records = this.consumer.poll(this.pollInterval);
            for (ConsumerRecord<String, String> record : records) {
                String key = record.key() != null ? record.key() : "";
                String value = record.value() != null ? record.value() : "";

                Handler handler = HandlerFactory.create(record.topic());
                handler.handleMessage(key, value);
            }

            // Commit the offsets manually
            this.consumer.commitSync();
        }

        // Close the consumer
        consumer.close();
    }

    public void stopConsumer() {
        consume = false;
    }

    public void setPollInterval(int milliseconds) {
        this.pollInterval = Duration.ofMillis(milliseconds);
    }
}
