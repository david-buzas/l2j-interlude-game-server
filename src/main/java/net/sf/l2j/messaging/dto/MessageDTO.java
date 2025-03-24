package net.sf.l2j.messaging.dto;

public interface MessageDTO {
    boolean hasValue(String key);

    String getValue(String key);

    String getPrefixedValue(String key, String prefix, String glue);

    int getIntegerValue(String key);
}
