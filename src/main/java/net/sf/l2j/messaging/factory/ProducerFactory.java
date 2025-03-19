package net.sf.l2j.messaging.factory;

import static net.sf.l2j.config.Configuration.*;

import net.sf.l2j.config.MessagingConfiguration;
import net.sf.l2j.messaging.producer.KafkaMessageProducer;
import net.sf.l2j.messaging.producer.NullProducer;
import net.sf.l2j.messaging.producer.Producer;

import java.util.HashMap;
import java.util.Map;

public class ProducerFactory {
    private static final Map<String, Producer> instances = new HashMap<>();

    public static Producer create(String topic)
    {
        if (instances.containsKey(topic)) {
            return instances.get(topic);
        }

        MessagingConfiguration config = messaging();
        String key = hexID().getHexID();

        if (config.getProducer().equals("kafka")) {
            instances.put(topic, new KafkaMessageProducer(config, topic, key));
        } else {
            instances.put(topic, new NullProducer());
        }

        return instances.get(topic);
    }
}
