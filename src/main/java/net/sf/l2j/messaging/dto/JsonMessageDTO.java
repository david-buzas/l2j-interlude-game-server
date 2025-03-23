package net.sf.l2j.messaging.dto;

import org.json.JSONObject;

public class JsonMessageDTO implements MessageDTO {
    private final JSONObject parameters;

    public JsonMessageDTO(String message) {
        this.parameters = new JSONObject(message);
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

    public String getPrefixedValue(String key, String prefix, String glue) {
        return prefix + glue + getValue("key");
    }

    public int getIntegerValue(String key) {
        return Integer.parseInt(getValue(key));
    }
}
