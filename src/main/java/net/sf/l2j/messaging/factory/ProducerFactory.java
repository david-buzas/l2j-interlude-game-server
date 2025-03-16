package net.sf.l2j.messaging.factory;

import static net.sf.l2j.config.Configuration.messaging;

import net.sf.l2j.config.MessagingConfiguration;
import net.sf.l2j.messaging.producer.KafkaMessageProducer;
import net.sf.l2j.messaging.producer.NullProducer;
import net.sf.l2j.messaging.producer.Producer;

public class ProducerFactory {
    private static Producer instance;

    public static Producer create(String topic)
    {
        if (instance != null) {
            return instance;
        }

        MessagingConfiguration config = messaging();

        if (config.getProducer().equals("kafka")) {
            return instance = new KafkaMessageProducer(config, topic);
        }

        return instance = new NullProducer();
    }
}
