package net.sf.l2j.config;

import org.aeonbits.owner.Config;

import static java.util.concurrent.TimeUnit.MINUTES;
import static org.aeonbits.owner.Config.HotReloadType.ASYNC;
import static org.aeonbits.owner.Config.LoadType.MERGE;

/**
 * AltSettingsConfiguration maps directly to altsettings.properties.
 * All keys, defaults, and comments are preserved from the file.
 */
@Config.Sources({
        "system:env",
        "file:${L2J_HOME}/custom/game/config/altsettings.properties",
        "file:./config/altsettings.properties",
        "classpath:config/altsettings.properties"
})
@Config.LoadPolicy(MERGE)
@Config.HotReload(value = 20, unit = MINUTES, type = ASYNC)
public interface AltSettingsConfiguration extends Config {

    //=============================================================
    //                WARNING                WARNING
    //=============================================================
    // These settings modify your server's behaviour away from retail.
    // They are intended for special or small servers.
    //=============================================================

    // -------------------------------------------------------------
    // Server config
    // -------------------------------------------------------------

    /** AutoLoot enable... True to enable, False to disable */
    @Key("AutoLoot")
    @DefaultValue("False")
    boolean getAutoLoot();

    /** If False herbs will drop on ground even if AutoLoot is enabled */
    @Key("AutoLootHerbs")
    @DefaultValue("False")
    boolean getAutoLootHerbs();

    /** AutoLearnSkills... True to enable, False to disable */
    @Key("AutoLearnSkills")
    @DefaultValue("False")
    boolean getAutoLearnSkills();

    /** Party range for l2attackable (default 1600) */
    @Key("AltPartyRange")
    @DefaultValue("1600")
    int getAltPartyRange();

    /** Party range for l2party (default 1400) */
    @Key("AltPartyRange2")
    @DefaultValue("1400")
    int getAltPartyRange2();

    /** Weight Limit multiplier - default 1 */
    @Key("AltWeightLimit")
    @DefaultValue("1")
    int getAltWeightLimit();

    /** If XP loss (and deleveling) is enabled, default is 'true' */
    @Key("Delevel")
    @DefaultValue("True")
    boolean getDelevel();

    /** If disabled, magic dmg has always 100% chance of success, default is 'true' */
    @Key("MagicFailures")
    @DefaultValue("True")
    boolean getMagicFailures();

    /** Alternative cancel of attack (bow, cast, all) */
    @Key("AltGameCancelByHit")
    @DefaultValue("cast")
    String getAltGameCancelByHit();

    /**
     * Alternative rules for shields:
     * if they block, damage = powerAtk - shieldDef
     * else damage = powerAtk / (shieldDef + powerDef)
     */
    @Key("AltShieldBlocks")
    @DefaultValue("False")
    boolean getAltShieldBlocks();

    /** Alternative Rate Value for Perfect Shield Block Rate. */
    @Key("AltPerfectShieldBlockRate")
    @DefaultValue("5")
    int getAltPerfectShieldBlockRate();

    /** Alternative AltGameMobAttackAI, like C1 */
    @Key("AltGameMobAttackAI")
    @DefaultValue("False")
    boolean getAltGameMobAttackAI();

    /** Alternative mob behavior in peace zones (default True) */
    @Key("AltMobAgroInPeaceZone")
    @DefaultValue("True")
    boolean getAltMobAgroInPeaceZone();

    /**
     * Alternative Freight mode: if true, freights can be withdrawn from anywhere.
     * Possibility to change Freight price per slot.
     */
    @Key("AltGameFreights")
    @DefaultValue("True")
    boolean getAltGameFreights();

    /** Freight price per slot (adena) */
    @Key("AltGameFreightPrice")
    @DefaultValue("1000")
    int getAltGameFreightPrice();

    /**
     * Alternative XP/SP rewards formula coefficient for XP.
     * See altsettings.properties for full formula description.
     */
    @Key("AltGameExponentXp")
    @DefaultValue("0")
    int getAltGameExponentXp();

    /** Same as above but for SP. */
    @Key("AltGameExponentSp")
    @DefaultValue("0")
    int getAltGameExponentSp();

