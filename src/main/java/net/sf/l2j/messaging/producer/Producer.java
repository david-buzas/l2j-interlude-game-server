package net.sf.l2j.messaging.producer;

public interface Producer {
    public void createMessage(String key, String message);
    public void createMessage(String message);
}
