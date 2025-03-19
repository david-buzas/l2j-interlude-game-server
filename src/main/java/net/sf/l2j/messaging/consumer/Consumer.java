package net.sf.l2j.messaging.consumer;

public interface Consumer {

    public void consume();

    public void stopConsumer();

    public void setPollInterval(int milliseconds);
}
