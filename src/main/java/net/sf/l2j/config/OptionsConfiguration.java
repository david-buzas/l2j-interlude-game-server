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
    @DefaultValue("false")
    boolean getDebug();

    @Key("Assert")
    @DefaultValue("false")
    boolean getAssert();

    @Key("Developer")
    @DefaultValue("false")
    boolean getDeveloper();

    @Key("AcceptGeoeditorConn")
    @DefaultValue("false")
    boolean getAcceptGeoeditorConn();

    @Key("TestServer")
    @DefaultValue("false")
    boolean getTestServer();

    @Key("EverybodyHasAdminRights")
    @DefaultValue("false")
    boolean getEverybodyHasAdminRights();

    @Key("ServerListBrackets")
    @DefaultValue("false")
    boolean getServerListBrackets();

    @Key("ServerListClock")
    @DefaultValue("false")
    boolean getServerListClock();

    @Key("ServerGMOnly")
    @DefaultValue("false")
    boolean getServerGMOnly();

    @Key("CoordSynchronize")
    @DefaultValue("-1")
    int getCoordSynchronize();

    @Key("ZoneTown")
    @DefaultValue("0")
    int getZoneTown();

    @Key("GlobalChat")
    @DefaultValue("ON")
    String getGlobalChat();

    @Key("TradeChat")
    @DefaultValue("ON")
    String getTradeChat();

    @Key("DefaultPunish")
    @DefaultValue("2")
    int getDefaultPunish();

    @Key("DefaultPunishParam")
    @DefaultValue("0")
    int getDefaultPunishParam();

    @Key("BypassValidation")
    @DefaultValue("true")
    boolean getBypassValidation();

    @Key("GameGuardEnforce")
    @DefaultValue("false")
    boolean getGameGuardEnforce();

    @Key("GameGuardProhibitAction")
    @DefaultValue("false")
    boolean getGameGuardProhibitAction();

    @Key("DeleteCharAfterDays")
    @DefaultValue("7")
    int getDeleteCharAfterDays();

    @Key("FloodProtectorInitialSize")
    @DefaultValue("50")
    int getFloodProtectorInitialSize();

    @Key("AllowDiscardItem")
    @DefaultValue("true")
    boolean getAllowDiscardItem();

    @Key("AutoDestroyDroppedItemAfter")
    @DefaultValue("0")
    int getAutoDestroyDroppedItemAfter();

    @Key("AutoDestroyHerbTime")
    @DefaultValue("15")
    int getAutoDestroyHerbTime();

    @Key("ListOfProtectedItems")
    @DefaultValue("")
    String getListOfProtectedItems();

    @Key("DestroyPlayerDroppedItem")
    @DefaultValue("false")
    boolean getDestroyPlayerDroppedItem();

    @Key("DestroyEquipableItem")
    @DefaultValue("false")
    boolean getDestroyEquipableItem();

    @Key("SaveDroppedItem")
    @DefaultValue("false")
    boolean getSaveDroppedItem();

    @Key("EmptyDroppedItemTableAfterLoad")
    @DefaultValue("false")
    boolean getEmptyDroppedItemTableAfterLoad();

    @Key("SaveDroppedItemInterval")
    @DefaultValue("0")
    int getSaveDroppedItemInterval();

    @Key("ClearDroppedItemTable")
    @DefaultValue("false")
    boolean getClearDroppedItemTable();

    @Key("AutoDeleteInvalidQuestData")
    @DefaultValue("false")
    boolean getAutoDeleteInvalidQuestData();

    @Key("PreciseDropCalculation")
    @DefaultValue("true")
    boolean getPreciseDropCalculation();

    @Key("MultipleItemDrop")
    @DefaultValue("true")
    boolean getMultipleItemDrop();

    @Key("ForceInventoryUpdate")
    @DefaultValue("false")
    boolean getForceInventoryUpdate();

    @Key("LazyCache")
    @DefaultValue("false")
    boolean getLazyCache();

    @Key("MaxDriftRange")
    @DefaultValue("300")
    int getMaxDriftRange();

    @Key("MinNPCAnimation")
    @DefaultValue("10")
    int getMinNPCAnimation();

    @Key("MaxNPCAnimation")
    @DefaultValue("20")
    int getMaxNPCAnimation();

    @Key("MinMonsterAnimation")
    @DefaultValue("5")
    int getMinMonsterAnimation();

    @Key("MaxMonsterAnimation")
    @DefaultValue("20")
    int getMaxMonsterAnimation();

    @Key("ShowServerNews")
    @DefaultValue("false")
    boolean getShowServerNews();

    @Key("ShowNpcLevel")
    @DefaultValue("false")
    boolean getShowNpcLevel();

    @Key("ActivatePositionRecorder")
    @DefaultValue("false")
    boolean getActivatePositionRecorder();

    @Key("AllowWarehouse")
    @DefaultValue("true")
    boolean getAllowWarehouse();

    @Key("WarehouseCache")
    @DefaultValue("false")
    boolean getWarehouseCache();

    @Key("WarehouseCacheTime")
    @DefaultValue("15")
    int getWarehouseCacheTime();

    @Key("AllowFreight")
    @DefaultValue("false")
    boolean getAllowFreight();

    @Key("AllowWear")
    @DefaultValue("false")
    boolean getAllowWear();

    @Key("WearDelay")
    @DefaultValue("5")
    int getWearDelay();

    @Key("WearPrice")
    @DefaultValue("10")
    int getWearPrice();

    @Key("AllowLottery")
    @DefaultValue("false")
    boolean getAllowLottery();

    @Key("AllowRace")
    @DefaultValue("false")
    boolean getAllowRace();

    @Key("AllowWater")
    @DefaultValue("false")
    boolean getAllowWater();

    @Key("AllowRentPet")
    @DefaultValue("false")
    boolean getAllowRentPet();

    @Key("AllowFishing")
    @DefaultValue("false")
    boolean getAllowFishing();

    @Key("AllowBoat")
    @DefaultValue("false")
    boolean getAllowBoat();

    @Key("AllowCursedWeapons")
    @DefaultValue("false")
    boolean getAllowCursedWeapons();

    @Key("AllowManor")
    @DefaultValue("false")
    boolean getAllowManor();

    @Key("AllowNpcWalkers")
    @DefaultValue("true")
    boolean getAllowNpcWalkers();

    @Key("AllowL2Walker")
    @DefaultValue("false")
    String getAllowL2Walker();

    @Key("L2WalkerRevision")
    @DefaultValue("537")
    int getL2WalkerRevision();

    @Key("AutobanL2WalkerAcc")
    @DefaultValue("false")
    boolean getAutobanL2WalkerAcc();

    @Key("OnlyGMItemsFree")
    @DefaultValue("true")
    boolean getOnlyGMItemsFree();

    @Key("LogChat")
    @DefaultValue("false")
    boolean getLogChat();

    @Key("LogItems")
    @DefaultValue("false")
    boolean getLogItems();

    @Key("GMAudit")
    @DefaultValue("false")
    boolean getGMAudit();

    @Key("CommunityType")
    @DefaultValue("old")
    String getCommunityType();

    @Key("BBSDefault")
    @DefaultValue("_bbshome")
    String getBBSDefault();

    @Key("ShowLevelOnCommunityBoard")
    @DefaultValue("false")
    boolean getShowLevelOnCommunityBoard();

    @Key("ShowStatusOnCommunityBoard")
    @DefaultValue("true")
    boolean getShowStatusOnCommunityBoard();

    @Key("NamePageSizeOnCommunityBoard")
    @DefaultValue("50")
    int getNamePageSizeOnCommunityBoard();

    @Key("NamePerRowOnCommunityBoard")
    @DefaultValue("5")
    int getNamePerRowOnCommunityBoard();

    @Key("ThreadPoolSizeEffects")
    @DefaultValue("6")
    int getThreadPoolSizeEffects();

    @Key("ThreadPoolSizeGeneral")
    @DefaultValue("15")
    int getThreadPoolSizeGeneral();

    @Key("UrgentPacketThreadCoreSize")
    @DefaultValue("2")
    int getUrgentPacketThreadCoreSize();

    @Key("GeneralPacketThreadCoreSize")
    @DefaultValue("4")
    int getGeneralPacketThreadCoreSize();

    @Key("GeneralThreadCoreSize")
    @DefaultValue("4")
    int getGeneralThreadCoreSize();

    @Key("AiMaxThread")
    @DefaultValue("10")
    int getAiMaxThread();

    @Key("ExecutorPriLow")
    int getExecutorPriLow();

    @Key("ExecutorPriMed")
    int getExecutorPriMed();

    @Key("ExecutorPriHigh")
    int getExecutorPriHigh();

    @Key("PacketLifeTime")
    @DefaultValue("0")
    int getPacketLifeTime();

    @Key("GridsAlwaysOn")
    @DefaultValue("false")
    boolean getGridsAlwaysOn();

    @Key("GridNeighborTurnOnTime")
    @DefaultValue("30")
    int getGridNeighborTurnOnTime();

    @Key("GridNeighborTurnOffTime")
    @DefaultValue("300")
    int getGridNeighborTurnOffTime();

    @Key("GeoData")
    @DefaultValue("0")
    int getGeoData();

    @Key("ForceGeodata")
    @DefaultValue("false")
    boolean getForceGeodata();

    @Key("Use3DMap")
    @DefaultValue("false")
    boolean getUse3DMap();

    @Key("PathNodeRadius")
    @DefaultValue("50")
    int getPathNodeRadius();

    @Key("NewNodeId")
    @DefaultValue("7952")
    int getNewNodeId();

    @Key("NewNodeType")
    @DefaultValue("npc")
    String getNewNodeType();

    @Key("CountPacket")
    @DefaultValue("false")
    boolean getCountPacket();

    @Key("DumpPacketCounts")
    @DefaultValue("false")
    boolean getDumpPacketCounts();

    @Key("PacketDumpInterval")
    @DefaultValue("60")
    int getPacketDumpInterval();

    @Key("MaximumUpdateDistance")
    @DefaultValue("50")
    int getMaximumUpdateDistance();

    @Key("MinimumUpdateTime")
    @DefaultValue("500")
    int getMinimumUpdateTime();

    @Key("CheckKnownList")
    @DefaultValue("false")
    boolean getCheckKnownList();

    @Key("KnownListForgetDelay")
    @DefaultValue("10000")
    int getKnownListForgetDelay();
}
