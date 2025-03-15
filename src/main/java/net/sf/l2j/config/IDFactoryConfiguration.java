package net.sf.l2j.config;

import org.aeonbits.owner.Config;

import static java.util.concurrent.TimeUnit.MINUTES;
import static org.aeonbits.owner.Config.HotReloadType.ASYNC;
import static org.aeonbits.owner.Config.LoadType.MERGE;

@Config.Sources({
        "system:env",
        "file:${L2J_HOME}/custom/game/config/idfactory.properties",
        "file:./config/idfactory.properties",
        "classpath:config/idfactory.properties"
})
@Config.LoadPolicy(MERGE)
@Config.HotReload(value = 20, unit = MINUTES, type = ASYNC)
public interface IDFactoryConfiguration extends Config {
    @Key("L2Map")
    @DefaultValue("WorldObjectMap")
    String getL2Map();

    @Key("L2Set")
    @DefaultValue("WorldObjectSet")
    String getL2Set();

    @Key("IDFactory")
    @DefaultValue("Compaction")
    String getIDFactory();

    @Key("BadIdChecking")
    @DefaultValue("true")
    boolean getBadIdChecking();
}
