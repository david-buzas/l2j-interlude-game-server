package net.sf.l2j.messaging.consumer;

public interface Consumer {

    void consume();

    void stopConsumer();

    void setPollInterval(int milliseconds);
}