    /** Use tiredness instead of combat points */
    @Key("AltGameTiredness")
    @DefaultValue("False")
    boolean getAltGameTiredness();

    @Key("AltGameViewNpc")
    @DefaultValue("False")
    boolean getAltGameViewNpc();

    // -------------------------------------------------------------
    // Alternative settings against player with karma
    // -------------------------------------------------------------

    /** Can karma players be killed in peace zone? */
    @Key("AltKarmaPlayerCanBeKilledInPeaceZone")
    @DefaultValue("False")
    boolean getAltKarmaPlayerCanBeKilledInPeaceZone();

    /** Can karma players shop? */
    @Key("AltKarmaPlayerCanShop")
    @DefaultValue("True")
    boolean getAltKarmaPlayerCanShop();

    /** Can karma players use Scroll of Escape or Return skill? */
    @Key("AltKarmaPlayerCanTeleport")
    @DefaultValue("True")
    boolean getAltKarmaPlayerCanTeleport();

    /** Can karma players use Gatekeepers (GK)? */
    @Key("AltKarmaPlayerCanUseGK")
    @DefaultValue("False")
    boolean getAltKarmaPlayerCanUseGK();

    /** Can karma players trade? */
    @Key("AltKarmaPlayerCanTrade")
    @DefaultValue("True")
    boolean getAltKarmaPlayerCanTrade();

    /** Can karma players use warehouse? */
    @Key("AltKarmaPlayerCanUseWareHouse")
    @DefaultValue("True")
    boolean getAltKarmaPlayerCanUseWareHouse();

    /** Allow free teleportation around the world */
    @Key("AltFreeTeleporting")
    @DefaultValue("False")
    boolean getAltFreeTeleporting();

    /** Disallow recommending a character twice or more per day */
    @Key("AltRecommend")
    @DefaultValue("False")
    boolean getAltRecommend();

    // -------------------------------------------------------------
    // Crafting config
    // -------------------------------------------------------------

    /** Crafting enabled/disabled */
    @Key("CraftingEnabled")
    @DefaultValue("True")
    boolean getCraftingEnabled();

    /** Dwarf recipe limit (default 50) */
    @Key("DwarfRecipeLimit")
    @DefaultValue("50")
    int getDwarfRecipeLimit();

    /** Common recipe limit (default 50) */
    @Key("CommonRecipeLimit")
    @DefaultValue("50")
    int getCommonRecipeLimit();

    /** Alternative crafting rules: takes time, XP/SP reward */
    @Key("AltGameCreation")
    @DefaultValue("False")
    boolean getAltGameCreation();

    /** Crafting time multiplier */
    @Key("AltGameCreationSpeed")
    @DefaultValue("1")
    int getAltGameCreationSpeed();

    /** Crafting XP multiplier */
    @Key("AltGameCreationRateXp")
    @DefaultValue("1")
    int getAltGameCreationRateXp();

    /** Crafting SP multiplier */
    @Key("AltGameCreationRateSp")
    @DefaultValue("1")
    int getAltGameCreationRateSp();

    /** If false, blacksmiths don't consume recipes from inventory */
    @Key("AltBlacksmithUseRecipes")
    @DefaultValue("True")
    boolean getAltBlacksmithUseRecipes();

    // -------------------------------------------------------------
    // Skills config
    // -------------------------------------------------------------

    /** Allow Class Masters for changing occupation */
    @Key("AllowClassMasters")
    @DefaultValue("False")
    boolean getAllowClassMasters();

    /** Life crystal needed to learn clan skills */
    @Key("LifeCrystalNeeded")
    @DefaultValue("True")
    boolean getLifeCrystalNeeded();

    /** Spell book needed to learn skills */
    @Key("SpBookNeeded")
    @DefaultValue("True")
    boolean getSpBookNeeded();

    /** Book needed to enchant skills */
    @Key("EnchantSkillSpBookNeeded")
    @DefaultValue("True")
    boolean getEnchantSkillSpBookNeeded();

    /** Alternative skill learning rules */
    @Key("AltGameSkillLearn")
    @DefaultValue("False")
    boolean getAltGameSkillLearn();

    /** Allow subclass without quest requirements */
    @Key("AltSubClassWithoutQuests")
    @DefaultValue("False")
    boolean getAltSubClassWithoutQuests();

