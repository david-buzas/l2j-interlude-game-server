package net.sf.l2j.messaging.handler;

import net.sf.l2j.messaging.consumer.Consumer;
import net.sf.l2j.messaging.dto.MessageDTO;
import net.sf.l2j.messaging.factory.ConsumerFactory;

public class ServiceMessageHandler implements MessageHandler {
    private final Consumer consumer;

    public ServiceMessageHandler() {
        consumer = ConsumerFactory.create();
    }

    public void handleMessage(MessageDTO messageDTO) {
        String command = messageDTO.getValue("command");

        if (command.equals("stop-consumer")) {
            consumer.stopConsumer();
        }

        if (command.equals("change-poll-interval") && messageDTO.hasValue("interval")) {
            consumer.setPollInterval(messageDTO.getIntegerValue("interval"));
        }
    }
}
