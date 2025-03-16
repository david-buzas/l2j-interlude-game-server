package net.sf.l2j.messaging.handler;

import net.sf.l2j.messaging.consumer.Consumer;
import net.sf.l2j.messaging.factory.ConsumerFactory;
import net.sf.l2j.messaging.factory.ProducerFactory;
import net.sf.l2j.messaging.producer.Producer;

public class ServiceMessageHandler implements Handler {
    public void handleMessage(String key, String message) {
        Consumer consumer = ConsumerFactory.create();
        Producer producer = ProducerFactory.create("server-response");

        switch (key) {
            case "stop-consumer":
                consumer.stopConsumer();
                producer.createMessage("Message consumer stopped.");
                break;
            case "change-poll-interval":
                int interval = Integer.parseInt(message);
                consumer.setPollInterval(interval);
                producer.createMessage("Message consumer poll interval changed to " + message + " milliseconds.");
                break;
        }
    }
}