    // -------------------------------------------------------------
    // Buffs config
    // -------------------------------------------------------------

    /** Maximum number of buffs (default 24 in C5) */
    @Key("maxbuffamount")
    @DefaultValue("24")
    String getMaxBuffAmount();

    // -------------------------------------------------------------
    // Clans config
    // -------------------------------------------------------------

    /** Days before joining another clan */
    @Key("DaysBeforeJoinAClan")
    @DefaultValue("1")
    int getDaysBeforeJoinAClan();

    /** Days before creating a new clan */
    @Key("DaysBeforeCreateAClan")
    @DefaultValue("10")
    int getDaysBeforeCreateAClan();

    /** Days to dissolve a clan */
    @Key("DaysToPassToDissolveAClan")
    @DefaultValue("7")
    int getDaysToPassToDissolveAClan();

    /** Days before joining a new ally after leaving */
    @Key("DaysBeforeJoinAllyWhenLeaved")
    @DefaultValue("1")
    int getDaysBeforeJoinAllyWhenLeaved();

    /** Days before joining a new ally when dismissed */
    @Key("DaysBeforeJoinAllyWhenDismissed")
    @DefaultValue("1")
    int getDaysBeforeJoinAllyWhenDismissed();

    /** Days before accepting a new clan after dismissal */
    @Key("DaysBeforeAcceptNewClanWhenDismissed")
    @DefaultValue("1")
    int getDaysBeforeAcceptNewClanWhenDismissed();

    /** Days before creating a new ally when dissolved */
    @Key("DaysBeforeCreateNewAllyWhenDissolved")
    @DefaultValue("10")
    int getDaysBeforeCreateNewAllyWhenDissolved();

    /** Max clans in alliance */
    @Key("AltMaxNumOfClansInAlly")
    @DefaultValue("3")
    int getAltMaxNumOfClansInAlly();

    /** Clan members required for war */
    @Key("AltClanMembersForWar")
    @DefaultValue("15")
    int getAltClanMembersForWar();

    /** All new chars of the account are newbies */
    @Key("AltNewCharAlwaysIsNewbie")
    @DefaultValue("True")
    boolean getAltNewCharAlwaysIsNewbie();

    /** Members can withdraw from clan warehouse */
    @Key("AltMembersCanWithdrawFromClanWH")
    @DefaultValue("False")
    boolean getAltMembersCanWithdrawFromClanWH();

    /** Remove castle circlets after losing castle */
    @Key("RemoveCastleCirclets")
    @DefaultValue("True")
    boolean getRemoveCastleCirclets();

    // -------------------------------------------------------------
    // Olympiad config
    // -------------------------------------------------------------

    /** Olympiad start time (hour) */
    @Key("AltOlyStartTime")
    @DefaultValue("18")
    int getAltOlyStartTime();

    /** Olympiad start time (minute) */
    @Key("AltOlyMin")
    @DefaultValue("00")
    int getAltOlyMin();

    /** Olympiad competition period (ms) */
    @Key("AltOlyCPeriod")
    @DefaultValue("21600000")
    long getAltOlyCPeriod();

    /** Olympiad battle period (ms) */
    @Key("AltOlyBattle")
    @DefaultValue("360000")
    long getAltOlyBattle();

    /** Olympiad battle wait (ms) */
    @Key("AltOlyBWait")
    @DefaultValue("600000")
    long getAltOlyBWait();

    /** Olympiad initial wait (ms) */
    @Key("AltOlyIWait")
    @DefaultValue("300000")
    long getAltOlyIWait();

    /** Olympiad weekly period (ms) */
    @Key("AltOlyWPeriod")
    @DefaultValue("604800000")
    long getAltOlyWPeriod();

    /** Olympiad validation period (ms) */
    @Key("AltOlyVPeriod")
    @DefaultValue("86400000")
    long getAltOlyVPeriod();

    // -------------------------------------------------------------
    // Manor config
    // -------------------------------------------------------------

    /** Manor refresh hour */
    @Key("AltManorRefreshTime")
    @DefaultValue("20")
    int getAltManorRefreshTime();

