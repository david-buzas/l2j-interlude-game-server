package net.sf.l2j.config;

import org.aeonbits.owner.Config;

import static java.util.concurrent.TimeUnit.MINUTES;
import static org.aeonbits.owner.Config.HotReloadType.ASYNC;
import static org.aeonbits.owner.Config.LoadType.MERGE;

@Config.Sources({
        "system:env",
        "file:${L2J_HOME}/custom/game/config/telnet.properties",
        "file:./config/telnet.properties",
        "classpath:config/telnet.properties"
})
@Config.LoadPolicy(MERGE)
@Config.HotReload(value = 20, unit = MINUTES, type = ASYNC)
public interface TelnetConfiguration extends Config {
    @Key("EnableTelnet")
    @DefaultValue("false")
    boolean getEnableTelnet();

    @Key("StatusPort")
    @DefaultValue("12345")
    int getStatusPort();

    @Key("StatusPW")
    @DefaultValue("")
    String getStatusPW();

    @Key("ListOfHosts")
    @DefaultValue("127.0.0.1,localhost")
    String getListOfHosts();
}
