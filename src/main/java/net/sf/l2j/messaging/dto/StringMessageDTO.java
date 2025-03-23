package net.sf.l2j.messaging.dto;

import java.util.HashMap;
import java.util.Map;

public class StringMessageDTO extends AbstractMessageDTO {
    private final Map<String, String> parameters = new HashMap<>();

    public StringMessageDTO(String message) {
        String[] segments = message.split(" ");

        for (String segment: segments) {
            String[] keyValue = segment.split("=");
            parameters.put(keyValue[0], keyValue[1]);
        }
    }

    public boolean hasValue(String key) {
        return parameters.containsKey(key);
    }

    public String getValue(String key) {
        if (!hasValue(key)) {
            throw new RuntimeException("HashMap[" + key + "] not found.");
        }

        return parameters.get(key);
    }
}
