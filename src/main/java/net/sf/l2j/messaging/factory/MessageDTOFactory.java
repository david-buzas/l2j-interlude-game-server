package net.sf.l2j.messaging.factory;

import net.sf.l2j.messaging.dto.JsonMessageDTO;
import net.sf.l2j.messaging.dto.MessageDTO;
import net.sf.l2j.messaging.dto.StringMessageDTO;
import org.json.JSONObject;

public class MessageDTOFactory {
    public static MessageDTO create(String message) {
        try {
            JSONObject jsonObject = new JSONObject(message);
            return new JsonMessageDTO(jsonObject);
        } catch (Exception ignored) {
        }

        return new StringMessageDTO(message);
    }
}
