package net.sf.l2j.messaging.factory;

import net.sf.l2j.messaging.dto.JsonMessageDTO;
import net.sf.l2j.messaging.dto.MessageDTO;

public class MessageDTOFactory {
    public static MessageDTO create(String message) {
        return new JsonMessageDTO(message);
    }
}
