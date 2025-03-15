package net.sf.l2j.config;

import org.aeonbits.owner.Config;

import static java.util.concurrent.TimeUnit.MINUTES;
import static org.aeonbits.owner.Config.HotReloadType.ASYNC;
import static org.aeonbits.owner.Config.LoadType.MERGE;

@Config.Sources({
        "system:env",
        "file:${L2J_HOME}/custom/game/config/l2jmods.properties",
        "file:./config/l2jmods.properties",
        "classpath:config/l2jmods.properties"
})
@Config.LoadPolicy(MERGE)
@Config.HotReload(value = 20, unit = MINUTES, type = ASYNC)
public interface L2JModsConfiguration extends Config {
    @Key("ChampionEnable")
    @DefaultValue("false")
    boolean getChampionEnable();

    @Key("ChampionFrequency")
    @DefaultValue("0")
    int getChampionFrequency();

    @Key("ChampionMinLevel")
    @DefaultValue("20")
    int getChampionMinLevel();

    @Key("ChampionMaxLevel")
    @DefaultValue("60")
    int getChampionMaxLevel();

    @Key("ChampionHp")
    @DefaultValue("7")
    int getChampionHp();

    @Key("ChampionRegenHp")
    @DefaultValue("1.")
    float getChampionRegenHp();

    @Key("ChampionRewards")
    @DefaultValue("8")
    int getChampionRewards();

    @Key("ChampionAdenasRewards")
    @DefaultValue("1")
    int getChampionAdenasRewards();

    @Key("ChampionAtk")
    @DefaultValue("1.")
    float getChampionAtk();

    @Key("ChampionSpdAtk")
    @DefaultValue("1.")
    float getChampionSpdAtk();

    @Key("ChampionRewardItem")
    @DefaultValue("0")
    int getChampionRewardItem();

    @Key("ChampionRewardItemID")
    @DefaultValue("6393")
    int getChampionRewardItemID();

    @Key("ChampionRewardItemQty")
    @DefaultValue("1")
    int getChampionRewardItemQty();

    @Key("AllowWedding")
    @DefaultValue("false")
    boolean getAllowWedding();

    @Key("WeddingPrice")
    @DefaultValue("250000000")
    int getWeddingPrice();

    @Key("WeddingPunishInfidelity")
    @DefaultValue("true")
    boolean getWeddingPunishInfidelity();

    @Key("WeddingTeleport")
    @DefaultValue("true")
    boolean getWeddingTeleport();

    @Key("WeddingTeleportPrice")
    @DefaultValue("50000")
    int getWeddingTeleportPrice();

    @Key("WeddingTeleportDuration")
    @DefaultValue("60")
    int getWeddingTeleportDuration();

    @Key("WeddingAllowSameSex")
    @DefaultValue("false")
    boolean getWeddingAllowSameSex();

    @Key("WeddingFormalWear")
    @DefaultValue("true")
    boolean getWeddingFormalWear();

    @Key("WeddingDivorceCosts")
    @DefaultValue("60")
    int getWeddingDivorceCosts();

    @Key("TvTEventEnabled")
    @DefaultValue("false")
    boolean getTvTEventEnabled();

    @Key("TvTEventInterval")
    @DefaultValue("18000")
    int getTvTEventInterval();

    @Key("TvTEventParticipationTime")
    @DefaultValue("3600")
    int getTvTEventParticipationTime();

    @Key("TvTEventRunningTime")
    @DefaultValue("1800")
    int getTvTEventRunningTime();

    @Key("TvTEventParticipationNpcId")
    @DefaultValue("0")
    int getTvTEventParticipationNpcId();

    @Key("TvTEventParticipationNpcCoordinates")
    @DefaultValue("0,0,0")
    String getTvTEventParticipationNpcCoordinates();

    @Key("TvTEventMinPlayersInTeams")
    @DefaultValue("1")
    int getTvTEventMinPlayersInTeams();

    @Key("TvTEventMaxPlayersInTeams")
    @DefaultValue("20")
    int getTvTEventMaxPlayersInTeams();

    @Key("TvTEventMinPlayerLevel")
    @DefaultValue("1")
    byte getTvTEventMinPlayerLevel();

    @Key("TvTEventMaxPlayerLevel")
    @DefaultValue("80")
    byte getTvTEventMaxPlayerLevel();

    @Key("TvTEventRespawnTeleportDelay")
    @DefaultValue("20")
    int getTvTEventRespawnTeleportDelay();

    @Key("TvTEventStartLeaveTeleportDelay")
    @DefaultValue("20")
    int getTvTEventStartLeaveTeleportDelay();

    @Key("TvTEventTeam1Name")
    @DefaultValue("Team1")
    String getTvTEventTeam1Name();

    @Key("TvTEventTeam1Coordinates")
    @DefaultValue("0,0,0")
    String getTvTEventTeam1Coordinates();

    @Key("TvTEventTeam2Name")
    @DefaultValue("Team2")
    String getTvTEventTeam2Name();

    @Key("TvTEventTeam2Coordinates")
    @DefaultValue("0,0,0")
    String getTvTEventTeam2Coordinates();

    @Key("TvTEventReward")
    @DefaultValue("57,100000")
    String getTvTEventReward();

    @Key("TvTEventTargetTeamMembersAllowed")
    @DefaultValue("true")
    boolean getTvTEventTargetTeamMembersAllowed();

    @Key("TvTEventPotionsAllowed")
    @DefaultValue("false")
    boolean getTvTEventPotionsAllowed();

    @Key("TvTEventSummonByItemAllowed")
    @DefaultValue("false")
    boolean getTvTEventSummonByItemAllowed();

    @Key("TvTEventDoorsCloseOpenOnStartEnd")
    @DefaultValue("")
    String getTvTEventDoorsCloseOpenOnStartEnd();
}
