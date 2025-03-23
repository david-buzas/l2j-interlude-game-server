package net.sf.l2j.messaging.consumer;

import net.sf.l2j.config.MessagingConfiguration;
import net.sf.l2j.messaging.dto.MessageDTO;
import net.sf.l2j.messaging.factory.HandlerFactory;
import net.sf.l2j.messaging.factory.MessageDTOFactory;
import net.sf.l2j.messaging.handler.MessageHandler;
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
                consumeRecord(record);
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

    private void consumeRecord(ConsumerRecord<String, String> record) {
        String key = record.key() != null ? record.key() : "";

        if (!key.equals("*") && !key.equals(this.key)) {
            return;
        }

        if (record.value() != null) {
            return;
        }

        MessageHandler messageHandler = HandlerFactory.create(record.topic());
        MessageDTO dto = MessageDTOFactory.create(record.value());

        messageHandler.handleMessage(dto);
    }
}
