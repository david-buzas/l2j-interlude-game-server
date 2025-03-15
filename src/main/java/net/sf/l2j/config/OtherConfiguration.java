package net.sf.l2j.config;

import org.aeonbits.owner.Config;

import static java.util.concurrent.TimeUnit.MINUTES;
import static org.aeonbits.owner.Config.HotReloadType.ASYNC;
import static org.aeonbits.owner.Config.LoadType.MERGE;

@Config.Sources({
        "system:env",
        "file:${L2J_HOME}/custom/game/config/other.properties",
        "file:./config/other.properties",
        "classpath:config/other.properties"
})
@Config.LoadPolicy(MERGE)
@Config.HotReload(value = 20, unit = MINUTES, type = ASYNC)
public interface OtherConfiguration extends Config {
    @Key("StartingAdena")
    @DefaultValue("100")
    int getStartingAdena();

    @Key("WyvernSpeed")
    @DefaultValue("100")
    int getWyvernSpeed();

    @Key("StriderSpeed")
    @DefaultValue("80")
    int getStriderSpeed();

    @Key("AllowWyvernUpgrader")
    @DefaultValue("true")
    boolean getAllowWyvernUpgrader();

    @Key("CancelLesserEffect")
    @DefaultValue("true")
    boolean getCancelLesserEffect();

    @Key("AllowGuards")
    @DefaultValue("false")
    boolean getAllowGuards();

    @Key("UseDeepBlueDropRules")
    @DefaultValue("true")
    boolean getUseDeepBlueDropRules();

    @Key("MaximumSlotsForNoDwarf")
    @DefaultValue("80")
    int getMaximumSlotsForNoDwarf();

    @Key("MaximumSlotsForDwarf")
    @DefaultValue("100")
    int getMaximumSlotsForDwarf();

    @Key("MaximumSlotsForGMPlayer")
    @DefaultValue("250")
    int getMaximumSlotsForGMPlayer();

    @Key("MaximumWarehouseSlotsForDwarf")
    @DefaultValue("100")
    int getMaximumWarehouseSlotsForDwarf();

    @Key("MaximumWarehouseSlotsForNoDwarf")
    @DefaultValue("120")
    int getMaximumWarehouseSlotsForNoDwarf();

    @Key("MaximumWarehouseSlotsForClan")
    @DefaultValue("150")
    int getMaximumWarehouseSlotsForClan();

    @Key("MaximumFreightSlots")
    @DefaultValue("20")
    int getMaximumFreightSlots();

    @Key("EnchantChanceWeapon")
    @DefaultValue("68")
    int getEnchantChanceWeapon();

    @Key("EnchantChanceArmor")
    @DefaultValue("52")
    int getEnchantChanceArmor();

    @Key("EnchantChanceJewelry")
    @DefaultValue("54")
    int getEnchantChanceJewelry();

    @Key("EnchantMaxWeapon")
    @DefaultValue("255")
    int getEnchantMaxWeapon();

    @Key("EnchantMaxArmor")
    @DefaultValue("255")
    int getEnchantMaxArmor();

    @Key("EnchantMaxJewelry")
    @DefaultValue("255")
    int getEnchantMaxJewelry();

    @Key("EnchantSafeMax")
    @DefaultValue("3")
    int getEnchantSafeMax();

    @Key("EnchantSafeMaxFull")
    @DefaultValue("4")
    int getEnchantSafeMaxFull();

    @Key("HpRegenMultiplier")
    @DefaultValue("100")
    double getHpRegenMultiplier();

    @Key("MpRegenMultiplier")
    @DefaultValue("100")
    double getMpRegenMultiplier();

    @Key("CpRegenMultiplier")
    @DefaultValue("100")
    double getCpRegenMultiplier();

    @Key("RaidHpRegenMultiplier")
    @DefaultValue("100")
    double getRaidHpRegenMultiplier();

    @Key("RaidMpRegenMultiplier")
    @DefaultValue("100")
    double getRaidMpRegenMultiplier();

    @Key("RaidDefenceMultiplier")
    @DefaultValue("100")
    double getRaidDefenceMultiplier();

    @Key("RaidMinRespawnMultiplier")
    @DefaultValue("1.0")
    float getRaidMinRespawnMultiplier();

    @Key("RaidMaxRespawnMultiplier")
    @DefaultValue("1.0")
    float getRaidMaxRespawnMultiplier();

