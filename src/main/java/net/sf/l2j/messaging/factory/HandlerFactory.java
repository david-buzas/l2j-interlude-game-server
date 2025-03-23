package net.sf.l2j.messaging.factory;

import net.sf.l2j.messaging.handler.AdminMessageHandler;
import net.sf.l2j.messaging.handler.MessageHandler;
import net.sf.l2j.messaging.handler.NullMessageHandler;
import net.sf.l2j.messaging.handler.ServiceMessageHandler;

public class HandlerFactory {
    public static MessageHandler create(String topic) {
        return switch (topic) {
            case "service" -> new ServiceMessageHandler();
            case "admin" -> new AdminMessageHandler();
            default -> new NullMessageHandler();
        };
    }
}
