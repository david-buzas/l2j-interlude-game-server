package net.sf.l2j.messaging.factory;

import net.sf.l2j.config.MessagingConfiguration;
import net.sf.l2j.messaging.consumer.Consumer;
import net.sf.l2j.messaging.consumer.KafkaMessageConsumer;
import net.sf.l2j.messaging.consumer.NullConsumer;
import org.aeonbits.owner.ConfigFactory;

public class ConsumerFactory {
    private static Consumer instance;

    public static Consumer create() {
        if (instance != null) {
            return instance;
        }

        MessagingConfiguration config = ConfigFactory.create(MessagingConfiguration.class);

        if (config.getProducer().equals("kafka")) {
            return instance = new KafkaMessageConsumer(config);
        }

        return instance = new NullConsumer();
    }
}
