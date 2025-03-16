package net.sf.l2j.messaging.handler;

import net.sf.l2j.messaging.consumer.Consumer;
import net.sf.l2j.messaging.factory.ConsumerFactory;

public class ServiceMessageHandler implements Handler {
    public void handleMessage(String key, String message) {
        Consumer consumer = ConsumerFactory.create();

        switch (key) {
            case "stop-consumer":
                consumer.stopConsumer();
                break;
            case "restart-consumer":
                consumer.stopConsumer();
                consumer.consume();
                break;
            case "change-poll-interval":
                int interval = Integer.parseInt(message);
                consumer.setPollInterval(interval);
                break;
        }
    }
}
