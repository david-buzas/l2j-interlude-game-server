package net.sf.l2j.config;

import org.aeonbits.owner.Config;

import static java.util.concurrent.TimeUnit.MINUTES;
import static org.aeonbits.owner.Config.HotReloadType.ASYNC;
import static org.aeonbits.owner.Config.LoadType.MERGE;

@Config.Sources({
        "system:env",
        "file:${L2J_HOME}/custom/game/config/messaging.properties",
        "file:./config/messaging.properties",
        "classpath:config/messaging.properties"
})
@Config.LoadPolicy(MERGE)
@Config.HotReload(value = 20, unit = MINUTES, type = ASYNC)
public interface MessagingConfiguration extends Config {
    @Key("BootstrapServers")
    @DefaultValue("kafka:9093")
    String getBootstrapServers();

    @Key("KeySerializer")
    @DefaultValue("org.apache.kafka.common.serialization.StringSerializer")
    String getKeySerializer();

    @Key("KeyDeserializer")
    @DefaultValue("org.apache.kafka.common.serialization.StringDeserializer")
    String getKeyDeserializer();

    @Key("ValueSerializer")
    @DefaultValue("org.apache.kafka.common.serialization.StringSerializer")
    String getValueSerializer();

    @Key("ValueDeserializer")
    @DefaultValue("org.apache.kafka.common.serialization.StringDeserializer")
    String getValueDeserializer();

    @Key("Producer")
    @DefaultValue("kafka")
    String getProducer();

    @Key("SubscribedTopics")
    @DefaultValue("boot,admin,service")
    String getSubscribedTopics();

    @Key("ConsumerGroup")
    @DefaultValue("L2JServer")
    String getConsumerGroup();

    @Key("ConsumerPollInterval")
    @DefaultValue("1000")
    int getConsumerPollInterval();
}
