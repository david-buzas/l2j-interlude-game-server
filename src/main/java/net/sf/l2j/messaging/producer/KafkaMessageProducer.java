package net.sf.l2j.messaging.producer;

import net.sf.l2j.config.MessagingConfiguration;
import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

import java.util.Properties;

public class KafkaMessageProducer implements Producer {
    private final KafkaProducer<String, String> producer;
    private final String topic;

    public KafkaMessageProducer(MessagingConfiguration config, String topic) {
        Properties properties = new Properties();
        properties.put("bootstrap.servers", config.getBootstrapServers());
        properties.put("key.serializer", config.getKeySerializer());
        properties.put("value.serializer", config.getValueSerializer());

        this.producer = new KafkaProducer<>(properties);
        this.topic = topic;
    }

    public void createMessage(String key, String message) {
        ProducerRecord<String, String> record = new ProducerRecord<>(this.topic, key, message);

        this.producer.send(record, new Callback() {
            @Override
            public void onCompletion(RecordMetadata metadata, Exception exception) {
                if (exception == null) {
//                    _log.info("Message sent successfully. Offset: " + metadata.offset());
                } else {
//                    _log.warning("Failed to send message: " + exception.getMessage());
                }
            }
        });
    }

    public void createMessage(String message) {
        this.createMessage("", message);
    }
}
