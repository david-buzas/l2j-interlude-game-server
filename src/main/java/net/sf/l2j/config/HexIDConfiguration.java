package net.sf.l2j.config;

import org.aeonbits.owner.Config;

import static java.util.concurrent.TimeUnit.MINUTES;
import static org.aeonbits.owner.Config.HotReloadType.ASYNC;
import static org.aeonbits.owner.Config.LoadType.MERGE;

@Config.Sources({
        "system:env",
        "file:${L2J_HOME}/custom/game/config/hexid.txt",
        "file:./config/hexid.txt",
        "classpath:config/hexid.txt"
})
@Config.LoadPolicy(MERGE)
@Config.HotReload(value = 20, unit = MINUTES, type = ASYNC)
public interface HexIDConfiguration extends Config {
    @Key("HexID")
    @DefaultValue("")
    String getHexID();

    @Key("ServerID")
    @DefaultValue("1")
    int getServerID();
}
