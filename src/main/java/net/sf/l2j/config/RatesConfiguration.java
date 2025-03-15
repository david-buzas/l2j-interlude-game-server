package net.sf.l2j.config;

import org.aeonbits.owner.Config;

import static java.util.concurrent.TimeUnit.MINUTES;
import static org.aeonbits.owner.Config.HotReloadType.ASYNC;
import static org.aeonbits.owner.Config.LoadType.MERGE;

@Config.Sources({
        "system:env",
        "file:${L2J_HOME}/custom/game/config/rates.properties",
        "file:./config/rates.properties",
        "classpath:config/rates.properties"
})
@Config.LoadPolicy(MERGE)
@Config.HotReload(value = 20, unit = MINUTES, type = ASYNC)
public interface RatesConfiguration extends Config {
    @Key("RateXp")
    @DefaultValue("1.")
    float getRateXp();

    @Key("RateSp")
    @DefaultValue("1.")
    float getRateSp();

    @Key("RatePartyXp")
    @DefaultValue("1.")
    float getRatePartyXp();

    @Key("RatePartySp")
    @DefaultValue("1.")
    float getRatePartySp();

    @Key("RateDropAdena")
    @DefaultValue("1.")
    float getRateDropAdena();

    @Key("RateConsumableCost")
    @DefaultValue("1.")
    float getRateConsumableCost();

    @Key("RateDropItems")
    @DefaultValue("1.")
    float getRateDropItems();

    @Key("RateDropSpoil")
    @DefaultValue("1.")
    float getRateDropSpoil();

    @Key("RateDropManor")
    @DefaultValue("1")
    int getRateDropManor();

    @Key("RateDropQuest")
    @DefaultValue("1.")
    float getRateDropQuest();

    @Key("RateQuestsReward")
    @DefaultValue("1.")
    float getRateQuestsReward();

    @Key("RateKarmaExpLost")
    @DefaultValue("1.")
    float getRateKarmaExpLost();

    @Key("RateSiegeGuardsPrice")
    @DefaultValue("1.")
    float getRateSiegeGuardsPrice();

    @Key("PlayerDropLimit")
    @DefaultValue("3")
    int getPlayerDropLimit();

    @Key("PlayerRateDrop")
    @DefaultValue("5")
    int getPlayerRateDrop();

    @Key("PlayerRateDropItem")
    @DefaultValue("70")
    int getPlayerRateDropItem();

    @Key("PlayerRateDropEquip")
    @DefaultValue("25")
    int getPlayerRateDropEquip();

    @Key("PlayerRateDropEquipWeapon")
    @DefaultValue("5")
    int getPlayerRateDropEquipWeapon();

    @Key("KarmaDropLimit")
    @DefaultValue("10")
    int getKarmaDropLimit();

    @Key("KarmaRateDrop")
    @DefaultValue("70")
    int getKarmaRateDrop();

    @Key("KarmaRateDropItem")
    @DefaultValue("50")
    int getKarmaRateDropItem();

    @Key("KarmaRateDropEquip")
    @DefaultValue("40")
    int getKarmaRateDropEquip();

    @Key("KarmaRateDropEquipWeapon")
    @DefaultValue("10")
    int getKarmaRateDropEquipWeapon();

    @Key("PetXpRate")
    @DefaultValue("1.")
    float getPetXpRate();

    @Key("PetFoodRate")
    @DefaultValue("1")
    int getPetFoodRate();

    @Key("SinEaterXpRate")
    @DefaultValue("1.")
    float getSinEaterXpRate();

    @Key("RateCommonHerbs")
    @DefaultValue("15.")
    float getRateCommonHerbs();

    @Key("RateHpMpHerbs")
    @DefaultValue("10.")
    float getRateHpMpHerbs();

    @Key("RateGreaterHerbs")
    @DefaultValue("4.")
    float getRateGreaterHerbs();

    @Key("RateSuperiorHerbs")
    @DefaultValue("0.8")
    float getRateSuperiorHerbs();

    @Key("RateSpecialHerbs")
    @DefaultValue("0.2")
    float getRateSpecialHerbs();
}