    @Key("RaidMinionRespawnTime")
    @DefaultValue("300000")
    int getRaidMinionRespawnTime();

    @Key("UnstuckInterval")
    @DefaultValue("300")
    int getUnstuckInterval();

    @Key("PlayerSpawnProtection")
    @DefaultValue("0")
    int getPlayerSpawnProtection();

    @Key("PlayerFakeDeathUpProtection")
    @DefaultValue("0")
    int getPlayerFakeDeathUpProtection();

    @Key("PartyXpCutoffMethod")
    @DefaultValue("percentage")
    String getPartyXpCutoffMethod();

    @Key("PartyXpCutoffPercent")
    @DefaultValue("3.")
    float getPartyXpCutoffPercent();

    @Key("PartyXpCutoffLevel")
    @DefaultValue("30")
    int getPartyXpCutoffLevel();

    @Key("RespawnRestoreCP")
    @DefaultValue("0")
    double getRespawnRestoreCP();

    @Key("RespawnRestoreHP")
    @DefaultValue("70")
    double getRespawnRestoreHP();

    @Key("RespawnRestoreMP")
    @DefaultValue("70")
    double getRespawnRestoreMP();

    @Key("RespawnRandomInTown")
    @DefaultValue("false")
    boolean getRespawnRandomInTown();

    @Key("RespawnRandomMaxOffset")
    @DefaultValue("50")
    int getRespawnRandomMaxOffset();

    @Key("MaxPvtStoreSlotsDwarf")
    @DefaultValue("5")
    int getMaxPvtStoreSlotsDwarf();

    @Key("MaxPvtStoreSlotsOther")
    @DefaultValue("4")
    int getMaxPvtStoreSlotsOther();

    @Key("StoreSkillCooltime")
    @DefaultValue("true")
    boolean getStoreSkillCooltime();

    @Key("ListPetRentNpc")
    @DefaultValue("30827")
    String getListPetRentNpc();

    @Key("AnnounceMammonSpawn")
    @DefaultValue("true")
    boolean getAnnounceMammonSpawn();

    @Key("AltPrivilegesAdmin")
    @DefaultValue("false")
    boolean getAltPrivilegesAdmin();

    @Key("AltPrivilegesSecureCheck")
    @DefaultValue("true")
    boolean getAltPrivilegesSecureCheck();

    @Key("AltPrivilegesDefaultLevel")
    @DefaultValue("100")
    int getAltPrivilegesDefaultLevel();

    @Key("GMNameColorEnabled")
    @DefaultValue("false")
    boolean getGMNameColorEnabled();

    @Key("AdminNameColor")
    @DefaultValue("00FF00")
    String getAdminNameColor();

    @Key("GMNameColor")
    @DefaultValue("FFFF00")
    String getGMNameColor();

    @Key("GMHeroAura")
    @DefaultValue("true")
    boolean getGMHeroAura();

    @Key("GMStartupInvulnerable")
    @DefaultValue("true")
    boolean getGMStartupInvulnerable();

    @Key("GMStartupInvisible")
    @DefaultValue("true")
    boolean getGMStartupInvisible();

    @Key("GMStartupSilence")
    @DefaultValue("true")
    boolean getGMStartupSilence();

    @Key("GMStartupAutoList")
    @DefaultValue("true")
    boolean getGMStartupAutoList();

    @Key("GMAdminMenuStyle")
    @DefaultValue("modern")
    String getGMAdminMenuStyle();

    @Key("PetitioningAllowed")
    @DefaultValue("true")
    boolean getPetitioningAllowed();

    @Key("MaxPetitionsPerPlayer")
    @DefaultValue("5")
    int getMaxPetitionsPerPlayer();

    @Key("MaxPetitionsPending")
    @DefaultValue("25")
    int getMaxPetitionsPending();

    @Key("JailIsPvp")
    @DefaultValue("true")
    boolean getJailIsPvp();

    @Key("JailDisableChat")
    @DefaultValue("true")
    boolean getJailDisableChat();

    @Key("DeathPenaltyChance")
    @DefaultValue("20")
    int getDeathPenaltyChance();

    @Key("ListOfNonDroppableItems")
    @DefaultValue("1147,425,1146,461,10,2368,7,6,2370,2369,5598")
    String getListOfNonDroppableItems();
}
