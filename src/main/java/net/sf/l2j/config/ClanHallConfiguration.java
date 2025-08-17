package net.sf.l2j.config;

import org.aeonbits.owner.Config;

import static java.util.concurrent.TimeUnit.MINUTES;
import static org.aeonbits.owner.Config.HotReloadType.ASYNC;
import static org.aeonbits.owner.Config.LoadType.MERGE;

/**
 * Configuration for Clan Hall function prices.
 * <p>
 * All prices are for 7 days unless otherwise noted.
 * </p>
 */
@Config.Sources({
        "system:env",
        "file:${L2J_HOME}/custom/game/config/clanhall.properties",
        "file:./config/clanhall.properties",
        "classpath:config/clanhall.properties"
})
@Config.LoadPolicy(MERGE)
@Config.HotReload(value = 20, unit = MINUTES, type = ASYNC)
public interface ClanHallConfiguration extends Config {

    // =============================================================
    // Teleport Function price (price = 7 days; one day price = price / 7)
    // =============================================================

    /** Teleport Function fee - 1st level */
    @Key("ClanHallTeleportFunctionFeeLvl1")
    @DefaultValue("7000")
    int getClanHallTeleportFunctionFeeLvl1();

    /** Teleport Function fee - 2nd level */
    @Key("ClanHallTeleportFunctionFeeLvl2")
    @DefaultValue("14000")
    int getClanHallTeleportFunctionFeeLvl2();

    // =============================================================
    // Support magic buff price
    // =============================================================

    /** Support magic buff fee - 1st level */
    @Key("ClanHallSupportFeeLvl1")
    @DefaultValue("17500")
    int getClanHallSupportFeeLvl1();

    /** Support magic buff fee - 2nd level */
    @Key("ClanHallSupportFeeLvl2")
    @DefaultValue("35000")
    int getClanHallSupportFeeLvl2();

    /** Support magic buff fee - 3rd level */
    @Key("ClanHallSupportFeeLvl3")
    @DefaultValue("49000")
    int getClanHallSupportFeeLvl3();

    /** Support magic buff fee - 4th level */
    @Key("ClanHallSupportFeeLvl4")
    @DefaultValue("77000")
    int getClanHallSupportFeeLvl4();

    /** Support magic buff fee - 5th level */
    @Key("ClanHallSupportFeeLvl5")
    @DefaultValue("147000")
    int getClanHallSupportFeeLvl5();

    /** Support magic buff fee - 6th level */
    @Key("ClanHallSupportFeeLvl6")
    @DefaultValue("252000")
    int getClanHallSupportFeeLvl6();

    /** Support magic buff fee - 7th level */
    @Key("ClanHallSupportFeeLvl7")
    @DefaultValue("259000")
    int getClanHallSupportFeeLvl7();

    /** Support magic buff fee - 8th level */
    @Key("ClanHallSupportFeeLvl8")
    @DefaultValue("364000")
    int getClanHallSupportFeeLvl8();

    // =============================================================
    // MP Regeneration price
    // =============================================================

    /** 5% MP Regeneration fee */
    @Key("ClanHallMpRegenerationFeeLvl1")
    @DefaultValue("14000")
    int getClanHallMpRegenerationFeeLvl1();

    /** 10% MP Regeneration fee */
    @Key("ClanHallMpRegenerationFeeLvl2")
    @DefaultValue("26250")
    int getClanHallMpRegenerationFeeLvl2();

    /** 15% MP Regeneration fee */
    @Key("ClanHallMpRegenerationFeeLvl3")
    @DefaultValue("45500")
    int getClanHallMpRegenerationFeeLvl3();

    /** 30% MP Regeneration fee */
    @Key("ClanHallMpRegenerationFeeLvl4")
    @DefaultValue("96250")
    int getClanHallMpRegenerationFeeLvl4();

    /** 40% MP Regeneration fee */
    @Key("ClanHallMpRegenerationFeeLvl5")
    @DefaultValue("140000")
    int getClanHallMpRegenerationFeeLvl5();

    // =============================================================
    // HP Regeneration price
    // =============================================================

    /** 20% HP Regeneration fee */
    @Key("ClanHallHpRegenerationFeeLvl1")
    @DefaultValue("4900")
    int getClanHallHpRegenerationFeeLvl1();

    /** 40% HP Regeneration fee */
    @Key("ClanHallHpRegenerationFeeLvl2")
    @DefaultValue("5600")
    int getClanHallHpRegenerationFeeLvl2();

    /** 80% HP Regeneration fee */
    @Key("ClanHallHpRegenerationFeeLvl3")
    @DefaultValue("7000")
    int getClanHallHpRegenerationFeeLvl3();

    /** 100% HP Regeneration fee */
    @Key("ClanHallHpRegenerationFeeLvl4")
    @DefaultValue("8166")
    int getClanHallHpRegenerationFeeLvl4();

    /** 120% HP Regeneration fee */
    @Key("ClanHallHpRegenerationFeeLvl5")
    @DefaultValue("10500")
    int getClanHallHpRegenerationFeeLvl5();

    /** 140% HP Regeneration fee */
    @Key("ClanHallHpRegenerationFeeLvl6")
    @DefaultValue("12250")
    int getClanHallHpRegenerationFeeLvl6();

    /** 160% HP Regeneration fee */
    @Key("ClanHallHpRegenerationFeeLvl7")
    @DefaultValue("14000")
    int getClanHallHpRegenerationFeeLvl7();

    /** 180% HP Regeneration fee */
    @Key("ClanHallHpRegenerationFeeLvl8")
    @DefaultValue("15750")
    int getClanHallHpRegenerationFeeLvl8();

