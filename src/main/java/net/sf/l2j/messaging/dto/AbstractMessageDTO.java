package net.sf.l2j.messaging.dto;

abstract public class AbstractMessageDTO implements MessageDTO {
    public String getPrefixedValue(String key, String prefix, String glue) {
        return prefix + glue + getValue(key);
    }

    public int getIntegerValue(String key) {
        return Integer.parseInt(getValue(key));
    }
}
