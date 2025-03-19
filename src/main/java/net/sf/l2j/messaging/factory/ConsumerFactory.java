package net.sf.l2j.messaging.factory;

import net.sf.l2j.config.MessagingConfiguration;
import net.sf.l2j.messaging.consumer.Consumer;
import net.sf.l2j.messaging.consumer.KafkaMessageConsumer;
import net.sf.l2j.messaging.consumer.NullConsumer;
import org.aeonbits.owner.ConfigFactory;

import static net.sf.l2j.config.Configuration.*;

public class ConsumerFactory {
    private static Consumer instance;

    public static Consumer create() {
        if (instance != null) {
            return instance;
        }

        MessagingConfiguration config = messaging();
        String key = hexID().getHexID();

        if (config.getProducer().equals("kafka")) {
            return instance = new KafkaMessageConsumer(config, key);
        }

        return instance = new NullConsumer();
    }
}
