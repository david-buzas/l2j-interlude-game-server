package net.sf.l2j.config;

import org.aeonbits.owner.Config;

import static java.util.concurrent.TimeUnit.MINUTES;
import static org.aeonbits.owner.Config.HotReloadType.ASYNC;
import static org.aeonbits.owner.Config.LoadType.MERGE;

@Config.Sources({
        "system:env",
        "file:${L2J_HOME}/custom/game/config/sevensigns.properties",
        "file:./config/sevensigns.properties",
        "classpath:config/sevensigns.properties"
})
@Config.LoadPolicy(MERGE)
@Config.HotReload(value = 20, unit = MINUTES, type = ASYNC)
public interface SevenSignsConfiguration extends Config {
    @Key("AltRequireCastleForDawn")
    @DefaultValue("false")
    boolean getAltRequireCastleForDawn();

    @Key("AltRequireClanCastle")
    @DefaultValue("false")
    boolean getAltRequireClanCastle();

    @Key("AltFestivalMinPlayer")
    @DefaultValue("5")
    int getAltFestivalMinPlayer();

    @Key("AltMaxPlayerContrib")
    @DefaultValue("1000000")
    int getAltMaxPlayerContrib();

    @Key("AltFestivalManagerStart")
    @DefaultValue("120000")
    int getAltFestivalManagerStart();

    @Key("AltFestivalLength")
    @DefaultValue("1080000")
    int getAltFestivalLength();

    @Key("AltFestivalCycleLength")
    @DefaultValue("2280000")
    int getAltFestivalCycleLength();

    @Key("AltFestivalFirstSpawn")
    @DefaultValue("120000")
    int getAltFestivalFirstSpawn();

    @Key("AltFestivalFirstSwarm")
    @DefaultValue("300000")
    int getAltFestivalFirstSwarm();

    @Key("AltFestivalSecondSpawn")
    @DefaultValue("540000")
    int getAltFestivalSecondSpawn();

    @Key("AltFestivalSecondSwarm")
    @DefaultValue("720000")
    int getAltFestivalSecondSwarm();

    @Key("AltFestivalChestSpawn")
    @DefaultValue("900000")
    int getAltFestivalChestSpawn();
}