    /** 200% HP Regeneration fee */
    @Key("ClanHallHpRegenerationFeeLvl9")
    @DefaultValue("17500")
    int getClanHallHpRegenerationFeeLvl9();

    /** 220% HP Regeneration fee */
    @Key("ClanHallHpRegenerationFeeLvl10")
    @DefaultValue("22750")
    int getClanHallHpRegenerationFeeLvl10();

    /** 240% HP Regeneration fee */
    @Key("ClanHallHpRegenerationFeeLvl11")
    @DefaultValue("26250")
    int getClanHallHpRegenerationFeeLvl11();

    /** 260% HP Regeneration fee */
    @Key("ClanHallHpRegenerationFeeLvl12")
    @DefaultValue("29750")
    int getClanHallHpRegenerationFeeLvl12();

    /** 300% HP Regeneration fee */
    @Key("ClanHallHpRegenerationFeeLvl13")
    @DefaultValue("36166")
    int getClanHallHpRegenerationFeeLvl13();

    // =============================================================
    // EXP Regeneration price
    // =============================================================

    /** 5% EXP Regeneration fee */
    @Key("ClanHallExpRegenerationFeeLvl1")
    @DefaultValue("21000")
    int getClanHallExpRegenerationFeeLvl1();

    /** 10% EXP Regeneration fee */
    @Key("ClanHallExpRegenerationFeeLvl2")
    @DefaultValue("42000")
    int getClanHallExpRegenerationFeeLvl2();

    /** 15% EXP Regeneration fee */
    @Key("ClanHallExpRegenerationFeeLvl3")
    @DefaultValue("63000")
    int getClanHallExpRegenerationFeeLvl3();

    /** 25% EXP Regeneration fee */
    @Key("ClanHallExpRegenerationFeeLvl4")
    @DefaultValue("105000")
    int getClanHallExpRegenerationFeeLvl4();

    /** 35% EXP Regeneration fee */
    @Key("ClanHallExpRegenerationFeeLvl5")
    @DefaultValue("147000")
    int getClanHallExpRegenerationFeeLvl5();

    /** 40% EXP Regeneration fee */
    @Key("ClanHallExpRegenerationFeeLvl6")
    @DefaultValue("163331")
    int getClanHallExpRegenerationFeeLvl6();

    /** 50% EXP Regeneration fee */
    @Key("ClanHallExpRegenerationFeeLvl7")
    @DefaultValue("210000")
    int getClanHallExpRegenerationFeeLvl7();

    // =============================================================
    // Item Creation function
    // =============================================================

    /** Item Creation fee - 1st level */
    @Key("ClanHallItemCreationFunctionFeeLvl1")
    @DefaultValue("210000")
    int getClanHallItemCreationFunctionFeeLvl1();

    /** Item Creation fee - 2nd level */
    @Key("ClanHallItemCreationFunctionFeeLvl2")
    @DefaultValue("490000")
    int getClanHallItemCreationFunctionFeeLvl2();

    /** Item Creation fee - 3rd level */
    @Key("ClanHallItemCreationFunctionFeeLvl3")
    @DefaultValue("980000")
    int getClanHallItemCreationFunctionFeeLvl3();

    // =============================================================
    // Decor function
    // =============================================================

    /** Curtain Decoration fee - 1st level */
    @Key("ClanHallCurtainFunctionFeeLvl1")
    @DefaultValue("2002")
    int getClanHallCurtainFunctionFeeLvl1();

    /** Curtain Decoration fee - 2nd level */
    @Key("ClanHallCurtainFunctionFeeLvl2")
    @DefaultValue("2625")
    int getClanHallCurtainFunctionFeeLvl2();

    /** Front Platform Decoration fee - 1st level */
    @Key("ClanHallFrontPlatformFunctionFeeLvl1")
    @DefaultValue("3031")
    int getClanHallFrontPlatformFunctionFeeLvl1();

    /** Front Platform Decoration fee - 2nd level */
    @Key("ClanHallFrontPlatformFunctionFeeLvl2")
    @DefaultValue("9331")
    int getClanHallFrontPlatformFunctionFeeLvl2();

    // =============================================================
    // Defaults, not included in properties file
    // =============================================================

    @Key("ClanHallTeleportFunctionFeeRation")
    @DefaultValue("86400000")
    int getClanHallTeleportFunctionFeeRation();

    @Key("ClanHallItemCreationFunctionFeeRation")
    @DefaultValue("86400000")
    int getClanHallItemCreationFunctionFeeRation();

    @Key("ClanHallMpRegenerationFunctionFeeRation")
    @DefaultValue("86400000")
    int getClanHallMpRegenerationFunctionFeeRation();

    @Key("ClanHallHpRegenerationFunctionFeeRation")
    @DefaultValue("86400000")
    int getClanHallHpRegenerationFunctionFeeRation();

    @Key("ClanHallExpRegenerationFunctionFeeRation")
    @DefaultValue("86400000")
    int getClanHallExpRegenerationFunctionFeeRation();

    @Key("ClanHallSupportFunctionFeeRation")
    @DefaultValue("86400000")
    int getClanHallSupportFunctionFeeRation();

    @Key("ClanHallCurtainFunctionFeeRation")
    @DefaultValue("86400000")
    int getClanHallCurtainFunctionFeeRation();

    @Key("ClanHallFrontPlatformFunctionFeeRation")
    @DefaultValue("86400000")
    int getClanHallFrontPlatformFunctionFeeRation();
}
