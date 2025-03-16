package net.sf.l2j.messaging.factory;

import net.sf.l2j.Config;
import net.sf.l2j.messaging.handler.AdminMessageHandler;
import net.sf.l2j.messaging.handler.Handler;
import net.sf.l2j.messaging.handler.NullMessageHandler;
import net.sf.l2j.messaging.handler.ServiceMessageHandler;
import org.slf4j.LoggerFactory;

import java.util.logging.Logger;

public class HandlerFactory {
    public static Handler create(String topic) {
        return switch (topic) {
            case "service" -> new ServiceMessageHandler();
            case "admin" -> new AdminMessageHandler();
            default -> new NullMessageHandler();
        };
    }
}
