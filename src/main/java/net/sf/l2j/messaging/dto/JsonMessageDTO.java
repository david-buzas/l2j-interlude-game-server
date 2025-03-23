package net.sf.l2j.messaging.dto;

import org.json.JSONObject;

public class JsonMessageDTO extends AbstractMessageDTO {
    private final JSONObject parameters;

    public JsonMessageDTO(JSONObject jsonObject) {
        parameters = jsonObject;
    }

    public boolean hasValue(String key) {
        return this.parameters.has(key);
    }

    public String getValue(String key) {
        if (!this.hasValue(key)) {
            return null;
        }

        return this.parameters.get(key).toString();
    }
}
