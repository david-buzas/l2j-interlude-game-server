package net.sf.l2j.messaging.handler;

import net.sf.l2j.messaging.consumer.Consumer;
import net.sf.l2j.messaging.factory.ConsumerFactory;
import net.sf.l2j.messaging.factory.ProducerFactory;
import net.sf.l2j.messaging.producer.Producer;
import net.sf.l2j.messaging.response.MessageResponse;
import net.sf.l2j.messaging.response.Response;
import org.json.JSONObject;

public class ServiceMessageHandler implements Handler {
    private final Producer producer;

    public ServiceMessageHandler() {
        producer = ProducerFactory.create("server-response");
    }

    public void handleMessage(String command, String message, JSONObject jsonObject) {
        Consumer consumer = ConsumerFactory.create();
        Response response = new MessageResponse(producer, jsonObject);

        switch (command) {
            case "stop-consumer":
                consumer.stopConsumer();
                break;
            case "change-poll-interval":
                int interval = Integer.parseInt(message);
                consumer.setPollInterval(interval);
                break;
            case "ping":
                response.sendSuccess("pong");
                break;
        }
    }
}
