package net.sf.l2j.config;

import org.aeonbits.owner.Config;

import static java.util.concurrent.TimeUnit.MINUTES;
import static org.aeonbits.owner.Config.HotReloadType.ASYNC;
import static org.aeonbits.owner.Config.LoadType.MERGE;

@Config.Sources({
        "system:env",
        "file:${L2J_HOME}/custom/game/config/options.properties",
        "file:./config/options.properties",
        "classpath:config/options.properties"
})
@Config.LoadPolicy(MERGE)
@Config.HotReload(value = 20, unit = MINUTES, type = ASYNC)
public interface OptionsConfiguration extends Config {
    @Key("Debug")
    boolean getDebug();

    @Key("Assert")
    boolean getAssert();

    @Key("Developer")
    boolean getDeveloper();

    @Key("AcceptGeoeditorConn")
    boolean getAcceptGeoeditorConn();

    @Key("TestServer")
    boolean getTestServer();

    @Key("EverybodyHasAdminRights")
    boolean getEverybodyHasAdminRights();

    @Key("ServerListBrackets")
    boolean getServerListBrackets();

    @Key("ServerListClock")
    boolean getServerListClock();

    @Key("ServerGMOnly")
    boolean getServerGMOnly();

    @Key("CoordSynchronize")
    int getCoordSynchronize();

    @Key("ZoneTown")
    int getZoneTown();

    @Key("GlobalChat")
    String getGlobalChat();

    @Key("TradeChat")
    String getTradeChat();

    @Key("DefaultPunish")
    int getDefaultPunish();

    @Key("DefaultPunishParam")
    int getDefaultPunishParam();

    @Key("BypassValidation")
    boolean getBypassValidation();

    @Key("GameGuardEnforce")
    boolean getGameGuardEnforce();

    @Key("GameGuardProhibitAction")
    boolean getGameGuardProhibitAction();

    @Key("DeleteCharAfterDays")
    int getDeleteCharAfterDays();

    @Key("FloodProtectorInitialSize")
    int getFloodProtectorInitialSize();

    @Key("AllowDiscardItem")
    boolean getAllowDiscardItem();

    @Key("AutoDestroyDroppedItemAfter")
    int getAutoDestroyDroppedItemAfter();

    @Key("AutoDestroyHerbTime")
    int getAutoDestroyHerbTime();

    @Key("ListOfProtectedItems")
    String getListOfProtectedItems();

    @Key("DestroyPlayerDroppedItem")
    boolean getDestroyPlayerDroppedItem();

    @Key("DestroyEquipableItem")
    boolean getDestroyEquipableItem();

    @Key("SaveDroppedItem")
    boolean getSaveDroppedItem();

    @Key("EmptyDroppedItemTableAfterLoad")
    boolean getEmptyDroppedItemTableAfterLoad();

    @Key("SaveDroppedItemInterval")
    int getSaveDroppedItemInterval();

    @Key("ClearDroppedItemTable")
    boolean getClearDroppedItemTable();

    @Key("AutoDeleteInvalidQuestData")
    boolean getAutoDeleteInvalidQuestData();

    @Key("PreciseDropCalculation")
    boolean getPreciseDropCalculation();

    @Key("MultipleItemDrop")
    boolean getMultipleItemDrop();

    @Key("ForceInventoryUpdate")
    boolean getForceInventoryUpdate();

    @Key("LazyCache")
    boolean getLazyCache();

    @Key("MaxDriftRange")
    int getMaxDriftRange();

    @Key("MinNPCAnimation")
    int getMinNPCAnimation();

    @Key("MaxNPCAnimation")
    int getMaxNPCAnimation();

    @Key("MinMonsterAnimation")
    int getMinMonsterAnimation();

    @Key("MaxMonsterAnimation")
    int getMaxMonsterAnimation();

    @Key("ShowServerNews")
    boolean getShowServerNews();

    @Key("ShowNpcLevel")
    boolean getShowNpcLevel();

    @Key("ActivatePositionRecorder")
    boolean getActivatePositionRecorder();

    @Key("AllowWarehouse")
    boolean getAllowWarehouse();

    @Key("WarehouseCache")
    boolean getWarehouseCache();

    @Key("WarehouseCacheTime")
    int getWarehouseCacheTime();

    @Key("AllowFreight")
    boolean getAllowFreight();

    @Key("AllowWear")
    boolean getAllowWear();

    @Key("WearDelay")
    int getWearDelay();

    @Key("WearPrice")
    int getWearPrice();

    @Key("AllowLottery")
    boolean getAllowLottery();

    @Key("AllowRace")
    boolean getAllowRace();

    @Key("AllowWater")
    boolean getAllowWater();

    @Key("AllowRentPet")
    boolean getAllowRentPet();

    @Key("AllowFishing")
    boolean getAllowFishing();

    @Key("AllowBoat")
    boolean getAllowBoat();

    @Key("AllowCursedWeapons")
    boolean getAllowCursedWeapons();

    @Key("AllowManor")
    boolean getAllowManor();

    @Key("AllowNpcWalkers")
    boolean getAllowNpcWalkers();

    @Key("AllowL2Walker")
    boolean getAllowL2Walker();

    @Key("L2WalkerRevision")
    int getL2WalkerRevision();

    @Key("AutobanL2WalkerAcc")
    boolean getAutobanL2WalkerAcc();

    @Key("OnlyGMItemsFree")
    boolean getOnlyGMItemsFree();

    @Key("LogChat")
    boolean getLogChat();

    @Key("LogItems")
    boolean getLogItems();

    @Key("GMAudit")
    boolean getGMAudit();

    @Key("CommunityType")
    String getCommunityType();

    @Key("BBSDefault")
    String getBBSDefault();

    @Key("ShowLevelOnCommunityBoard")
    boolean getShowLevelOnCommunityBoard();

    @Key("ShowStatusOnCommunityBoard")
    boolean getShowStatusOnCommunityBoard();

    @Key("NamePageSizeOnCommunityBoard")
    int getNamePageSizeOnCommunityBoard();

    @Key("NamePerRowOnCommunityBoard")
    int getNamePerRowOnCommunityBoard();

    @Key("ThreadPoolSizeEffects")
    int getThreadPoolSizeEffects();

    @Key("ThreadPoolSizeGeneral")
    int getThreadPoolSizeGeneral();

    @Key("UrgentPacketThreadCoreSize")
    int getUrgentPacketThreadCoreSize();

    @Key("GeneralPacketThreadCoreSize")
    int getGeneralPacketThreadCoreSize();

    @Key("GeneralThreadCoreSize")
    int getGeneralThreadCoreSize();

    @Key("AiMaxThread")
    int getAiMaxThread();

    @Key("ExecutorPriLow")
    int getExecutorPriLow();

    @Key("ExecutorPriMed")
    int getExecutorPriMed();

    @Key("ExecutorPriHigh")
    int getExecutorPriHigh();

    @Key("PacketLifeTime")
    int getPacketLifeTime();

    @Key("GridsAlwaysOn")
    boolean getGridsAlwaysOn();

    @Key("GridNeighborTurnOnTime")
    int getGridNeighborTurnOnTime();

    @Key("GridNeighborTurnOffTime")
    int getGridNeighborTurnOffTime();

    @Key("GeoData")
    int getGeoData();

    @Key("ForceGeodata")
    boolean getForceGeodata();
}