    /** Manor refresh minute */
    @Key("AltManorRefreshMin")
    @DefaultValue("00")
    int getAltManorRefreshMin();

    /** Manor approve hour */
    @Key("AltManorApproveTime")
    @DefaultValue("6")
    int getAltManorApproveTime();

    /** Manor approve minute */
    @Key("AltManorApproveMin")
    @DefaultValue("00")
    int getAltManorApproveMin();

    /** Manor maintenance period (ms) */
    @Key("AltManorMaintenancePeriod")
    @DefaultValue("360000")
    int getAltManorMaintenancePeriod();

    /** Manor save all actions */
    @Key("AltManorSaveAllActions")
    @DefaultValue("True")
    boolean getAltManorSaveAllActions();

    /** Manor save period rate (hours) */
    @Key("AltManorSavePeriodRate")
    @DefaultValue("2")
    int getAltManorSavePeriodRate();

    // -------------------------------------------------------------
    // Lottery config
    // -------------------------------------------------------------

    /** Initial lottery prize */
    @Key("AltLotteryPrize")
    @DefaultValue("50000")
    int getAltLotteryPrize();

    /** Lottery ticket price */
    @Key("AltLotteryTicketPrice")
    @DefaultValue("2000")
    int getAltLotteryTicketPrice();

    /** 5 number jackpot share */
    @Key("AltLottery5NumberRate")
    @DefaultValue("0.6")
    float getAltLottery5NumberRate();

    /** 4 number jackpot share */
    @Key("AltLottery4NumberRate")
    @DefaultValue("0.2")
    float getAltLottery4NumberRate();

    /** 3 number jackpot share */
    @Key("AltLottery3NumberRate")
    @DefaultValue("0.2")
    float getAltLottery3NumberRate();

    /** Prize for 2 or 1 winning numbers */
    @Key("AltLottery2and1NumberPrize")
    @DefaultValue("200")
    int getAltLottery2and1NumberPrize();

    // -------------------------------------------------------------
    // Debug & Dev config
    // -------------------------------------------------------------

    /** Don't load quests */
    @Key("AltDevNoQuests")
    @DefaultValue("False")
    boolean getAltDevNoQuests();

    /** Don't load spawns */
    @Key("AltDevNoSpawns")
    @DefaultValue("False")
    boolean getAltDevNoSpawns();

    // -------------------------------------------------------------
    // Dimension Rift config
    // -------------------------------------------------------------

    /** Minimal party size to enter rift */
    @Key("RiftMinPartySize")
    @DefaultValue("5")
    int getRiftMinPartySize();

    /** Maximum jumps between rift rooms */
    @Key("MaxRiftJumps")
    @DefaultValue("4")
    int getMaxRiftJumps();

    /** Delay before mobs spawn in rift room (ms) */
    @Key("RiftSpawnDelay")
    @DefaultValue("10000")
    int getRiftSpawnDelay();

    /** Minimum delay between automatic jumps (s) */
    @Key("AutoJumpsDelayMin")
    @DefaultValue("480")
    int getAutoJumpsDelayMin();

    /** Maximum delay between automatic jumps (s) */
    @Key("AutoJumpsDelayMax")
    @DefaultValue("600")
    int getAutoJumpsDelayMax();

    /** Boss room stay time multiplier */
    @Key("BossRoomTimeMultiply")
    @DefaultValue("1.5")
    float getBossRoomTimeMultiply();

    /** Rift entry cost for Recruit */
    @Key("RecruitCost")
    @DefaultValue("18")
    int getRecruitCost();

    /** Rift entry cost for Soldier */
    @Key("SoldierCost")
    @DefaultValue("21")
    int getSoldierCost();

    /** Rift entry cost for Officer */
    @Key("OfficerCost")
    @DefaultValue("24")
    int getOfficerCost();

    /** Rift entry cost for Captain */
    @Key("CaptainCost")
    @DefaultValue("27")
    int getCaptainCost();

    /** Rift entry cost for Commander */
    @Key("CommanderCost")
    @DefaultValue("30")
    int getCommanderCost();

    /** Rift entry cost for Hero */
    @Key("HeroCost")
    @DefaultValue("33")
    int getHeroCost();
}
