/*
 * Copyright © 2004-2020 L2J Server
 * 
 * This file is part of L2J Server.
 * 
 * L2J Server is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * L2J Server is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 */
package net.sf.l2j;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigInteger;
import java.util.List;
import java.util.Properties;
import java.util.logging.Logger;

import javolution.util.FastList;
import net.sf.l2j.gameserver.model.actor.instance.L2PcInstance;

import static net.sf.l2j.config.Configuration.*;

/**
 * This class contains global server configuration.<br>
 * It has static final fields initialized from configuration files.<br>
 * It's initialized at the very begin of startup, and later JIT will optimize away debug/unused code.
 * @author mkizub
 */
public final class Config {
	protected static final Logger _log = Logger.getLogger(Config.class.getName());
	/** Debug/release mode */
	public static boolean DEBUG = options().getDebug();
	/** Enable/disable assertions */
	public static boolean ASSERT = options().getAssert();
	/** Enable/disable code 'in progress' */
	public static boolean DEVELOPER = options().getDeveloper();
	
	/** Set if this server is a test server used for development */
	public static boolean TEST_SERVER = options().getTestServer();
	
	/** Game Server ports */
	public static int PORT_GAME = server().getGameserverPort();
	/** Login Server port */
	public static int PORT_LOGIN;
	/** Login Server bind ip */
	public static String LOGIN_BIND_ADDRESS;
	/** Number of login tries before IP ban gets activated, default 10 */
	public static int LOGIN_TRY_BEFORE_BAN;
	/** Number of seconds the IP ban will last, default 10 minutes */
	public static int LOGIN_BLOCK_AFTER_BAN;
	/** Hostname of the Game Server */
	public static String GAMESERVER_HOSTNAME = server().getGameserverHostname();
	
	// Access to database
	/** Driver to access to database */
	public static String DATABASE_DRIVER = server().getDriver();
	/** Path to access to database */
	public static String DATABASE_URL = server().getURL();
	/** Database login */
	public static String DATABASE_LOGIN = server().getLogin();
	/** Database password */
	public static String DATABASE_PASSWORD = server().getPassword();
	/** Maximum number of connections to the database */
	public static int DATABASE_MAX_CONNECTIONS = server().getMaximumDbConnections();
	
	/** Maximum number of players allowed to play simultaneously on server */
	public static int MAXIMUM_ONLINE_USERS = server().getMaximumOnlineUsers();
	
	// Setting for serverList
	/** Displays [] in front of server name ? */
	public static boolean SERVER_LIST_BRACKET = options().getServerListBrackets();
	/** Displays a clock next to the server name ? */
	public static boolean SERVER_LIST_CLOCK = options().getServerListClock();
	/** Display test server in the list of servers ? */
	public static boolean SERVER_LIST_TESTSERVER = options().getTestServer();
	/** Set the server as gm only at startup ? */
	public static boolean SERVER_GMONLY = options().getServerGMOnly();
	
	// Thread pools size
	/** Thread pool size effect */
	public static int THREAD_P_EFFECTS = options().getThreadPoolSizeEffects();
	/** Thread pool size general */
	public static int THREAD_P_GENERAL = options().getThreadPoolSizeGeneral();
	/** Packet max thread */
	public static int GENERAL_PACKET_THREAD_CORE_SIZE = options().getGeneralPacketThreadCoreSize();
	public static int IO_PACKET_THREAD_CORE_SIZE = options().getUrgentPacketThreadCoreSize();
	/** General max thread */
	public static int GENERAL_THREAD_CORE_SIZE = options().getGeneralThreadCoreSize();
	/** AI max thread */
	public static int AI_MAX_THREAD = options().getAiMaxThread();
	
	/** Accept auto-loot ? */
	public static boolean AUTO_LOOT;
	public static boolean AUTO_LOOT_HERBS;
	
	/** Character name template */
	public static String CNAME_TEMPLATE = server().getCnameTemplate();
	/** Pet name template */
	public static String PET_NAME_TEMPLATE = server().getPetNameTemplate();
	/** Maximum number of characters per account */
	public static int MAX_CHARACTERS_NUMBER_PER_ACCOUNT = server().getCharMaxNumber();
	
	/** Global chat state */
	public static String DEFAULT_GLOBAL_CHAT = options().getGlobalChat();
	/** Trade chat state */
	public static String DEFAULT_TRADE_CHAT = options().getTradeChat();
	/** For test servers - everybody has admin rights */
	public static boolean EVERYBODY_HAS_ADMIN_RIGHTS = options().getEverybodyHasAdminRights();
	/** Alternative game crafting */
	public static boolean ALT_GAME_CREATION;
	/** Alternative game crafting speed mutiplier - default 0 (fastest but still not instant) */
	public static double ALT_GAME_CREATION_SPEED;
	/** Alternative game crafting XP rate multiplier - default 1 */
	public static double ALT_GAME_CREATION_XP_RATE;
	/** Alternative game crafting SP rate multiplier - default 1 */
	public static double ALT_GAME_CREATION_SP_RATE;
	/** Alternative setting to blacksmith use of recipes to craft - default true */
	public static boolean ALT_BLACKSMITH_USE_RECIPES;
	
	/** Remove Castle circlets after clan lose his castle? - default true */
	public static boolean REMOVE_CASTLE_CIRCLETS;
	/** Alternative game weight limit multiplier - default 1 */
	public static double ALT_WEIGHT_LIMIT;
	
	/** Alternative game skill learning */
	public static boolean ALT_GAME_SKILL_LEARN;
	/** Alternative auto skill learning */
	public static boolean AUTO_LEARN_SKILLS;
	/** Cancel attack bow by hit */
	public static boolean ALT_GAME_CANCEL_BOW;
	/** Cancel cast by hit */
	public static boolean ALT_GAME_CANCEL_CAST;
	
	/** Alternative game - use tiredness, instead of CP */
	public static boolean ALT_GAME_TIREDNESS;
	public static int ALT_PARTY_RANGE;
	public static int ALT_PARTY_RANGE2;
	/** Alternative shield defence */
	public static boolean ALT_GAME_SHIELD_BLOCKS;
	/** Alternative Perfect shield defence rate */
	public static int ALT_PERFECT_SHLD_BLOCK;
	/** Alternative game mob ATTACK AI */
	public static boolean ALT_GAME_MOB_ATTACK_AI;
	public static boolean ALT_MOB_AGRO_IN_PEACEZONE;
	
	/** Alternative freight modes - Freights can be withdrawed from any village */
	public static boolean ALT_GAME_FREIGHTS;
	/** Alternative freight modes - Sets the price value for each freightened item */
	public static int ALT_GAME_FREIGHT_PRICE;
	
	/** Fast or slow multiply coefficient for skill hit time */
	public static float ALT_GAME_SKILL_HIT_RATE;
	
	/** Alternative gameing - loss of XP on death */
	public static boolean ALT_GAME_DELEVEL;
	
	/** Alternative gameing - magic dmg failures */
	public static boolean ALT_GAME_MAGICFAILURES;
	
	/** Alternative gaming - player must be in a castle-owning clan or ally to sign up for Dawn. */
	public static boolean ALT_GAME_REQUIRE_CASTLE_DAWN = sevenSigns().getAltRequireCastleForDawn();
	
	/** Alternative gaming - allow clan-based castle ownage check rather than ally-based. */
	public static boolean ALT_GAME_REQUIRE_CLAN_CASTLE = sevenSigns().getAltRequireClanCastle();
	
	/** Alternative gaming - allow free teleporting around the world. */
	public static boolean ALT_GAME_FREE_TELEPORT;
	
	/** Disallow recommend character twice or more a day ? */
	public static boolean ALT_RECOMMEND;
	
	/** Alternative gaming - allow sub-class addition without quest completion. */
	public static boolean ALT_GAME_SUBCLASS_WITHOUT_QUESTS;
	
	/** View npc stats/drop by shift-cliking it for nongm-players */
	public static boolean ALT_GAME_VIEWNPC;
	
	/** Minimum number of player to participate in SevenSigns Festival */
	public static int ALT_FESTIVAL_MIN_PLAYER = sevenSigns().getAltFestivalMinPlayer();
	
	/** Maximum of player contrib during Festival */
	public static int ALT_MAXIMUM_PLAYER_CONTRIB = sevenSigns().getAltMaxPlayerContrib();
	
	/** Festival Manager start time. */
	public static long ALT_FESTIVAL_MANAGER_START = sevenSigns().getAltFestivalManagerStart();
	
	/** Festival Length */
	public static long ALT_FESTIVAL_LENGTH = sevenSigns().getAltFestivalLength();
	
	/** Festival Cycle Length */
	public static long ALT_FESTIVAL_CYCLE_LENGTH = sevenSigns().getAltFestivalCycleLength();
	
	/** Festival First Spawn */
	public static long ALT_FESTIVAL_FIRST_SPAWN = sevenSigns().getAltFestivalFirstSpawn();
	
	/** Festival First Swarm */
	public static long ALT_FESTIVAL_FIRST_SWARM = sevenSigns().getAltFestivalFirstSwarm();
	
	/** Festival Second Spawn */
	public static long ALT_FESTIVAL_SECOND_SPAWN = sevenSigns().getAltFestivalSecondSpawn();
	
	/** Festival Second Swarm */
	public static long ALT_FESTIVAL_SECOND_SWARM = sevenSigns().getAltFestivalSecondSwarm();
	
	/** Festival Chest Spawn */
	public static long ALT_FESTIVAL_CHEST_SPAWN = sevenSigns().getAltFestivalChestSpawn();
	
	/** Number of members needed to request a clan war */
	public static int ALT_CLAN_MEMBERS_FOR_WAR;
	
	/** Number of days before joining a new clan */
	public static int ALT_CLAN_JOIN_DAYS;
	/** Number of days before creating a new clan */
	public static int ALT_CLAN_CREATE_DAYS;
	/** Number of days it takes to dissolve a clan */
	public static int ALT_CLAN_DISSOLVE_DAYS;
	/** Number of days before joining a new alliance when clan voluntarily leave an alliance */
	public static int ALT_ALLY_JOIN_DAYS_WHEN_LEAVED;
	/** Number of days before joining a new alliance when clan was dismissed from an alliance */
	public static int ALT_ALLY_JOIN_DAYS_WHEN_DISMISSED;
	/** Number of days before accepting a new clan for alliance when clan was dismissed from an alliance */
	public static int ALT_ACCEPT_CLAN_DAYS_WHEN_DISMISSED;
	/** Number of days before creating a new alliance when dissolved an alliance */
	public static int ALT_CREATE_ALLY_DAYS_WHEN_DISSOLVED;
	
	/** Alternative gaming - all new characters always are newbies. */
	public static boolean ALT_GAME_NEW_CHAR_ALWAYS_IS_NEWBIE;
	
	/** Alternative gaming - clan members with see privilege can also withdraw from clan warehouse. */
	public static boolean ALT_MEMBERS_CAN_WITHDRAW_FROM_CLANWH;
	
	/** Maximum number of clans in ally */
	public static int ALT_MAX_NUM_OF_CLANS_IN_ALLY;
	/** Life Crystal needed to learn clan skill */
	public static boolean LIFE_CRYSTAL_NEEDED;
	/** Spell Book needed to learn skill */
	public static boolean SP_BOOK_NEEDED;
	/** Spell Book needet to enchant skill */
	public static boolean ES_SP_BOOK_NEEDED;
	/** Logging Chat Window */
	public static boolean LOG_CHAT = options().getLogChat();
	/** Logging Item Window */
	public static boolean LOG_ITEMS = options().getLogItems();
	
	/** Alternative privileges for admin */
	public static boolean ALT_PRIVILEGES_ADMIN = other().getAltPrivilegesAdmin();
	/** Alternative secure check privileges */
	public static boolean ALT_PRIVILEGES_SECURE_CHECK = other().getAltPrivilegesSecureCheck();
	/** Alternative default level for privileges */
	public static int ALT_PRIVILEGES_DEFAULT_LEVEL = other().getAltPrivilegesDefaultLevel();
	
	/** Olympiad Competition Starting time */
	public static int ALT_OLY_START_TIME;
	/** Olympiad Minutes */
	public static int ALT_OLY_MIN;
	
	/** Olympiad Competition Period */
	public static long ALT_OLY_CPERIOD;
	
	/** Olympiad Battle Period */
	public static long ALT_OLY_BATTLE;
	
	/** Olympiad Battle Wait */
	public static long ALT_OLY_BWAIT;
	
	/** Olympiad Inital Wait */
	public static long ALT_OLY_IWAIT;
	
	/** Olympaid Weekly Period */
	public static long ALT_OLY_WPERIOD;
	
	/** Olympaid Validation Period */
	public static long ALT_OLY_VPERIOD;
	
	/** Manor Refresh Starting time */
	public static int ALT_MANOR_REFRESH_TIME;
	
	/** Manor Refresh Min */
	public static int ALT_MANOR_REFRESH_MIN;
	
	/** Manor Next Period Approve Starting time */
	public static int ALT_MANOR_APPROVE_TIME;
	
	/** Manor Next Period Approve Min */
	public static int ALT_MANOR_APPROVE_MIN;
	
	/** Manor Maintenance Time */
	public static int ALT_MANOR_MAINTENANCE_PERIOD;
	
	/** Manor Save All Actions */
	public static boolean ALT_MANOR_SAVE_ALL_ACTIONS;
	
	/** Manor Save Period Rate */
	public static int ALT_MANOR_SAVE_PERIOD_RATE;
	
	/** Initial Lottery prize */
	public static int ALT_LOTTERY_PRIZE;
	
	/** Lottery Ticket Price */
	public static int ALT_LOTTERY_TICKET_PRICE;
	
	/** What part of jackpot amount should receive characters who pick 5 wining numbers */
	public static float ALT_LOTTERY_5_NUMBER_RATE;
	
	/** What part of jackpot amount should receive characters who pick 4 wining numbers */
	public static float ALT_LOTTERY_4_NUMBER_RATE;
	
	/** What part of jackpot amount should receive characters who pick 3 wining numbers */
	public static float ALT_LOTTERY_3_NUMBER_RATE;
	
	/** How much adena receive characters who pick two or less of the winning number */
	public static int ALT_LOTTERY_2_AND_1_NUMBER_PRIZE;
	
	/** Minimum siz e of a party that may enter dimensional rift */
	public static int RIFT_MIN_PARTY_SIZE;
	
	/** Time in ms the party has to wait until the mobs spawn when entering a room */
	public static int RIFT_SPAWN_DELAY;
	
	/** Amount of random rift jumps before party is ported back */
	public static int RIFT_MAX_JUMPS;
	
	/** Random time between two jumps in dimensional rift - in seconds */
	public static int RIFT_AUTO_JUMPS_TIME_MIN;
	public static int RIFT_AUTO_JUMPS_TIME_MAX;
	
	/** Dimensional Fragment cost for entering rift */
	public static int RIFT_ENTER_COST_RECRUIT;
	public static int RIFT_ENTER_COST_SOLDIER;
	public static int RIFT_ENTER_COST_OFFICER;
	public static int RIFT_ENTER_COST_CAPTAIN;
	public static int RIFT_ENTER_COST_COMMANDER;
	public static int RIFT_ENTER_COST_HERO;
	
	/** time multiplier for boss room */
	public static float RIFT_BOSS_ROOM_TIME_MUTIPLY;
	
	/*
	 * ************************************************************************** GM CONFIG General GM AccessLevel *************************************************************************
	 */
	/** General GM access level */
	public static int GM_ACCESSLEVEL;
	/** General GM Minimal AccessLevel */
	public static int GM_MIN;
	/** Minimum privileges level for a GM to do Alt+G */
	public static int GM_ALTG_MIN_LEVEL;
	/** General GM AccessLevel to change announcements */
	public static int GM_ANNOUNCE;
	/** General GM AccessLevel can /ban /unban */
	public static int GM_BAN;
	/** General GM AccessLevel can /ban /unban for chat */
	public static int GM_BAN_CHAT;
	/** General GM AccessLevel can /create_item and /gmshop */
	public static int GM_CREATE_ITEM;
	/** General GM AccessLevel can /delete */
	public static int GM_DELETE;
	/** General GM AccessLevel can /kick /disconnect */
	public static int GM_KICK;
	/** General GM AccessLevel for access to GMMenu */
	public static int GM_MENU;
	/** General GM AccessLevel to use god mode command */
	public static int GM_GODMODE;
	/** General GM AccessLevel with character edit rights */
	public static int GM_CHAR_EDIT;
	/** General GM AccessLevel with edit rights for other characters */
	public static int GM_CHAR_EDIT_OTHER;
	/** General GM AccessLevel with character view rights */
	public static int GM_CHAR_VIEW;
	/** General GM AccessLevel with NPC edit rights */
	public static int GM_NPC_EDIT;
	public static int GM_NPC_VIEW;
	/** General GM AccessLevel to teleport to any location */
	public static int GM_TELEPORT;
	/** General GM AccessLevel to teleport character to any location */
	public static int GM_TELEPORT_OTHER;
	/** General GM AccessLevel to restart server */
	public static int GM_RESTART;
	/** General GM AccessLevel for MonsterRace */
	public static int GM_MONSTERRACE;
	/** General GM AccessLevel to ride Wyvern */
	public static int GM_RIDER;
	/** General GM AccessLevel to unstuck without 5min delay */
	public static int GM_ESCAPE;
	/** General GM AccessLevel to resurect fixed after death */
	public static int GM_FIXED;
	/** General GM AccessLevel to create Path Nodes */
	public static int GM_CREATE_NODES;
	/** General GM AccessLevel with Enchant rights */
	public static int GM_ENCHANT;
	/** General GM AccessLevel to close/open Doors */
	public static int GM_DOOR;
	/** General GM AccessLevel with Resurrection rights */
	public static int GM_RES;
	/** General GM AccessLevel to attack in the peace zone */
	public static int GM_PEACEATTACK;
	/** General GM AccessLevel to heal */
	public static int GM_HEAL;
	/** General GM AccessLevel to unblock IPs detected as hack IPs */
	public static int GM_UNBLOCK;
	/** General GM AccessLevel to use Cache commands */
	public static int GM_CACHE;
	/** General GM AccessLevel to use test&st commands */
	public static int GM_TALK_BLOCK;
	public static int GM_TEST;
	/** Disable transaction on AccessLevel **/
	public static boolean GM_DISABLE_TRANSACTION;
	/** GM transactions disabled from this range */
	public static int GM_TRANSACTION_MIN;
	/** GM transactions disabled to this range */
	public static int GM_TRANSACTION_MAX;
	/** Minimum level to allow a GM giving damage */
	public static int GM_CAN_GIVE_DAMAGE;
	/** Minimum level to don't give Exp/Sp in party */
	public static int GM_DONT_TAKE_EXPSP;
	/** Minimum level to don't take aggro */
	public static int GM_DONT_TAKE_AGGRO;
	
	public static int GM_REPAIR = 75;
	
	/* Rate control */
	/** Rate for eXperience Point rewards */
	public static float RATE_XP = rates().getRateXp();
	/** Rate for Skill Point rewards */
	public static float RATE_SP = rates().getRateSp();
	/** Rate for party eXperience Point rewards */
	public static float RATE_PARTY_XP = rates().getRatePartyXp();
	/** Rate for party Skill Point rewards */
	public static float RATE_PARTY_SP = rates().getRatePartySp();
	/** Rate for Quest rewards (XP and SP) */
	public static float RATE_QUESTS_REWARD = rates().getRateQuestsReward();
	/** Rate for drop adena */
	public static float RATE_DROP_ADENA = rates().getRateDropAdena();
	/** Rate for cost of consumable */
	public static float RATE_CONSUMABLE_COST = rates().getRateConsumableCost();
	/** Rate for dropped items */
	public static float RATE_DROP_ITEMS = rates().getRateDropItems();
	/** Rate for spoiled items */
	public static float RATE_DROP_SPOIL = rates().getRateDropSpoil();
	/** Rate for manored items */
	public static int RATE_DROP_MANOR = rates().getRateDropManor();
	/** Rate for quest items */
	public static float RATE_DROP_QUEST = rates().getRateDropQuest();
	/** Rate for karma and experience lose */
	public static float RATE_KARMA_EXP_LOST = rates().getRateKarmaExpLost();
	/** Rate siege guards prices */
	public static float RATE_SIEGE_GUARDS_PRICE = rates().getRateSiegeGuardsPrice();
	/*
	 * Alternative Xp/Sp rewards, if not 0, then calculated as 2^((mob.level-player.level) / coef), A few examples for "AltGameExponentXp = 5." and "AltGameExponentSp = 3." diff = 0 (player and mob has the same level), XP bonus rate = 1, SP bonus rate = 1 diff = 3 (mob is 3 levels above), XP bonus
	 * rate = 1.52, SP bonus rate = 2 diff = 5 (mob is 5 levels above), XP bonus rate = 2, SP bonus rate = 3.17 diff = -8 (mob is 8 levels below), XP bonus rate = 0.4, SP bonus rate = 0.16
	 */
	/** Alternative eXperience Point rewards */
	public static float ALT_GAME_EXPONENT_XP;
	/** Alternative Spirit Point rewards */
	public static float ALT_GAME_EXPONENT_SP;
	
	/** Rate Common herbs */
	public static float RATE_DROP_COMMON_HERBS = rates().getRateCommonHerbs();
	/** Rate MP/HP herbs */
	public static float RATE_DROP_MP_HP_HERBS = rates().getRateHpMpHerbs();
	/** Rate Common herbs */
	public static float RATE_DROP_GREATER_HERBS = rates().getRateGreaterHerbs();
	/** Rate Common herbs */
	public static float RATE_DROP_SUPERIOR_HERBS = rates().getRateSuperiorHerbs() * 10;
	/** Rate Common herbs */
	public static float RATE_DROP_SPECIAL_HERBS = rates().getRateSpecialHerbs() * 10;
	
	// Player Drop Rate control
	/** Limit for player drop */
	public static int PLAYER_DROP_LIMIT = rates().getPlayerDropLimit();
	/** Rate for drop */
	public static int PLAYER_RATE_DROP = rates().getPlayerRateDrop();
	/** Rate for player's item drop */
	public static int PLAYER_RATE_DROP_ITEM = rates().getPlayerRateDropItem();
	/** Rate for player's equipment drop */
	public static int PLAYER_RATE_DROP_EQUIP = rates().getPlayerRateDropEquip();
	/** Rate for player's equipment and weapon drop */
	public static int PLAYER_RATE_DROP_EQUIP_WEAPON = rates().getPlayerRateDropEquipWeapon();
	
	// Pet Rates (Multipliers)
	/** Rate for experience rewards of the pet */
	public static float PET_XP_RATE = rates().getPetXpRate();
	/** Rate for food consumption of the pet */
	public static int PET_FOOD_RATE = rates().getPetFoodRate();
	/** Rate for experience rewards of the Sin Eater */
	public static float SINEATER_XP_RATE = rates().getSinEaterXpRate();
	
	// Karma Drop Rate control
	/** Karma drop limit */
	public static int KARMA_DROP_LIMIT = rates().getKarmaDropLimit();
	/** Karma drop rate */
	public static int KARMA_RATE_DROP = rates().getKarmaRateDrop();
	/** Karma drop rate for item */
	public static int KARMA_RATE_DROP_ITEM = rates().getKarmaRateDropItem();
	/** Karma drop rate for equipment */
	public static int KARMA_RATE_DROP_EQUIP = rates().getKarmaRateDropEquip();
	/** Karma drop rate for equipment and weapon */
	public static int KARMA_RATE_DROP_EQUIP_WEAPON = rates().getKarmaRateDropEquipWeapon();
	
	/** Time after which item will auto-destroy */
	public static int AUTODESTROY_ITEM_AFTER = options().getAutoDestroyDroppedItemAfter();
	/** Auto destroy herb time */
	public static int HERB_AUTO_DESTROY_TIME = options().getAutoDestroyHerbTime() * 1000;
	/** List of items that will not be destroyed (separated by ",") */
	public static String PROTECTED_ITEMS = options().getListOfProtectedItems();
	/** List of items that will not be destroyed */
	public static List<Integer> LIST_PROTECTED_ITEMS = new FastList<>();
	
	/** Auto destroy nonequipable items dropped by players */
	public static boolean DESTROY_DROPPED_PLAYER_ITEM = options().getDestroyPlayerDroppedItem();
	/** Auto destroy equipable items dropped by players */
	public static boolean DESTROY_EQUIPABLE_PLAYER_ITEM = options().getDestroyEquipableItem();
	/** Save items on ground for restoration on server restart */
	public static boolean SAVE_DROPPED_ITEM = options().getSaveDroppedItem();
	/** Empty table ItemsOnGround after load all items */
	public static boolean EMPTY_DROPPED_ITEM_TABLE_AFTER_LOAD = options().getEmptyDroppedItemTableAfterLoad();
	/** Time interval to save into db items on ground */
	public static int SAVE_DROPPED_ITEM_INTERVAL = options().getSaveDroppedItemInterval() * 60000;
	/** Clear all items stored in ItemsOnGround table */
	public static boolean CLEAR_DROPPED_ITEM_TABLE = options().getClearDroppedItemTable();
	
	/** Accept precise drop calculation ? */
	public static boolean PRECISE_DROP_CALCULATION = options().getPreciseDropCalculation();
	/** Accept multi-items drop ? */
	public static boolean MULTIPLE_ITEM_DROP = options().getMultipleItemDrop();
	
	/**
	 * This is setting of experimental Client <--> Server Player coordinates synchronization<br>
	 * <b><u>Valeurs :</u></b>
	 * <li>0 - no synchronization at all</li>
	 * <li>1 - parcial synchronization Client --> Server only * using this option it is difficult for players to bypass obstacles</li>
	 * <li>2 - parcial synchronization Server --> Client only</li>
	 * <li>3 - full synchronization Client <--> Server</li>
	 * <li>-1 - Old system: will synchronize Z only</li>
	 */
	public static int COORD_SYNCHRONIZE = options().getCoordSynchronize();
	
	/** Period in days after which character is deleted */
	public static int DELETE_DAYS = options().getDeleteCharAfterDays();
	
	/** Datapack root directory */
	public static File DATAPACK_ROOT;
	
	/** Maximum range mobs can randomly go from spawn point */
	public static int MAX_DRIFT_RANGE = options().getMaxDriftRange();
	
	/** Allow fishing ? */
	public static boolean ALLOWFISHING = options().getAllowFishing();
	
	/** Allow Manor system */
	public static boolean ALLOW_MANOR = options().getAllowManor();
	
	/** Jail config **/
	public static boolean JAIL_IS_PVP = other().getJailIsPvp();
	public static boolean JAIL_DISABLE_CHAT = other().getJailDisableChat();
	
	/** Enumeration describing values for Allowing the use of L2Walker client */
	public static enum L2WalkerAllowed {
		True,
		False,
		GM
	}
	
	/** Allow the use of L2Walker client ? */
	public static L2WalkerAllowed ALLOW_L2WALKER_CLIENT = L2WalkerAllowed.valueOf(options().getAllowL2Walker());;
	/** Auto-ban client that use L2Walker ? */
	public static boolean AUTOBAN_L2WALKER_ACC = options().getAutobanL2WalkerAcc();
	/** Revision of L2Walker */
	public static int L2WALKER_REVISION = options().getL2WalkerRevision();
	
	/** FloodProtector initial capacity */
	public static int FLOODPROTECTOR_INITIALSIZE = options().getFloodProtectorInitialSize();
	
	/** Allow Discard item ? */
	public static boolean ALLOW_DISCARDITEM = options().getAllowDiscardItem();
	/** Allow freight ? */
	public static boolean ALLOW_FREIGHT = options().getAllowFreight();
	/** Allow warehouse ? */
	public static boolean ALLOW_WAREHOUSE = options().getAllowWarehouse();
	/** Allow warehouse cache? */
	public static boolean WAREHOUSE_CACHE = options().getWarehouseCache();
	/** How long store WH datas */
	public static int WAREHOUSE_CACHE_TIME = options().getWarehouseCacheTime();
	/** Allow wear ? (try on in shop) */
	public static boolean ALLOW_WEAR = options().getAllowWear();
	/** Duration of the try on after which items are taken back */
	public static int WEAR_DELAY = options().getWearDelay();
	/** Price of the try on of one item */
	public static int WEAR_PRICE = options().getWearPrice();
	/** Allow lottery ? */
	public static boolean ALLOW_LOTTERY = options().getAllowLottery();
	/** Allow race ? */
	public static boolean ALLOW_RACE = options().getAllowRace();
	/** Allow water ? */
	public static boolean ALLOW_WATER = options().getAllowWater();
	/** Allow rent pet ? */
	public static boolean ALLOW_RENTPET = options().getAllowRentPet();
	/** Allow boat ? */
	public static boolean ALLOW_BOAT = options().getAllowBoat();
	/** Allow cursed weapons ? */
	public static boolean ALLOW_CURSED_WEAPONS = options().getAllowCursedWeapons();
	
	// WALKER NPC
	public static boolean ALLOW_NPC_WALKERS = options().getAllowNpcWalkers();
	
	/** Time after which a packet is considered as lost */
	public static int PACKET_LIFETIME = options().getPacketLifeTime();
	
	// Pets
	/** Speed of Weverns */
	public static int WYVERN_SPEED = other().getWyvernSpeed();
	/** Speed of Striders */
	public static int STRIDER_SPEED = other().getStriderSpeed();
	/** Allow Wyvern Upgrader ? */
	public static boolean ALLOW_WYVERN_UPGRADER = other().getAllowWyvernUpgrader();
	
	// protocol revision
	/** Minimal protocol revision */
	public static int MIN_PROTOCOL_REVISION = server().getMinProtocolRevision();
	/** Maximal protocol revision */
	public static int MAX_PROTOCOL_REVISION = server().getMaxProtocolRevision();
	
	// random animation interval
	/** Minimal time between 2 animations of a NPC */
	public static int MIN_NPC_ANIMATION = options().getMinNPCAnimation();
	/** Maximal time between 2 animations of a NPC */
	public static int MAX_NPC_ANIMATION = options().getMaxNPCAnimation();
	/** Minimal time between animations of a MONSTER */
	public static int MIN_MONSTER_ANIMATION = options().getMinMonsterAnimation();
	/** Maximal time between animations of a MONSTER */
	public static int MAX_MONSTER_ANIMATION = options().getMaxMonsterAnimation();
	
	/** Activate position recorder ? */
	public static boolean ACTIVATE_POSITION_RECORDER = options().getActivatePositionRecorder();
	/** Use 3D Map ? */
	public static boolean USE_3D_MAP = options().getUse3DMap();
	
	// Community Board
	/** Type of community */
	public static String COMMUNITY_TYPE = options().getCommunityType();
	public static String BBS_DEFAULT = options().getBBSDefault();
	/** Show level of the community board ? */
	public static boolean SHOW_LEVEL_COMMUNITYBOARD = options().getShowLevelOnCommunityBoard();
	/** Show status of the community board ? */
	public static boolean SHOW_STATUS_COMMUNITYBOARD = options().getShowStatusOnCommunityBoard();
	/** Size of the name page on the community board */
	public static int NAME_PAGE_SIZE_COMMUNITYBOARD = options().getNamePageSizeOnCommunityBoard();
	/** Name per row on community board */
	public static int NAME_PER_ROW_COMMUNITYBOARD = options().getNamePerRowOnCommunityBoard();
	
	// Configuration files
	/**
	 * Properties file that allows selection of new Classes for storage of World Objects. <br>
	 * This may help servers with large amounts of players recieving error messages related to the <i>L2ObjectHashMap</i> and <i>L2ObejctHashSet</i> classes.
	 */
	/** Properties file for game server (connection and ingame) configurations */
	public static final String CONFIGURATION_FILE = "./config/server.properties";
	/** Properties file for game server options */
	public static final String OPTIONS_FILE = "./config/options.properties";
	/** Properties file for login server configurations */
	public static final String LOGIN_CONFIGURATION_FILE = "./config/loginserver.properties";
	/** Properties file for the ID factory */
	public static final String ID_CONFIG_FILE = "./config/idfactory.properties";
	/** Properties file for other configurations */
	public static final String OTHER_CONFIG_FILE = "./config/other.properties";
	/** Properties file for rates configurations */
	public static final String RATES_CONFIG_FILE = "./config/rates.properties";
	/** Properties file for alternative configuration */
	public static final String ALT_SETTINGS_FILE = "./config/altsettings.properties";
	/** Properties file for PVP configurations */
	public static final String PVP_CONFIG_FILE = "./config/pvp.properties";
	/** Properties file for GM access configurations */
	public static final String GM_ACCESS_FILE = "./config/GMAccess.properties";
	/** Properties file for telnet configuration */
	public static final String TELNET_FILE = "./config/telnet.properties";
	/** Properties file for siege configuration */
	public static final String SIEGE_CONFIGURATION_FILE = "./config/siege.properties";
	/** XML file for banned IP */
	public static final String BANNED_IP_XML = "./config/banned.xml";
	/** Text file containing hexadecimal value of server ID */
	public static final String HEXID_FILE = "./config/hexid.txt";
	/**
	 * Properties file for alternative configure GM commands access level.<br>
	 * Note that this file only read if "AltPrivilegesAdmin = True"
	 */
	public static final String COMMAND_PRIVILEGES_FILE = "./config/command-privileges.properties";
	/** Properties file for AI configurations */
	public static final String AI_FILE = "./config/ai.properties";
	/** Properties file for 7 Signs Festival */
	public static final String SEVENSIGNS_FILE = "./config/sevensigns.properties";
	public static final String CLANHALL_CONFIG_FILE = "./config/clanhall.properties";
	public static final String L2JMOD_CONFIG_FILE = "./config/l2jmods.properties";

	public static boolean CHECK_KNOWN = options().getCheckKnownList();
	
	/** Game Server login port */
	public static int GAME_SERVER_LOGIN_PORT = server().getLoginPort();
	/** Game Server login Host */
	public static String GAME_SERVER_LOGIN_HOST = server().getLoginHost();
	public static int PATH_NODE_RADIUS = options().getPathNodeRadius();
	public static int NEW_NODE_ID = options().getNewNodeId();
	public static int SELECTED_NODE_ID = options().getNewNodeId();
	public static int LINKED_NODE_ID = options().getNewNodeId();
	public static String NEW_NODE_TYPE = options().getNewNodeType();
	
	/** Show "data/html/servnews.htm" whenever a character enters world. */
	public static boolean SERVER_NEWS = options().getShowServerNews();
	/** Show L2Monster level and aggro ? */
	public static boolean SHOW_NPC_LVL = options().getShowNpcLevel();
	
	/**
	 * Force full item inventory packet to be sent for any item change ?<br>
	 * <u><i>Note:</i></u> This can increase network traffic
	 */
	public static boolean FORCE_INVENTORY_UPDATE = options().getForceInventoryUpdate();
	/** Disable the use of guards against agressive monsters ? */
	public static boolean ALLOW_GUARDS = other().getAllowGuards();
	/** Allow use Event Managers for change occupation ? */
	public static boolean ALLOW_CLASS_MASTERS;
	/** Time between 2 updates of IP */
	public static int IP_UPDATE_TIME;
	
	/** Zone Setting */
	public static int ZONE_TOWN = options().getZoneTown();
	
	/** Crafting Enabled? */
	public static boolean IS_CRAFTING_ENABLED;
	
	// Inventory slots limit
	/** Maximum inventory slots limits for non dwarf characters */
	public static int INVENTORY_MAXIMUM_NO_DWARF = other().getMaximumSlotsForNoDwarf();
	/** Maximum inventory slots limits for dwarf characters */
	public static int INVENTORY_MAXIMUM_DWARF = other().getMaximumSlotsForDwarf();
	/** Maximum inventory slots limits for GM */
	public static int INVENTORY_MAXIMUM_GM = other().getMaximumSlotsForGMPlayer();

	public static int MAX_ITEM_IN_PACKET = Math.max(INVENTORY_MAXIMUM_NO_DWARF, Math.max(INVENTORY_MAXIMUM_DWARF, INVENTORY_MAXIMUM_GM));
	
	// Warehouse slots limits
	/** Maximum inventory slots limits for non dwarf warehouse */
	public static int WAREHOUSE_SLOTS_NO_DWARF = other().getMaximumWarehouseSlotsForNoDwarf();
	/** Maximum inventory slots limits for dwarf warehouse */
	public static int WAREHOUSE_SLOTS_DWARF = other().getMaximumWarehouseSlotsForDwarf();
	/** Maximum inventory slots limits for clan warehouse */
	public static int WAREHOUSE_SLOTS_CLAN = other().getMaximumWarehouseSlotsForClan();
	/** Maximum inventory slots limits for freight */
	public static int FREIGHT_SLOTS = other().getMaximumFreightSlots();
	
	// Karma System Variables
	/** Minimum karma gain/loss */
	public static int KARMA_MIN_KARMA;
	/** Maximum karma gain/loss */
	public static int KARMA_MAX_KARMA;
	/** Number to divide the xp recieved by, to calculate karma lost on xp gain/lost */
	public static int KARMA_XP_DIVIDER;
	/** The Minimum Karma lost if 0 karma is to be removed */
	public static int KARMA_LOST_BASE;
	/** Can a GM drop item ? */
	public static boolean KARMA_DROP_GM;
	/** Should award a pvp point for killing a player with karma ? */
	public static boolean KARMA_AWARD_PK_KILL;
	/** Minimum PK required to drop */
	public static int KARMA_PK_LIMIT;
	
	/** List of pet items that cannot be dropped (seperated by ",") when PVP */
	public static String KARMA_NONDROPPABLE_PET_ITEMS;
	/** List of items that cannot be dropped (seperated by ",") when PVP */
	public static String KARMA_NONDROPPABLE_ITEMS;
	/** List of pet items that cannot be dropped when PVP */
	public static List<Integer> KARMA_LIST_NONDROPPABLE_PET_ITEMS = new FastList<>();
	/** List of items that cannot be dropped when PVP */
	public static List<Integer> KARMA_LIST_NONDROPPABLE_ITEMS = new FastList<>();
	
	/** List of items that cannot be dropped (seperated by ",") */
	public static String NONDROPPABLE_ITEMS = other().getListOfNonDroppableItems();
	/** List of items that cannot be dropped */
	public static List<Integer> LIST_NONDROPPABLE_ITEMS = new FastList<>();
	
	/** List of NPCs that rent pets (seperated by ",") */
	public static String PET_RENT_NPC = other().getListPetRentNpc();
	/** List of NPCs that rent pets */
	public static List<Integer> LIST_PET_RENT_NPC = new FastList<>();
	
	/** Duration (in ms) while a player stay in PVP mode after hitting an innocent */
	public static int PVP_NORMAL_TIME;
	/** Duration (in ms) while a player stay in PVP mode after hitting a purple player */
	public static int PVP_PVP_TIME;
	
	// Karma Punishment
	/** Allow player with karma to be killed in peace zone ? */
	public static boolean ALT_GAME_KARMA_PLAYER_CAN_BE_KILLED_IN_PEACEZONE;
	/** Allow player with karma to shop ? */
	public static boolean ALT_GAME_KARMA_PLAYER_CAN_SHOP;
	/** Allow player with karma to use gatekeepers ? */
	public static boolean ALT_GAME_KARMA_PLAYER_CAN_USE_GK;
	/** Allow player with karma to use SOE or Return skill ? */
	public static boolean ALT_GAME_KARMA_PLAYER_CAN_TELEPORT;
	/** Allow player with karma to trade ? */
	public static boolean ALT_GAME_KARMA_PLAYER_CAN_TRADE;
	/** Allow player with karma to use warehouse ? */
	public static boolean ALT_GAME_KARMA_PLAYER_CAN_USE_WAREHOUSE;
	
	/** define L2JMODS */
	/** Champion Mod */
	public static boolean L2JMOD_CHAMPION_ENABLE = l2JMods().getChampionEnable();
	public static int L2JMOD_CHAMPION_FREQUENCY = l2JMods().getChampionFrequency();
	public static int L2JMOD_CHAMP_MIN_LVL = l2JMods().getChampionMinLevel();
	public static int L2JMOD_CHAMP_MAX_LVL = l2JMods().getChampionMaxLevel();
	public static int L2JMOD_CHAMPION_HP = l2JMods().getChampionHp();
	public static int L2JMOD_CHAMPION_REWARDS = l2JMods().getChampionRewards();
	public static int L2JMOD_CHAMPION_ADENAS_REWARDS = l2JMods().getChampionAdenasRewards();
	public static float L2JMOD_CHAMPION_HP_REGEN = l2JMods().getChampionRegenHp();
	public static float L2JMOD_CHAMPION_ATK = l2JMods().getChampionAtk();
	public static float L2JMOD_CHAMPION_SPD_ATK = l2JMods().getChampionSpdAtk();
	public static int L2JMOD_CHAMPION_REWARD = l2JMods().getChampionRewardItem();
	public static int L2JMOD_CHAMPION_REWARD_ID = l2JMods().getChampionRewardItemID();
	public static int L2JMOD_CHAMPION_REWARD_QTY = l2JMods().getChampionRewardItemQty();
	
	/** Team vs. Team Event Engine */
	public static boolean TVT_EVENT_ENABLED = l2JMods().getTvTEventEnabled();
	public static int TVT_EVENT_INTERVAL = l2JMods().getTvTEventInterval();
	public static int TVT_EVENT_PARTICIPATION_TIME = l2JMods().getTvTEventParticipationTime();
	public static int TVT_EVENT_RUNNING_TIME = l2JMods().getTvTEventRunningTime();
	public static int TVT_EVENT_PARTICIPATION_NPC_ID = l2JMods().getTvTEventParticipationNpcId();
	public static int[] TVT_EVENT_PARTICIPATION_NPC_COORDINATES = new int[3];
	public static int TVT_EVENT_MIN_PLAYERS_IN_TEAMS = l2JMods().getTvTEventMinPlayersInTeams();
	public static int TVT_EVENT_MAX_PLAYERS_IN_TEAMS = l2JMods().getTvTEventMaxPlayersInTeams();
	public static int TVT_EVENT_RESPAWN_TELEPORT_DELAY = l2JMods().getTvTEventRespawnTeleportDelay();
	public static int TVT_EVENT_START_LEAVE_TELEPORT_DELAY = l2JMods().getTvTEventStartLeaveTeleportDelay();
	public static String TVT_EVENT_TEAM_1_NAME = l2JMods().getTvTEventTeam1Name();
	public static int[] TVT_EVENT_TEAM_1_COORDINATES = new int[3];
	public static String TVT_EVENT_TEAM_2_NAME = l2JMods().getTvTEventTeam2Name();
	public static int[] TVT_EVENT_TEAM_2_COORDINATES = new int[3];
	public static List<int[]> TVT_EVENT_REWARDS = new FastList<>();
	public static boolean TVT_EVENT_TARGET_TEAM_MEMBERS_ALLOWED = l2JMods().getTvTEventTargetTeamMembersAllowed();
	public static boolean TVT_EVENT_POTIONS_ALLOWED = l2JMods().getTvTEventPotionsAllowed();
	public static boolean TVT_EVENT_SUMMON_BY_ITEM_ALLOWED = l2JMods().getTvTEventSummonByItemAllowed();
	public static List<Integer> TVT_EVENT_DOOR_IDS = new FastList<>();
	public static byte TVT_EVENT_MIN_LVL = l2JMods().getTvTEventMinPlayerLevel();
	public static byte TVT_EVENT_MAX_LVL = l2JMods().getTvTEventMaxPlayerLevel();
	
	/** L2JMOD Wedding system */
	public static boolean L2JMOD_ALLOW_WEDDING = l2JMods().getAllowWedding();
	public static int L2JMOD_WEDDING_PRICE = l2JMods().getWeddingPrice();
	public static boolean L2JMOD_WEDDING_PUNISH_INFIDELITY = l2JMods().getWeddingPunishInfidelity();
	public static boolean L2JMOD_WEDDING_TELEPORT = l2JMods().getWeddingTeleport();
	public static int L2JMOD_WEDDING_TELEPORT_PRICE = l2JMods().getWeddingTeleportPrice();
	public static int L2JMOD_WEDDING_TELEPORT_DURATION = l2JMods().getWeddingTeleportDuration();
	public static boolean L2JMOD_WEDDING_SAMESEX = l2JMods().getWeddingAllowSameSex();
	public static boolean L2JMOD_WEDDING_FORMALWEAR = l2JMods().getWeddingFormalWear();
	public static int L2JMOD_WEDDING_DIVORCE_COSTS = l2JMods().getWeddingDivorceCosts();
	
	// Packet information
	/** Count the amount of packets per minute ? */
	public static boolean COUNT_PACKETS = options().getCountPacket();
	/** Dump packet count ? */
	public static boolean DUMP_PACKET_COUNTS = options().getDumpPacketCounts();
	/** Time interval between 2 dumps */
	public static int DUMP_INTERVAL_SECONDS = options().getPacketDumpInterval();
	
	/** Enumeration for type of ID Factory */
	public static enum IdFactoryType {
		Compaction,
		BitSet,
		Stack
	}
	
	/** ID Factory type */
	public static IdFactoryType IDFACTORY_TYPE = IdFactoryType.valueOf(idFactory().getIDFactory());
	/** Check for bad ID ? */
	public static boolean BAD_ID_CHECKING = idFactory().getBadIdChecking();
	
	/** Enumeration for type of maps object */
	public static enum ObjectMapType {
		L2ObjectHashMap,
		WorldObjectMap
	}
	
	/** Enumeration for type of set object */
	public static enum ObjectSetType {
		L2ObjectHashSet,
		WorldObjectSet
	}
	
	/** Type of map object */
	public static ObjectMapType MAP_TYPE = ObjectMapType.valueOf(idFactory().getL2Map());
	/** Type of set object */
	public static ObjectSetType SET_TYPE = ObjectSetType.valueOf(idFactory().getL2Set());
	
	/**
	 * Allow lesser effects to be canceled if stronger effects are used when effects of the same stack group are used.<br>
	 * New effects that are added will be canceled if they are of lesser priority to the old one.
	 */
	public static boolean EFFECT_CANCELING = other().getCancelLesserEffect();
	
	/** Auto-delete invalid quest data ? */
	public static boolean AUTODELETE_INVALID_QUEST_DATA = options().getAutoDeleteInvalidQuestData();
	
	/** Chance that an item will succesfully be enchanted */
	public static int ENCHANT_CHANCE_WEAPON = other().getEnchantChanceWeapon();
	public static int ENCHANT_CHANCE_ARMOR = other().getEnchantChanceArmor();
	public static int ENCHANT_CHANCE_JEWELRY = other().getEnchantChanceJewelry();
	/** Maximum level of enchantment */
	public static int ENCHANT_MAX_WEAPON = other().getEnchantMaxWeapon();
	public static int ENCHANT_MAX_ARMOR = other().getEnchantMaxArmor();
	public static int ENCHANT_MAX_JEWELRY = other().getEnchantMaxJewelry();
	/** maximum level of safe enchantment for normal items */
	public static int ENCHANT_SAFE_MAX = other().getEnchantSafeMax();
	/** maximum level of safe enchantment for full body armor */
	public static int ENCHANT_SAFE_MAX_FULL = other().getEnchantSafeMaxFull();
	
	// Character multipliers
	/** Multiplier for character HP regeneration */
	public static double HP_REGEN_MULTIPLIER = other().getHpRegenMultiplier() / 100;
	/** Mutilplier for character MP regeneration */
	public static double MP_REGEN_MULTIPLIER = other().getMpRegenMultiplier() / 100;
	/** Multiplier for character CP regeneration */
	public static double CP_REGEN_MULTIPLIER = other().getCpRegenMultiplier() / 100;
	
	// Raid Boss multipliers
	/** Multiplier for Raid boss HP regeneration */
	public static double RAID_HP_REGEN_MULTIPLIER = other().getRaidHpRegenMultiplier() / 100;
	/** Mulitplier for Raid boss MP regeneration */
	public static double RAID_MP_REGEN_MULTIPLIER = other().getRaidMpRegenMultiplier() / 100;
	/** Multiplier for Raid boss defense multiplier */
	public static double RAID_DEFENCE_MULTIPLIER = other().getRaidDefenceMultiplier() / 100;
	/** Raid Boss Minin Spawn Timer */
	public static double RAID_MINION_RESPAWN_TIMER = other().getRaidMinionRespawnTime();
	/** Mulitplier for Raid boss minimum time respawn */
	public static float RAID_MIN_RESPAWN_MULTIPLIER = other().getRaidMinRespawnMultiplier();
	/** Mulitplier for Raid boss maximum time respawn */
	public static float RAID_MAX_RESPAWN_MULTIPLIER = other().getRaidMaxRespawnMultiplier();
	/** Amount of adenas when starting a new character */
	public static int STARTING_ADENA = other().getStartingAdena();
	
	/** Deep Blue Mobs' Drop Rules Enabled */
	public static boolean DEEPBLUE_DROP_RULES = other().getUseDeepBlueDropRules();
	public static int UNSTUCK_INTERVAL = other().getUnstuckInterval();
	
	/** Is telnet enabled ? */
	public static boolean IS_TELNET_ENABLED = telnet().getEnableTelnet();

	/** Telnet bind port */
	public static int STATUS_PORT = telnet().getStatusPort();

	/** Telnet password */
	public static String STATUS_PW = telnet().getStatusPW();

	/** Telnet hosts whitelist */
	public static String LIST_OF_HOSTS = telnet().getListOfHosts();
	
	/** Death Penalty chance */
	public static int DEATH_PENALTY_CHANCE = other().getDeathPenaltyChance();
	
	/** Player Protection control */
	public static int PLAYER_SPAWN_PROTECTION = other().getPlayerSpawnProtection();
	public static int PLAYER_FAKEDEATH_UP_PROTECTION = other().getPlayerFakeDeathUpProtection();
	
	/** Define Party XP cutoff point method - Possible values: level and percentage */
	public static String PARTY_XP_CUTOFF_METHOD = other().getPartyXpCutoffMethod();
	/** Define the cutoff point value for the "level" method */
	public static int PARTY_XP_CUTOFF_LEVEL = other().getPartyXpCutoffLevel();
	/** Define the cutoff point value for the "percentage" method */
	public static double PARTY_XP_CUTOFF_PERCENT = other().getPartyXpCutoffPercent();
	
	/** Percent CP is restore on respawn */
	public static double RESPAWN_RESTORE_CP = other().getRespawnRestoreCP() / 100;
	/** Percent HP is restore on respawn */
	public static double RESPAWN_RESTORE_HP = other().getRespawnRestoreHP() / 100;
	/** Percent MP is restore on respawn */
	public static double RESPAWN_RESTORE_MP = other().getRespawnRestoreMP() / 100;
	/** Allow randomizing of the respawn point in towns. */
	public static boolean RESPAWN_RANDOM_ENABLED = other().getRespawnRandomInTown();
	/** The maximum offset from the base respawn point to allow. */
	public static int RESPAWN_RANDOM_MAX_OFFSET = other().getRespawnRandomMaxOffset();
	
	/** Maximum number of available slots for pvt stores (sell/buy) - Dwarves */
	public static int MAX_PVTSTORE_SLOTS_DWARF = other().getMaxPvtStoreSlotsDwarf();
	/** Maximum number of available slots for pvt stores (sell/buy) - Others */
	public static int MAX_PVTSTORE_SLOTS_OTHER = other().getMaxPvtStoreSlotsOther();
	
	/** Store skills cooltime on char exit/relogin */
	public static boolean STORE_SKILL_COOLTIME = other().getStoreSkillCooltime();
	/** Show licence or not just after login (if false, will directly go to the Server List */
	public static boolean SHOW_LICENCE;
	/** Force GameGuard authorization in loginserver */
	public static boolean FORCE_GGAUTH;
	
	/** Default punishment for illegal actions */
	public static int DEFAULT_PUNISH = options().getDefaultPunish();
	/** Parameter for default punishment */
	public static int DEFAULT_PUNISH_PARAM = options().getDefaultPunishParam();
	
	/** Accept new game server ? */
	public static boolean ACCEPT_NEW_GAMESERVER;
	
	/** Server ID used with the HexID */
	public static int SERVER_ID = hexID().getServerID();
	/** Hexadecimal ID of the game server */
	public static byte[] HEX_ID;
	
	/** Accept alternate ID for server ? */
	public static boolean ACCEPT_ALTERNATE_ID = server().getAcceptAlternateID();
	/** ID for request to the server */
	public static int REQUEST_ID = server().getRequestServerID();
	public static boolean RESERVE_HOST_ON_LOGIN = false;
	
	public static int MINIMUM_UPDATE_DISTANCE = options().getMaximumUpdateDistance();
	public static int KNOWNLIST_FORGET_DELAY = options().getKnownListForgetDelay();
	public static int MINIMUN_UPDATE_TIME = options().getMinimumUpdateTime();
	
	public static boolean ANNOUNCE_MAMMON_SPAWN = other().getAnnounceMammonSpawn();
	public static boolean LAZY_CACHE = options().getLazyCache();
	
	/** Enable colored name for GM ? */
	public static boolean GM_NAME_COLOR_ENABLED = other().getGMNameColorEnabled();
	/** Color of GM name */
	public static int GM_NAME_COLOR = Integer.decode("0x" + other().getGMNameColor());
	/** Color of admin name */
	public static int ADMIN_NAME_COLOR = Integer.decode("0x" + other().getAdminNameColor());
	/** Place an aura around the GM ? */
	public static boolean GM_HERO_AURA = other().getGMHeroAura();
	/** Set the GM invulnerable at startup ? */
	public static boolean GM_STARTUP_INVULNERABLE = other().getGMStartupInvulnerable();
	/** Set the GM invisible at startup ? */
	public static boolean GM_STARTUP_INVISIBLE = other().getGMStartupInvisible();
	/** Set silence to GM at startup ? */
	public static boolean GM_STARTUP_SILENCE = other().getGMStartupSilence();
	/** Add GM in the GM list at startup ? */
	public static boolean GM_STARTUP_AUTO_LIST = other().getGMStartupAutoList();
	/** Change the way admin panel is shown */
	public static String GM_ADMIN_MENU_STYLE = other().getGMAdminMenuStyle();
	
	/** Allow petition ? */
	public static boolean PETITIONING_ALLOWED = other().getPetitioningAllowed();
	/** Maximum number of petitions per player */
	public static int MAX_PETITIONS_PER_PLAYER = other().getMaxPetitionsPerPlayer();
	/** Maximum number of petitions pending */
	public static int MAX_PETITIONS_PENDING = other().getMaxPetitionsPending();
	
	/** Bypass exploit protection ? */
	public static boolean BYPASS_VALIDATION = options().getBypassValidation();
	
	/** Only GM buy items for free **/
	public static boolean ONLY_GM_ITEMS_FREE = options().getOnlyGMItemsFree();
	
	/** GM Audit ? */
	public static boolean GMAUDIT = options().getGMAudit();
	
	/** Allow auto-create account ? */
	public static boolean AUTO_CREATE_ACCOUNTS;
	
	public static boolean FLOOD_PROTECTION;
	public static int FAST_CONNECTION_LIMIT;
	public static int NORMAL_CONNECTION_TIME;
	public static int FAST_CONNECTION_TIME;
	public static int MAX_CONNECTION_PER_IP;
	
	/** Enforce gameguard query on character login ? */
	public static boolean GAMEGUARD_ENFORCE = options().getGameGuardEnforce();
	/** Don't allow player to perform trade,talk with npc and move until gameguard reply received ? */
	public static boolean GAMEGUARD_PROHIBITACTION = options().getGameGuardProhibitAction();
	
	/** Recipebook limits */
	public static int DWARF_RECIPE_LIMIT;
	public static int COMMON_RECIPE_LIMIT;
	
	/** Grid Options */
	public static boolean GRIDS_ALWAYS_ON = options().getGridsAlwaysOn();
	public static int GRID_NEIGHBOR_TURNON_TIME = options().getGridNeighborTurnOnTime();
	public static int GRID_NEIGHBOR_TURNOFF_TIME = options().getGridNeighborTurnOffTime();
	
	/** Clan Hall function related configs */
	public static long CH_TELE_FEE_RATIO;
	public static int CH_TELE1_FEE;
	public static int CH_TELE2_FEE;
	public static long CH_ITEM_FEE_RATIO;
	public static int CH_ITEM1_FEE;
	public static int CH_ITEM2_FEE;
	public static int CH_ITEM3_FEE;
	public static long CH_MPREG_FEE_RATIO;
	public static int CH_MPREG1_FEE;
	public static int CH_MPREG2_FEE;
	public static int CH_MPREG3_FEE;
	public static int CH_MPREG4_FEE;
	public static int CH_MPREG5_FEE;
	public static long CH_HPREG_FEE_RATIO;
	public static int CH_HPREG1_FEE;
	public static int CH_HPREG2_FEE;
	public static int CH_HPREG3_FEE;
	public static int CH_HPREG4_FEE;
	public static int CH_HPREG5_FEE;
	public static int CH_HPREG6_FEE;
	public static int CH_HPREG7_FEE;
	public static int CH_HPREG8_FEE;
	public static int CH_HPREG9_FEE;
	public static int CH_HPREG10_FEE;
	public static int CH_HPREG11_FEE;
	public static int CH_HPREG12_FEE;
	public static int CH_HPREG13_FEE;
	public static long CH_EXPREG_FEE_RATIO;
	public static int CH_EXPREG1_FEE;
	public static int CH_EXPREG2_FEE;
	public static int CH_EXPREG3_FEE;
	public static int CH_EXPREG4_FEE;
	public static int CH_EXPREG5_FEE;
	public static int CH_EXPREG6_FEE;
	public static int CH_EXPREG7_FEE;
	public static long CH_SUPPORT_FEE_RATIO;
	public static int CH_SUPPORT1_FEE;
	public static int CH_SUPPORT2_FEE;
	public static int CH_SUPPORT3_FEE;
	public static int CH_SUPPORT4_FEE;
	public static int CH_SUPPORT5_FEE;
	public static int CH_SUPPORT6_FEE;
	public static int CH_SUPPORT7_FEE;
	public static int CH_SUPPORT8_FEE;
	public static long CH_CURTAIN_FEE_RATIO;
	public static int CH_CURTAIN1_FEE;
	public static int CH_CURTAIN2_FEE;
	public static long CH_FRONT_FEE_RATIO;
	public static int CH_FRONT1_FEE;
	public static int CH_FRONT2_FEE;
	
	/** GeoData 0/1/2 */
	public static int GEODATA = options().getGeoData();
	/** Force loading GeoData to physical memory */
	public static boolean FORCE_GEODATA = options().getForceGeodata();
	public static boolean ACCEPT_GEOEDITOR_CONN = options().getAcceptGeoeditorConn();
	
	/** Max amount of buffs */
	public static byte BUFFS_MAX_AMOUNT;
	
	/** Alt Settings for devs */
	public static boolean ALT_DEV_NO_QUESTS;
	public static boolean ALT_DEV_NO_SPAWNS;
	
	/**
	 * This class initializes all global variables for configuration.<br>
	 * If key doesn't appear in properties file, a default value is setting on by this class.
	 * @see #CONFIGURATION_FILE for configuring your server.
	 */
	public static void load() {
		_log.info("Loading Game Server config...");

		if (MIN_PROTOCOL_REVISION > MAX_PROTOCOL_REVISION) {
			throw new Error("MinProtocolRevision is bigger than MaxProtocolRevision in server configuration file.");
		}

		try {
			DATAPACK_ROOT = new File(server().getDatapackRoot()).getCanonicalFile();
		} catch (Exception e) {
			e.printStackTrace();
			throw new Error("Failed to Load data pack, check DatapackRoot configuration.");
		}

		LIST_PROTECTED_ITEMS = new FastList<>();
		for (String id : PROTECTED_ITEMS.split(",")) {
			LIST_PROTECTED_ITEMS.add(Integer.parseInt(id));
		}

		LIST_PET_RENT_NPC = new FastList<>();
		for (String id : PET_RENT_NPC.split(",")) {
			LIST_PET_RENT_NPC.add(Integer.parseInt(id));
		}

		LIST_NONDROPPABLE_ITEMS = new FastList<>();
		for (String id : NONDROPPABLE_ITEMS.split(",")) {
			LIST_NONDROPPABLE_ITEMS.add(Integer.parseInt(id));
		}
		
		// alternative settings
		try {
			Properties altSettings = new Properties();
			InputStream is = new FileInputStream(new File(ALT_SETTINGS_FILE));
			altSettings.load(is);
			is.close();
			
			ALT_GAME_TIREDNESS = Boolean.parseBoolean(altSettings.getProperty("AltGameTiredness", "false"));
			ALT_GAME_CREATION = Boolean.parseBoolean(altSettings.getProperty("AltGameCreation", "false"));
			ALT_GAME_CREATION_SPEED = Double.parseDouble(altSettings.getProperty("AltGameCreationSpeed", "1"));
			ALT_GAME_CREATION_XP_RATE = Double.parseDouble(altSettings.getProperty("AltGameCreationRateXp", "1"));
			ALT_GAME_CREATION_SP_RATE = Double.parseDouble(altSettings.getProperty("AltGameCreationRateSp", "1"));
			ALT_WEIGHT_LIMIT = Double.parseDouble(altSettings.getProperty("AltWeightLimit", "1"));
			ALT_BLACKSMITH_USE_RECIPES = Boolean.parseBoolean(altSettings.getProperty("AltBlacksmithUseRecipes", "true"));
			ALT_GAME_SKILL_LEARN = Boolean.parseBoolean(altSettings.getProperty("AltGameSkillLearn", "false"));
			AUTO_LEARN_SKILLS = Boolean.parseBoolean(altSettings.getProperty("AutoLearnSkills", "false"));
			ALT_GAME_CANCEL_BOW = altSettings.getProperty("AltGameCancelByHit", "Cast").equalsIgnoreCase("bow") || altSettings.getProperty("AltGameCancelByHit", "Cast").equalsIgnoreCase("all");
			ALT_GAME_CANCEL_CAST = altSettings.getProperty("AltGameCancelByHit", "Cast").equalsIgnoreCase("cast") || altSettings.getProperty("AltGameCancelByHit", "Cast").equalsIgnoreCase("all");
			ALT_GAME_SHIELD_BLOCKS = Boolean.parseBoolean(altSettings.getProperty("AltShieldBlocks", "false"));
			ALT_PERFECT_SHLD_BLOCK = Integer.parseInt(altSettings.getProperty("AltPerfectShieldBlockRate", "10"));
			ALT_GAME_DELEVEL = Boolean.parseBoolean(altSettings.getProperty("Delevel", "true"));
			ALT_GAME_MAGICFAILURES = Boolean.parseBoolean(altSettings.getProperty("MagicFailures", "false"));
			ALT_GAME_MOB_ATTACK_AI = Boolean.parseBoolean(altSettings.getProperty("AltGameMobAttackAI", "false"));
			ALT_MOB_AGRO_IN_PEACEZONE = Boolean.parseBoolean(altSettings.getProperty("AltMobAgroInPeaceZone", "true"));
			ALT_GAME_EXPONENT_XP = Float.parseFloat(altSettings.getProperty("AltGameExponentXp", "0."));
			ALT_GAME_EXPONENT_SP = Float.parseFloat(altSettings.getProperty("AltGameExponentSp", "0."));
			ALLOW_CLASS_MASTERS = Boolean.valueOf(altSettings.getProperty("AllowClassMasters", "False"));
			ALT_GAME_FREIGHTS = Boolean.parseBoolean(altSettings.getProperty("AltGameFreights", "false"));
			ALT_GAME_FREIGHT_PRICE = Integer.parseInt(altSettings.getProperty("AltGameFreightPrice", "1000"));
			ALT_PARTY_RANGE = Integer.parseInt(altSettings.getProperty("AltPartyRange", "1600"));
			ALT_PARTY_RANGE2 = Integer.parseInt(altSettings.getProperty("AltPartyRange2", "1400"));
			REMOVE_CASTLE_CIRCLETS = Boolean.parseBoolean(altSettings.getProperty("RemoveCastleCirclets", "true"));
			IS_CRAFTING_ENABLED = Boolean.parseBoolean(altSettings.getProperty("CraftingEnabled", "true"));
			LIFE_CRYSTAL_NEEDED = Boolean.parseBoolean(altSettings.getProperty("LifeCrystalNeeded", "true"));
			SP_BOOK_NEEDED = Boolean.parseBoolean(altSettings.getProperty("SpBookNeeded", "true"));
			ES_SP_BOOK_NEEDED = Boolean.parseBoolean(altSettings.getProperty("EnchantSkillSpBookNeeded", "true"));
			AUTO_LOOT = altSettings.getProperty("AutoLoot").equalsIgnoreCase("True");
			AUTO_LOOT_HERBS = altSettings.getProperty("AutoLootHerbs").equalsIgnoreCase("True");
			ALT_GAME_KARMA_PLAYER_CAN_BE_KILLED_IN_PEACEZONE = Boolean.valueOf(altSettings.getProperty("AltKarmaPlayerCanBeKilledInPeaceZone", "false"));
			ALT_GAME_KARMA_PLAYER_CAN_SHOP = Boolean.valueOf(altSettings.getProperty("AltKarmaPlayerCanShop", "true"));
			ALT_GAME_KARMA_PLAYER_CAN_USE_GK = Boolean.valueOf(altSettings.getProperty("AltKarmaPlayerCanUseGK", "false"));
			ALT_GAME_KARMA_PLAYER_CAN_TELEPORT = Boolean.valueOf(altSettings.getProperty("AltKarmaPlayerCanTeleport", "true"));
			ALT_GAME_KARMA_PLAYER_CAN_TRADE = Boolean.valueOf(altSettings.getProperty("AltKarmaPlayerCanTrade", "true"));
			ALT_GAME_KARMA_PLAYER_CAN_USE_WAREHOUSE = Boolean.valueOf(altSettings.getProperty("AltKarmaPlayerCanUseWareHouse", "true"));
			ALT_GAME_FREE_TELEPORT = Boolean.parseBoolean(altSettings.getProperty("AltFreeTeleporting", "False"));
			ALT_RECOMMEND = Boolean.parseBoolean(altSettings.getProperty("AltRecommend", "False"));
			ALT_GAME_SUBCLASS_WITHOUT_QUESTS = Boolean.parseBoolean(altSettings.getProperty("AltSubClassWithoutQuests", "False"));
			ALT_GAME_VIEWNPC = Boolean.parseBoolean(altSettings.getProperty("AltGameViewNpc", "False"));
			ALT_GAME_NEW_CHAR_ALWAYS_IS_NEWBIE = Boolean.parseBoolean(altSettings.getProperty("AltNewCharAlwaysIsNewbie", "False"));
			ALT_MEMBERS_CAN_WITHDRAW_FROM_CLANWH = Boolean.parseBoolean(altSettings.getProperty("AltMembersCanWithdrawFromClanWH", "False"));
			ALT_MAX_NUM_OF_CLANS_IN_ALLY = Integer.parseInt(altSettings.getProperty("AltMaxNumOfClansInAlly", "3"));
			DWARF_RECIPE_LIMIT = Integer.parseInt(altSettings.getProperty("DwarfRecipeLimit", "50"));
			COMMON_RECIPE_LIMIT = Integer.parseInt(altSettings.getProperty("CommonRecipeLimit", "50"));
			
			ALT_CLAN_MEMBERS_FOR_WAR = Integer.parseInt(altSettings.getProperty("AltClanMembersForWar", "15"));
			ALT_CLAN_JOIN_DAYS = Integer.parseInt(altSettings.getProperty("DaysBeforeJoinAClan", "5"));
			ALT_CLAN_CREATE_DAYS = Integer.parseInt(altSettings.getProperty("DaysBeforeCreateAClan", "10"));
			ALT_CLAN_DISSOLVE_DAYS = Integer.parseInt(altSettings.getProperty("DaysToPassToDissolveAClan", "7"));
			ALT_ALLY_JOIN_DAYS_WHEN_LEAVED = Integer.parseInt(altSettings.getProperty("DaysBeforeJoinAllyWhenLeaved", "1"));
			ALT_ALLY_JOIN_DAYS_WHEN_DISMISSED = Integer.parseInt(altSettings.getProperty("DaysBeforeJoinAllyWhenDismissed", "1"));
			ALT_ACCEPT_CLAN_DAYS_WHEN_DISMISSED = Integer.parseInt(altSettings.getProperty("DaysBeforeAcceptNewClanWhenDismissed", "1"));
			ALT_CREATE_ALLY_DAYS_WHEN_DISSOLVED = Integer.parseInt(altSettings.getProperty("DaysBeforeCreateNewAllyWhenDissolved", "10"));
			
			ALT_OLY_START_TIME = Integer.parseInt(altSettings.getProperty("AltOlyStartTime", "18"));
			ALT_OLY_MIN = Integer.parseInt(altSettings.getProperty("AltOlyMin", "00"));
			ALT_OLY_CPERIOD = Long.parseLong(altSettings.getProperty("AltOlyCPeriod", "21600000"));
			ALT_OLY_BATTLE = Long.parseLong(altSettings.getProperty("AltOlyBattle", "360000"));
			ALT_OLY_BWAIT = Long.parseLong(altSettings.getProperty("AltOlyBWait", "600000"));
			ALT_OLY_IWAIT = Long.parseLong(altSettings.getProperty("AltOlyIWait", "300000"));
			ALT_OLY_WPERIOD = Long.parseLong(altSettings.getProperty("AltOlyWPeriod", "604800000"));
			ALT_OLY_VPERIOD = Long.parseLong(altSettings.getProperty("AltOlyVPeriod", "86400000"));
			
			ALT_MANOR_REFRESH_TIME = Integer.parseInt(altSettings.getProperty("AltManorRefreshTime", "20"));
			ALT_MANOR_REFRESH_MIN = Integer.parseInt(altSettings.getProperty("AltManorRefreshMin", "00"));
			ALT_MANOR_APPROVE_TIME = Integer.parseInt(altSettings.getProperty("AltManorApproveTime", "6"));
			ALT_MANOR_APPROVE_MIN = Integer.parseInt(altSettings.getProperty("AltManorApproveMin", "00"));
			ALT_MANOR_MAINTENANCE_PERIOD = Integer.parseInt(altSettings.getProperty("AltManorMaintenancePeriod", "360000"));
			ALT_MANOR_SAVE_ALL_ACTIONS = Boolean.parseBoolean(altSettings.getProperty("AltManorSaveAllActions", "false"));
			ALT_MANOR_SAVE_PERIOD_RATE = Integer.parseInt(altSettings.getProperty("AltManorSavePeriodRate", "2"));
			
			ALT_LOTTERY_PRIZE = Integer.parseInt(altSettings.getProperty("AltLotteryPrize", "50000"));
			ALT_LOTTERY_TICKET_PRICE = Integer.parseInt(altSettings.getProperty("AltLotteryTicketPrice", "2000"));
			ALT_LOTTERY_5_NUMBER_RATE = Float.parseFloat(altSettings.getProperty("AltLottery5NumberRate", "0.6"));
			ALT_LOTTERY_4_NUMBER_RATE = Float.parseFloat(altSettings.getProperty("AltLottery4NumberRate", "0.2"));
			ALT_LOTTERY_3_NUMBER_RATE = Float.parseFloat(altSettings.getProperty("AltLottery3NumberRate", "0.2"));
			ALT_LOTTERY_2_AND_1_NUMBER_PRIZE = Integer.parseInt(altSettings.getProperty("AltLottery2and1NumberPrize", "200"));
			BUFFS_MAX_AMOUNT = Byte.parseByte(altSettings.getProperty("maxbuffamount", "24"));
			
			ALT_DEV_NO_QUESTS = Boolean.parseBoolean(altSettings.getProperty("AltDevNoQuests", "False"));
			ALT_DEV_NO_SPAWNS = Boolean.parseBoolean(altSettings.getProperty("AltDevNoSpawns", "False"));
			
			// Dimensional Rift Config
			RIFT_MIN_PARTY_SIZE = Integer.parseInt(altSettings.getProperty("RiftMinPartySize", "5"));
			RIFT_MAX_JUMPS = Integer.parseInt(altSettings.getProperty("MaxRiftJumps", "4"));
			RIFT_SPAWN_DELAY = Integer.parseInt(altSettings.getProperty("RiftSpawnDelay", "10000"));
			RIFT_AUTO_JUMPS_TIME_MIN = Integer.parseInt(altSettings.getProperty("AutoJumpsDelayMin", "480"));
			RIFT_AUTO_JUMPS_TIME_MAX = Integer.parseInt(altSettings.getProperty("AutoJumpsDelayMax", "600"));
			RIFT_ENTER_COST_RECRUIT = Integer.parseInt(altSettings.getProperty("RecruitCost", "18"));
			RIFT_ENTER_COST_SOLDIER = Integer.parseInt(altSettings.getProperty("SoldierCost", "21"));
			RIFT_ENTER_COST_OFFICER = Integer.parseInt(altSettings.getProperty("OfficerCost", "24"));
			RIFT_ENTER_COST_CAPTAIN = Integer.parseInt(altSettings.getProperty("CaptainCost", "27"));
			RIFT_ENTER_COST_COMMANDER = Integer.parseInt(altSettings.getProperty("CommanderCost", "30"));
			RIFT_ENTER_COST_HERO = Integer.parseInt(altSettings.getProperty("HeroCost", "33"));
			RIFT_BOSS_ROOM_TIME_MUTIPLY = Float.parseFloat(altSettings.getProperty("BossRoomTimeMultiply", "1.5"));
		} catch (Exception e) {
			e.printStackTrace();
			throw new Error("Failed to Load " + ALT_SETTINGS_FILE + " File.");
		}
		
		// clanhall settings
		try {
			Properties clanhallSettings = new Properties();
			InputStream is = new FileInputStream(new File(CLANHALL_CONFIG_FILE));
			clanhallSettings.load(is);
			is.close();
			CH_TELE_FEE_RATIO = Long.valueOf(clanhallSettings.getProperty("ClanHallTeleportFunctionFeeRation", "86400000"));
			CH_TELE1_FEE = Integer.valueOf(clanhallSettings.getProperty("ClanHallTeleportFunctionFeeLvl1", "86400000"));
			CH_TELE2_FEE = Integer.valueOf(clanhallSettings.getProperty("ClanHallTeleportFunctionFeeLvl2", "86400000"));
			CH_SUPPORT_FEE_RATIO = Long.valueOf(clanhallSettings.getProperty("ClanHallSupportFunctionFeeRation", "86400000"));
			CH_SUPPORT1_FEE = Integer.valueOf(clanhallSettings.getProperty("ClanHallSupportFeeLvl1", "86400000"));
			CH_SUPPORT2_FEE = Integer.valueOf(clanhallSettings.getProperty("ClanHallSupportFeeLvl2", "86400000"));
			CH_SUPPORT3_FEE = Integer.valueOf(clanhallSettings.getProperty("ClanHallSupportFeeLvl3", "86400000"));
			CH_SUPPORT4_FEE = Integer.valueOf(clanhallSettings.getProperty("ClanHallSupportFeeLvl4", "86400000"));
			CH_SUPPORT5_FEE = Integer.valueOf(clanhallSettings.getProperty("ClanHallSupportFeeLvl5", "86400000"));
			CH_SUPPORT6_FEE = Integer.valueOf(clanhallSettings.getProperty("ClanHallSupportFeeLvl6", "86400000"));
			CH_SUPPORT7_FEE = Integer.valueOf(clanhallSettings.getProperty("ClanHallSupportFeeLvl7", "86400000"));
			CH_SUPPORT8_FEE = Integer.valueOf(clanhallSettings.getProperty("ClanHallSupportFeeLvl8", "86400000"));
			CH_MPREG_FEE_RATIO = Long.valueOf(clanhallSettings.getProperty("ClanHallMpRegenerationFunctionFeeRation", "86400000"));
			CH_MPREG1_FEE = Integer.valueOf(clanhallSettings.getProperty("ClanHallMpRegenerationFeeLvl1", "86400000"));
			CH_MPREG2_FEE = Integer.valueOf(clanhallSettings.getProperty("ClanHallMpRegenerationFeeLvl2", "86400000"));
			CH_MPREG3_FEE = Integer.valueOf(clanhallSettings.getProperty("ClanHallMpRegenerationFeeLvl3", "86400000"));
			CH_MPREG4_FEE = Integer.valueOf(clanhallSettings.getProperty("ClanHallMpRegenerationFeeLvl4", "86400000"));
			CH_MPREG5_FEE = Integer.valueOf(clanhallSettings.getProperty("ClanHallMpRegenerationFeeLvl5", "86400000"));
			CH_HPREG_FEE_RATIO = Long.valueOf(clanhallSettings.getProperty("ClanHallHpRegenerationFunctionFeeRation", "86400000"));
			CH_HPREG1_FEE = Integer.valueOf(clanhallSettings.getProperty("ClanHallHpRegenerationFeeLvl1", "86400000"));
			CH_HPREG2_FEE = Integer.valueOf(clanhallSettings.getProperty("ClanHallHpRegenerationFeeLvl2", "86400000"));
			CH_HPREG3_FEE = Integer.valueOf(clanhallSettings.getProperty("ClanHallHpRegenerationFeeLvl3", "86400000"));
			CH_HPREG4_FEE = Integer.valueOf(clanhallSettings.getProperty("ClanHallHpRegenerationFeeLvl4", "86400000"));
			CH_HPREG5_FEE = Integer.valueOf(clanhallSettings.getProperty("ClanHallHpRegenerationFeeLvl5", "86400000"));
			CH_HPREG6_FEE = Integer.valueOf(clanhallSettings.getProperty("ClanHallHpRegenerationFeeLvl6", "86400000"));
			CH_HPREG7_FEE = Integer.valueOf(clanhallSettings.getProperty("ClanHallHpRegenerationFeeLvl7", "86400000"));
			CH_HPREG8_FEE = Integer.valueOf(clanhallSettings.getProperty("ClanHallHpRegenerationFeeLvl8", "86400000"));
			CH_HPREG9_FEE = Integer.valueOf(clanhallSettings.getProperty("ClanHallHpRegenerationFeeLvl9", "86400000"));
			CH_HPREG10_FEE = Integer.valueOf(clanhallSettings.getProperty("ClanHallHpRegenerationFeeLvl10", "86400000"));
			CH_HPREG11_FEE = Integer.valueOf(clanhallSettings.getProperty("ClanHallHpRegenerationFeeLvl11", "86400000"));
			CH_HPREG12_FEE = Integer.valueOf(clanhallSettings.getProperty("ClanHallHpRegenerationFeeLvl12", "86400000"));
			CH_HPREG13_FEE = Integer.valueOf(clanhallSettings.getProperty("ClanHallHpRegenerationFeeLvl13", "86400000"));
			CH_EXPREG_FEE_RATIO = Long.valueOf(clanhallSettings.getProperty("ClanHallExpRegenerationFunctionFeeRation", "86400000"));
			CH_EXPREG1_FEE = Integer.valueOf(clanhallSettings.getProperty("ClanHallExpRegenerationFeeLvl1", "86400000"));
			CH_EXPREG2_FEE = Integer.valueOf(clanhallSettings.getProperty("ClanHallExpRegenerationFeeLvl2", "86400000"));
			CH_EXPREG3_FEE = Integer.valueOf(clanhallSettings.getProperty("ClanHallExpRegenerationFeeLvl3", "86400000"));
			CH_EXPREG4_FEE = Integer.valueOf(clanhallSettings.getProperty("ClanHallExpRegenerationFeeLvl4", "86400000"));
			CH_EXPREG5_FEE = Integer.valueOf(clanhallSettings.getProperty("ClanHallExpRegenerationFeeLvl5", "86400000"));
			CH_EXPREG6_FEE = Integer.valueOf(clanhallSettings.getProperty("ClanHallExpRegenerationFeeLvl6", "86400000"));
			CH_EXPREG7_FEE = Integer.valueOf(clanhallSettings.getProperty("ClanHallExpRegenerationFeeLvl7", "86400000"));
			CH_ITEM_FEE_RATIO = Long.valueOf(clanhallSettings.getProperty("ClanHallItemCreationFunctionFeeRation", "86400000"));
			CH_ITEM1_FEE = Integer.valueOf(clanhallSettings.getProperty("ClanHallItemCreationFunctionFeeLvl1", "86400000"));
			CH_ITEM2_FEE = Integer.valueOf(clanhallSettings.getProperty("ClanHallItemCreationFunctionFeeLvl2", "86400000"));
			CH_ITEM3_FEE = Integer.valueOf(clanhallSettings.getProperty("ClanHallItemCreationFunctionFeeLvl3", "86400000"));
			CH_CURTAIN_FEE_RATIO = Long.valueOf(clanhallSettings.getProperty("ClanHallCurtainFunctionFeeRation", "86400000"));
			CH_CURTAIN1_FEE = Integer.valueOf(clanhallSettings.getProperty("ClanHallCurtainFunctionFeeLvl1", "86400000"));
			CH_CURTAIN2_FEE = Integer.valueOf(clanhallSettings.getProperty("ClanHallCurtainFunctionFeeLvl2", "86400000"));
			CH_FRONT_FEE_RATIO = Long.valueOf(clanhallSettings.getProperty("ClanHallFrontPlatformFunctionFeeRation", "86400000"));
			CH_FRONT1_FEE = Integer.valueOf(clanhallSettings.getProperty("ClanHallFrontPlatformFunctionFeeLvl1", "86400000"));
			CH_FRONT2_FEE = Integer.valueOf(clanhallSettings.getProperty("ClanHallFrontPlatformFunctionFeeLvl2", "86400000"));
		} catch (Exception e) {
			e.printStackTrace();
			throw new Error("Failed to Load " + CLANHALL_CONFIG_FILE + " File.");
		}

		if (TVT_EVENT_ENABLED) {
			loadTvTConfig();
		}

		// pvp config
		try {
			Properties pvpSettings = new Properties();
			InputStream is = new FileInputStream(new File(PVP_CONFIG_FILE));
			pvpSettings.load(is);
			is.close();
			
			/* KARMA SYSTEM */
			KARMA_MIN_KARMA = Integer.parseInt(pvpSettings.getProperty("MinKarma", "240"));
			KARMA_MAX_KARMA = Integer.parseInt(pvpSettings.getProperty("MaxKarma", "10000"));
			KARMA_XP_DIVIDER = Integer.parseInt(pvpSettings.getProperty("XPDivider", "260"));
			KARMA_LOST_BASE = Integer.parseInt(pvpSettings.getProperty("BaseKarmaLost", "0"));
			
			KARMA_DROP_GM = Boolean.parseBoolean(pvpSettings.getProperty("CanGMDropEquipment", "false"));
			KARMA_AWARD_PK_KILL = Boolean.parseBoolean(pvpSettings.getProperty("AwardPKKillPVPPoint", "true"));
			
			KARMA_PK_LIMIT = Integer.parseInt(pvpSettings.getProperty("MinimumPKRequiredToDrop", "5"));
			
			KARMA_NONDROPPABLE_PET_ITEMS = pvpSettings.getProperty("ListOfPetItems", "2375,3500,3501,3502,4422,4423,4424,4425,6648,6649,6650");
			KARMA_NONDROPPABLE_ITEMS = pvpSettings.getProperty("ListOfNonDroppableItems", "57,1147,425,1146,461,10,2368,7,6,2370,2369,6842,6611,6612,6613,6614,6615,6616,6617,6618,6619,6620,6621");
			
			KARMA_LIST_NONDROPPABLE_PET_ITEMS = new FastList<>();
			for (String id : KARMA_NONDROPPABLE_PET_ITEMS.split(",")) {
				KARMA_LIST_NONDROPPABLE_PET_ITEMS.add(Integer.parseInt(id));
			}
			
			KARMA_LIST_NONDROPPABLE_ITEMS = new FastList<>();
			for (String id : KARMA_NONDROPPABLE_ITEMS.split(",")) {
				KARMA_LIST_NONDROPPABLE_ITEMS.add(Integer.parseInt(id));
			}
			
			PVP_NORMAL_TIME = Integer.parseInt(pvpSettings.getProperty("PvPVsNormalTime", "15000"));
			PVP_PVP_TIME = Integer.parseInt(pvpSettings.getProperty("PvPVsPvPTime", "30000"));
		} catch (Exception e) {
			e.printStackTrace();
			throw new Error("Failed to Load " + PVP_CONFIG_FILE + " File.");
		}
		
		// access levels
		try {
			Properties gmSettings = new Properties();
			InputStream is = new FileInputStream(new File(GM_ACCESS_FILE));
			gmSettings.load(is);
			is.close();
			
			GM_ACCESSLEVEL = Integer.parseInt(gmSettings.getProperty("GMAccessLevel", "100"));
			GM_MIN = Integer.parseInt(gmSettings.getProperty("GMMinLevel", "100"));
			GM_ALTG_MIN_LEVEL = Integer.parseInt(gmSettings.getProperty("GMCanAltG", "100"));
			GM_ANNOUNCE = Integer.parseInt(gmSettings.getProperty("GMCanAnnounce", "100"));
			GM_BAN = Integer.parseInt(gmSettings.getProperty("GMCanBan", "100"));
			GM_BAN_CHAT = Integer.parseInt(gmSettings.getProperty("GMCanBanChat", "100"));
			GM_CREATE_ITEM = Integer.parseInt(gmSettings.getProperty("GMCanShop", "100"));
			GM_DELETE = Integer.parseInt(gmSettings.getProperty("GMCanDelete", "100"));
			GM_KICK = Integer.parseInt(gmSettings.getProperty("GMCanKick", "100"));
			GM_MENU = Integer.parseInt(gmSettings.getProperty("GMMenu", "100"));
			GM_GODMODE = Integer.parseInt(gmSettings.getProperty("GMGodMode", "100"));
			GM_CHAR_EDIT = Integer.parseInt(gmSettings.getProperty("GMCanEditChar", "100"));
			GM_CHAR_EDIT_OTHER = Integer.parseInt(gmSettings.getProperty("GMCanEditCharOther", "100"));
			GM_CHAR_VIEW = Integer.parseInt(gmSettings.getProperty("GMCanViewChar", "100"));
			GM_NPC_EDIT = Integer.parseInt(gmSettings.getProperty("GMCanEditNPC", "100"));
			GM_NPC_VIEW = Integer.parseInt(gmSettings.getProperty("GMCanViewNPC", "100"));
			GM_TELEPORT = Integer.parseInt(gmSettings.getProperty("GMCanTeleport", "100"));
			GM_TELEPORT_OTHER = Integer.parseInt(gmSettings.getProperty("GMCanTeleportOther", "100"));
			GM_RESTART = Integer.parseInt(gmSettings.getProperty("GMCanRestart", "100"));
			GM_MONSTERRACE = Integer.parseInt(gmSettings.getProperty("GMMonsterRace", "100"));
			GM_RIDER = Integer.parseInt(gmSettings.getProperty("GMRider", "100"));
			GM_ESCAPE = Integer.parseInt(gmSettings.getProperty("GMFastUnstuck", "100"));
			GM_FIXED = Integer.parseInt(gmSettings.getProperty("GMResurectFixed", "100"));
			GM_CREATE_NODES = Integer.parseInt(gmSettings.getProperty("GMCreateNodes", "100"));
			GM_ENCHANT = Integer.parseInt(gmSettings.getProperty("GMEnchant", "100"));
			GM_DOOR = Integer.parseInt(gmSettings.getProperty("GMDoor", "100"));
			GM_RES = Integer.parseInt(gmSettings.getProperty("GMRes", "100"));
			GM_PEACEATTACK = Integer.parseInt(gmSettings.getProperty("GMPeaceAttack", "100"));
			GM_HEAL = Integer.parseInt(gmSettings.getProperty("GMHeal", "100"));
			GM_UNBLOCK = Integer.parseInt(gmSettings.getProperty("GMUnblock", "100"));
			GM_CACHE = Integer.parseInt(gmSettings.getProperty("GMCache", "100"));
			GM_TALK_BLOCK = Integer.parseInt(gmSettings.getProperty("GMTalkBlock", "100"));
			GM_TEST = Integer.parseInt(gmSettings.getProperty("GMTest", "100"));
			
			String gmTrans = gmSettings.getProperty("GMDisableTransaction", "False");
			
			if (!gmTrans.equalsIgnoreCase("false")) {
				String[] params = gmTrans.split(",");
				GM_DISABLE_TRANSACTION = true;
				GM_TRANSACTION_MIN = Integer.parseInt(params[0]);
				GM_TRANSACTION_MAX = Integer.parseInt(params[1]);
			} else {
				GM_DISABLE_TRANSACTION = false;
			}
			GM_CAN_GIVE_DAMAGE = Integer.parseInt(gmSettings.getProperty("GMCanGiveDamage", "90"));
			GM_DONT_TAKE_AGGRO = Integer.parseInt(gmSettings.getProperty("GMDontTakeAggro", "90"));
			GM_DONT_TAKE_EXPSP = Integer.parseInt(gmSettings.getProperty("GMDontGiveExpSp", "90"));
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new Error("Failed to Load " + GM_ACCESS_FILE + " File.");
		}

		HEX_ID = new BigInteger(hexID().getHexID(), 16).toByteArray();
	}
	
	/**
	 * Set a new value to a game parameter from the admin console.
	 * @param pName (String) : name of the parameter to change
	 * @param pValue (String) : new value of the parameter
	 * @return boolean : true if modification has been made
	 */
	public static boolean setParameterValue(String pName, String pValue) {
		// Server settings
		if (pName.equalsIgnoreCase("RateXp")) {
			RATE_XP = Float.parseFloat(pValue);
		} else if (pName.equalsIgnoreCase("RateSp")) {
			RATE_SP = Float.parseFloat(pValue);
		} else if (pName.equalsIgnoreCase("RatePartyXp")) {
			RATE_PARTY_XP = Float.parseFloat(pValue);
		} else if (pName.equalsIgnoreCase("RatePartySp")) {
			RATE_PARTY_SP = Float.parseFloat(pValue);
		} else if (pName.equalsIgnoreCase("RateQuestsReward")) {
			RATE_QUESTS_REWARD = Float.parseFloat(pValue);
		} else if (pName.equalsIgnoreCase("RateDropAdena")) {
			RATE_DROP_ADENA = Float.parseFloat(pValue);
		} else if (pName.equalsIgnoreCase("RateConsumableCost")) {
			RATE_CONSUMABLE_COST = Float.parseFloat(pValue);
		} else if (pName.equalsIgnoreCase("RateDropItems")) {
			RATE_DROP_ITEMS = Float.parseFloat(pValue);
		} else if (pName.equalsIgnoreCase("RateDropSpoil")) {
			RATE_DROP_SPOIL = Float.parseFloat(pValue);
		} else if (pName.equalsIgnoreCase("RateDropManor")) {
			RATE_DROP_MANOR = Integer.parseInt(pValue);
		} else if (pName.equalsIgnoreCase("RateDropQuest")) {
			RATE_DROP_QUEST = Float.parseFloat(pValue);
		} else if (pName.equalsIgnoreCase("RateKarmaExpLost")) {
			RATE_KARMA_EXP_LOST = Float.parseFloat(pValue);
		} else if (pName.equalsIgnoreCase("RateSiegeGuardsPrice")) {
			RATE_SIEGE_GUARDS_PRICE = Float.parseFloat(pValue);
		} else if (pName.equalsIgnoreCase("PlayerDropLimit")) {
			PLAYER_DROP_LIMIT = Integer.parseInt(pValue);
		} else if (pName.equalsIgnoreCase("PlayerRateDrop")) {
			PLAYER_RATE_DROP = Integer.parseInt(pValue);
		} else if (pName.equalsIgnoreCase("PlayerRateDropItem")) {
			PLAYER_RATE_DROP_ITEM = Integer.parseInt(pValue);
		} else if (pName.equalsIgnoreCase("PlayerRateDropEquip")) {
			PLAYER_RATE_DROP_EQUIP = Integer.parseInt(pValue);
		} else if (pName.equalsIgnoreCase("PlayerRateDropEquipWeapon")) {
			PLAYER_RATE_DROP_EQUIP_WEAPON = Integer.parseInt(pValue);
		} else if (pName.equalsIgnoreCase("KarmaDropLimit")) {
			KARMA_DROP_LIMIT = Integer.parseInt(pValue);
		} else if (pName.equalsIgnoreCase("KarmaRateDrop")) {
			KARMA_RATE_DROP = Integer.parseInt(pValue);
		} else if (pName.equalsIgnoreCase("KarmaRateDropItem")) {
			KARMA_RATE_DROP_ITEM = Integer.parseInt(pValue);
		} else if (pName.equalsIgnoreCase("KarmaRateDropEquip")) {
			KARMA_RATE_DROP_EQUIP = Integer.parseInt(pValue);
		} else if (pName.equalsIgnoreCase("KarmaRateDropEquipWeapon")) {
			KARMA_RATE_DROP_EQUIP_WEAPON = Integer.parseInt(pValue);
		} else if (pName.equalsIgnoreCase("AutoDestroyDroppedItemAfter")) {
			AUTODESTROY_ITEM_AFTER = Integer.parseInt(pValue);
		} else if (pName.equalsIgnoreCase("DestroyPlayerDroppedItem")) {
			DESTROY_DROPPED_PLAYER_ITEM = Boolean.valueOf(pValue);
		} else if (pName.equalsIgnoreCase("DestroyEquipableItem")) {
			DESTROY_EQUIPABLE_PLAYER_ITEM = Boolean.valueOf(pValue);
		} else if (pName.equalsIgnoreCase("SaveDroppedItem")) {
			SAVE_DROPPED_ITEM = Boolean.valueOf(pValue);
		} else if (pName.equalsIgnoreCase("EmptyDroppedItemTableAfterLoad")) {
			EMPTY_DROPPED_ITEM_TABLE_AFTER_LOAD = Boolean.valueOf(pValue);
		} else if (pName.equalsIgnoreCase("SaveDroppedItemInterval")) {
			SAVE_DROPPED_ITEM_INTERVAL = Integer.parseInt(pValue);
		} else if (pName.equalsIgnoreCase("ClearDroppedItemTable")) {
			CLEAR_DROPPED_ITEM_TABLE = Boolean.valueOf(pValue);
		} else if (pName.equalsIgnoreCase("PreciseDropCalculation")) {
			PRECISE_DROP_CALCULATION = Boolean.valueOf(pValue);
		} else if (pName.equalsIgnoreCase("MultipleItemDrop")) {
			MULTIPLE_ITEM_DROP = Boolean.valueOf(pValue);
		} else if (pName.equalsIgnoreCase("CoordSynchronize")) {
			COORD_SYNCHRONIZE = Integer.parseInt(pValue);
		} else if (pName.equalsIgnoreCase("DeleteCharAfterDays")) {
			DELETE_DAYS = Integer.parseInt(pValue);
		} else if (pName.equalsIgnoreCase("AllowDiscardItem")) {
			ALLOW_DISCARDITEM = Boolean.valueOf(pValue);
		} else if (pName.equalsIgnoreCase("AllowFreight")) {
			ALLOW_FREIGHT = Boolean.valueOf(pValue);
		} else if (pName.equalsIgnoreCase("AllowWarehouse")) {
			ALLOW_WAREHOUSE = Boolean.valueOf(pValue);
		} else if (pName.equalsIgnoreCase("AllowWear")) {
			ALLOW_WEAR = Boolean.valueOf(pValue);
		} else if (pName.equalsIgnoreCase("WearDelay")) {
			WEAR_DELAY = Integer.parseInt(pValue);
		} else if (pName.equalsIgnoreCase("WearPrice")) {
			WEAR_PRICE = Integer.parseInt(pValue);
		} else if (pName.equalsIgnoreCase("AllowWater")) {
			ALLOW_WATER = Boolean.valueOf(pValue);
		} else if (pName.equalsIgnoreCase("AllowRentPet")) {
			ALLOW_RENTPET = Boolean.valueOf(pValue);
		} else if (pName.equalsIgnoreCase("AllowBoat")) {
			ALLOW_BOAT = Boolean.valueOf(pValue);
		} else if (pName.equalsIgnoreCase("AllowCursedWeapons")) {
			ALLOW_CURSED_WEAPONS = Boolean.valueOf(pValue);
		} else if (pName.equalsIgnoreCase("AllowManor")) {
			ALLOW_MANOR = Boolean.valueOf(pValue);
		} else if (pName.equalsIgnoreCase("BypassValidation")) {
			BYPASS_VALIDATION = Boolean.valueOf(pValue);
		} else if (pName.equalsIgnoreCase("CommunityType")) {
			COMMUNITY_TYPE = pValue.toLowerCase();
		} else if (pName.equalsIgnoreCase("BBSDefault")) {
			BBS_DEFAULT = pValue;
		} else if (pName.equalsIgnoreCase("ShowLevelOnCommunityBoard")) {
			SHOW_LEVEL_COMMUNITYBOARD = Boolean.valueOf(pValue);
		} else if (pName.equalsIgnoreCase("ShowStatusOnCommunityBoard")) {
			SHOW_STATUS_COMMUNITYBOARD = Boolean.valueOf(pValue);
		} else if (pName.equalsIgnoreCase("NamePageSizeOnCommunityBoard")) {
			NAME_PAGE_SIZE_COMMUNITYBOARD = Integer.parseInt(pValue);
		} else if (pName.equalsIgnoreCase("NamePerRowOnCommunityBoard")) {
			NAME_PER_ROW_COMMUNITYBOARD = Integer.parseInt(pValue);
		} else if (pName.equalsIgnoreCase("ShowServerNews")) {
			SERVER_NEWS = Boolean.valueOf(pValue);
		} else if (pName.equalsIgnoreCase("ShowNpcLevel")) {
			SHOW_NPC_LVL = Boolean.valueOf(pValue);
		} else if (pName.equalsIgnoreCase("ForceInventoryUpdate")) {
			FORCE_INVENTORY_UPDATE = Boolean.valueOf(pValue);
		} else if (pName.equalsIgnoreCase("AutoDeleteInvalidQuestData")) {
			AUTODELETE_INVALID_QUEST_DATA = Boolean.valueOf(pValue);
		} else if (pName.equalsIgnoreCase("MaximumOnlineUsers")) {
			MAXIMUM_ONLINE_USERS = Integer.parseInt(pValue);
		} else if (pName.equalsIgnoreCase("ZoneTown")) {
			ZONE_TOWN = Integer.parseInt(pValue);
		} else if (pName.equalsIgnoreCase("MaximumUpdateDistance")) {
			MINIMUM_UPDATE_DISTANCE = Integer.parseInt(pValue);
		} else if (pName.equalsIgnoreCase("MinimumUpdateTime")) {
			MINIMUN_UPDATE_TIME = Integer.parseInt(pValue);
		} else if (pName.equalsIgnoreCase("CheckKnownList")) {
			CHECK_KNOWN = Boolean.valueOf(pValue);
		} else if (pName.equalsIgnoreCase("KnownListForgetDelay")) {
			KNOWNLIST_FORGET_DELAY = Integer.parseInt(pValue);
		} else if (pName.equalsIgnoreCase("UseDeepBlueDropRules")) {
			DEEPBLUE_DROP_RULES = Boolean.valueOf(pValue);
		} else if (pName.equalsIgnoreCase("AllowGuards")) {
			ALLOW_GUARDS = Boolean.valueOf(pValue);
		} else if (pName.equalsIgnoreCase("CancelLesserEffect")) {
			EFFECT_CANCELING = Boolean.valueOf(pValue);
		} else if (pName.equalsIgnoreCase("WyvernSpeed")) {
			WYVERN_SPEED = Integer.parseInt(pValue);
		} else if (pName.equalsIgnoreCase("StriderSpeed")) {
			STRIDER_SPEED = Integer.parseInt(pValue);
		} else if (pName.equalsIgnoreCase("MaximumSlotsForNoDwarf")) {
			INVENTORY_MAXIMUM_NO_DWARF = Integer.parseInt(pValue);
		} else if (pName.equalsIgnoreCase("MaximumSlotsForDwarf")) {
			INVENTORY_MAXIMUM_DWARF = Integer.parseInt(pValue);
		} else if (pName.equalsIgnoreCase("MaximumSlotsForGMPlayer")) {
			INVENTORY_MAXIMUM_GM = Integer.parseInt(pValue);
		} else if (pName.equalsIgnoreCase("MaximumWarehouseSlotsForNoDwarf")) {
			WAREHOUSE_SLOTS_NO_DWARF = Integer.parseInt(pValue);
		} else if (pName.equalsIgnoreCase("MaximumWarehouseSlotsForDwarf")) {
			WAREHOUSE_SLOTS_DWARF = Integer.parseInt(pValue);
		} else if (pName.equalsIgnoreCase("MaximumWarehouseSlotsForClan")) {
			WAREHOUSE_SLOTS_CLAN = Integer.parseInt(pValue);
		} else if (pName.equalsIgnoreCase("MaximumFreightSlots")) {
			FREIGHT_SLOTS = Integer.parseInt(pValue);
		} else if (pName.equalsIgnoreCase("EnchantChanceWeapon")) {
			ENCHANT_CHANCE_WEAPON = Integer.parseInt(pValue);
		} else if (pName.equalsIgnoreCase("EnchantChanceArmor")) {
			ENCHANT_CHANCE_ARMOR = Integer.parseInt(pValue);
		} else if (pName.equalsIgnoreCase("EnchantChanceJewelry")) {
			ENCHANT_CHANCE_JEWELRY = Integer.parseInt(pValue);
		} else if (pName.equalsIgnoreCase("EnchantMaxWeapon")) {
			ENCHANT_MAX_WEAPON = Integer.parseInt(pValue);
		} else if (pName.equalsIgnoreCase("EnchantMaxArmor")) {
			ENCHANT_MAX_ARMOR = Integer.parseInt(pValue);
		} else if (pName.equalsIgnoreCase("EnchantMaxJewelry")) {
			ENCHANT_MAX_JEWELRY = Integer.parseInt(pValue);
		} else if (pName.equalsIgnoreCase("EnchantSafeMax")) {
			ENCHANT_SAFE_MAX = Integer.parseInt(pValue);
		} else if (pName.equalsIgnoreCase("EnchantSafeMaxFull")) {
			ENCHANT_SAFE_MAX_FULL = Integer.parseInt(pValue);
		} else if (pName.equalsIgnoreCase("HpRegenMultiplier")) {
			HP_REGEN_MULTIPLIER = Double.parseDouble(pValue);
		} else if (pName.equalsIgnoreCase("MpRegenMultiplier")) {
			MP_REGEN_MULTIPLIER = Double.parseDouble(pValue);
		} else if (pName.equalsIgnoreCase("CpRegenMultiplier")) {
			CP_REGEN_MULTIPLIER = Double.parseDouble(pValue);
		} else if (pName.equalsIgnoreCase("RaidHpRegenMultiplier")) {
			RAID_HP_REGEN_MULTIPLIER = Double.parseDouble(pValue);
		} else if (pName.equalsIgnoreCase("RaidMpRegenMultiplier")) {
			RAID_MP_REGEN_MULTIPLIER = Double.parseDouble(pValue);
		} else if (pName.equalsIgnoreCase("RaidDefenceMultiplier")) {
			RAID_DEFENCE_MULTIPLIER = Double.parseDouble(pValue) / 100;
		} else if (pName.equalsIgnoreCase("RaidMinionRespawnTime")) {
			RAID_MINION_RESPAWN_TIMER = Integer.parseInt(pValue);
		} else if (pName.equalsIgnoreCase("StartingAdena")) {
			STARTING_ADENA = Integer.parseInt(pValue);
		} else if (pName.equalsIgnoreCase("UnstuckInterval")) {
			UNSTUCK_INTERVAL = Integer.parseInt(pValue);
		} else if (pName.equalsIgnoreCase("PlayerSpawnProtection")) {
			PLAYER_SPAWN_PROTECTION = Integer.parseInt(pValue);
		} else if (pName.equalsIgnoreCase("PlayerFakeDeathUpProtection")) {
			PLAYER_FAKEDEATH_UP_PROTECTION = Integer.parseInt(pValue);
		} else if (pName.equalsIgnoreCase("PartyXpCutoffMethod")) {
			PARTY_XP_CUTOFF_METHOD = pValue;
		} else if (pName.equalsIgnoreCase("PartyXpCutoffPercent")) {
			PARTY_XP_CUTOFF_PERCENT = Double.parseDouble(pValue);
		} else if (pName.equalsIgnoreCase("PartyXpCutoffLevel")) {
			PARTY_XP_CUTOFF_LEVEL = Integer.parseInt(pValue);
		} else if (pName.equalsIgnoreCase("RespawnRestoreCP")) {
			RESPAWN_RESTORE_CP = Double.parseDouble(pValue) / 100;
		} else if (pName.equalsIgnoreCase("RespawnRestoreHP")) {
			RESPAWN_RESTORE_HP = Double.parseDouble(pValue) / 100;
		} else if (pName.equalsIgnoreCase("RespawnRestoreMP")) {
			RESPAWN_RESTORE_MP = Double.parseDouble(pValue) / 100;
		} else if (pName.equalsIgnoreCase("MaxPvtStoreSlotsDwarf")) {
			MAX_PVTSTORE_SLOTS_DWARF = Integer.parseInt(pValue);
		} else if (pName.equalsIgnoreCase("MaxPvtStoreSlotsOther")) {
			MAX_PVTSTORE_SLOTS_OTHER = Integer.parseInt(pValue);
		} else if (pName.equalsIgnoreCase("StoreSkillCooltime")) {
			STORE_SKILL_COOLTIME = Boolean.valueOf(pValue);
		} else if (pName.equalsIgnoreCase("AnnounceMammonSpawn")) {
			ANNOUNCE_MAMMON_SPAWN = Boolean.valueOf(pValue);
		} else if (pName.equalsIgnoreCase("AltGameTiredness")) {
			ALT_GAME_TIREDNESS = Boolean.valueOf(pValue);
		} else if (pName.equalsIgnoreCase("AltGameCreation")) {
			ALT_GAME_CREATION = Boolean.valueOf(pValue);
		} else if (pName.equalsIgnoreCase("AltGameCreationSpeed")) {
			ALT_GAME_CREATION_SPEED = Double.parseDouble(pValue);
		} else if (pName.equalsIgnoreCase("AltGameCreationXpRate")) {
			ALT_GAME_CREATION_XP_RATE = Double.parseDouble(pValue);
		} else if (pName.equalsIgnoreCase("AltGameCreationSpRate")) {
			ALT_GAME_CREATION_SP_RATE = Double.parseDouble(pValue);
		} else if (pName.equalsIgnoreCase("AltWeightLimit")) {
			ALT_WEIGHT_LIMIT = Double.parseDouble(pValue);
		} else if (pName.equalsIgnoreCase("AltBlacksmithUseRecipes")) {
			ALT_BLACKSMITH_USE_RECIPES = Boolean.valueOf(pValue);
		} else if (pName.equalsIgnoreCase("AltGameSkillLearn")) {
			ALT_GAME_SKILL_LEARN = Boolean.valueOf(pValue);
		} else if (pName.equalsIgnoreCase("RemoveCastleCirclets")) {
			REMOVE_CASTLE_CIRCLETS = Boolean.valueOf(pValue);
		} else if (pName.equalsIgnoreCase("AltGameCancelByHit")) {
			ALT_GAME_CANCEL_BOW = pValue.equalsIgnoreCase("bow") || pValue.equalsIgnoreCase("all");
			ALT_GAME_CANCEL_CAST = pValue.equalsIgnoreCase("cast") || pValue.equalsIgnoreCase("all");
		}
		
		else if (pName.equalsIgnoreCase("AltShieldBlocks")) {
			ALT_GAME_SHIELD_BLOCKS = Boolean.valueOf(pValue);
		} else if (pName.equalsIgnoreCase("AltPerfectShieldBlockRate")) {
			ALT_PERFECT_SHLD_BLOCK = Integer.parseInt(pValue);
		} else if (pName.equalsIgnoreCase("Delevel")) {
			ALT_GAME_DELEVEL = Boolean.valueOf(pValue);
		} else if (pName.equalsIgnoreCase("MagicFailures")) {
			ALT_GAME_MAGICFAILURES = Boolean.valueOf(pValue);
		} else if (pName.equalsIgnoreCase("AltGameMobAttackAI")) {
			ALT_GAME_MOB_ATTACK_AI = Boolean.valueOf(pValue);
		} else if (pName.equalsIgnoreCase("AltMobAgroInPeaceZone")) {
			ALT_MOB_AGRO_IN_PEACEZONE = Boolean.valueOf(pValue);
		} else if (pName.equalsIgnoreCase("AltGameExponentXp")) {
			ALT_GAME_EXPONENT_XP = Float.parseFloat(pValue);
		} else if (pName.equalsIgnoreCase("AltGameExponentSp")) {
			ALT_GAME_EXPONENT_SP = Float.parseFloat(pValue);
		} else if (pName.equalsIgnoreCase("AllowClassMasters")) {
			ALLOW_CLASS_MASTERS = Boolean.valueOf(pValue);
		} else if (pName.equalsIgnoreCase("AltGameFreights")) {
			ALT_GAME_FREIGHTS = Boolean.valueOf(pValue);
		} else if (pName.equalsIgnoreCase("AltGameFreightPrice")) {
			ALT_GAME_FREIGHT_PRICE = Integer.parseInt(pValue);
		} else if (pName.equalsIgnoreCase("AltPartyRange")) {
			ALT_PARTY_RANGE = Integer.parseInt(pValue);
		} else if (pName.equalsIgnoreCase("AltPartyRange2")) {
			ALT_PARTY_RANGE2 = Integer.parseInt(pValue);
		} else if (pName.equalsIgnoreCase("CraftingEnabled")) {
			IS_CRAFTING_ENABLED = Boolean.valueOf(pValue);
		} else if (pName.equalsIgnoreCase("LifeCrystalNeeded")) {
			LIFE_CRYSTAL_NEEDED = Boolean.valueOf(pValue);
		} else if (pName.equalsIgnoreCase("SpBookNeeded")) {
			SP_BOOK_NEEDED = Boolean.valueOf(pValue);
		} else if (pName.equalsIgnoreCase("AutoLoot")) {
			AUTO_LOOT = Boolean.valueOf(pValue);
		} else if (pName.equalsIgnoreCase("AutoLootHerbs")) {
			AUTO_LOOT_HERBS = Boolean.valueOf(pValue);
		} else if (pName.equalsIgnoreCase("AltKarmaPlayerCanBeKilledInPeaceZone")) {
			ALT_GAME_KARMA_PLAYER_CAN_BE_KILLED_IN_PEACEZONE = Boolean.valueOf(pValue);
		} else if (pName.equalsIgnoreCase("AltKarmaPlayerCanShop")) {
			ALT_GAME_KARMA_PLAYER_CAN_SHOP = Boolean.valueOf(pValue);
		} else if (pName.equalsIgnoreCase("AltKarmaPlayerCanUseGK")) {
			ALT_GAME_KARMA_PLAYER_CAN_USE_GK = Boolean.valueOf(pValue);
		} else if (pName.equalsIgnoreCase("AltKarmaPlayerCanTeleport")) {
			ALT_GAME_KARMA_PLAYER_CAN_TELEPORT = Boolean.valueOf(pValue);
		} else if (pName.equalsIgnoreCase("AltKarmaPlayerCanTrade")) {
			ALT_GAME_KARMA_PLAYER_CAN_TRADE = Boolean.valueOf(pValue);
		} else if (pName.equalsIgnoreCase("AltKarmaPlayerCanUseWareHouse")) {
			ALT_GAME_KARMA_PLAYER_CAN_USE_WAREHOUSE = Boolean.valueOf(pValue);
		} else if (pName.equalsIgnoreCase("AltRequireCastleForDawn")) {
			ALT_GAME_REQUIRE_CASTLE_DAWN = Boolean.valueOf(pValue);
		} else if (pName.equalsIgnoreCase("AltRequireClanCastle")) {
			ALT_GAME_REQUIRE_CLAN_CASTLE = Boolean.valueOf(pValue);
		} else if (pName.equalsIgnoreCase("AltFreeTeleporting")) {
			ALT_GAME_FREE_TELEPORT = Boolean.valueOf(pValue);
		} else if (pName.equalsIgnoreCase("AltSubClassWithoutQuests")) {
			ALT_GAME_SUBCLASS_WITHOUT_QUESTS = Boolean.valueOf(pValue);
		} else if (pName.equalsIgnoreCase("AltNewCharAlwaysIsNewbie")) {
			ALT_GAME_NEW_CHAR_ALWAYS_IS_NEWBIE = Boolean.valueOf(pValue);
		} else if (pName.equalsIgnoreCase("AltMembersCanWithdrawFromClanWH")) {
			ALT_MEMBERS_CAN_WITHDRAW_FROM_CLANWH = Boolean.valueOf(pValue);
		} else if (pName.equalsIgnoreCase("DwarfRecipeLimit")) {
			DWARF_RECIPE_LIMIT = Integer.parseInt(pValue);
		} else if (pName.equalsIgnoreCase("CommonRecipeLimit")) {
			COMMON_RECIPE_LIMIT = Integer.parseInt(pValue);
		} else if (pName.equalsIgnoreCase("ChampionEnable")) {
			L2JMOD_CHAMPION_ENABLE = Boolean.valueOf(pValue);
		} else if (pName.equalsIgnoreCase("ChampionFrequency")) {
			L2JMOD_CHAMPION_FREQUENCY = Integer.parseInt(pValue);
		} else if (pName.equalsIgnoreCase("ChampionMinLevel")) {
			L2JMOD_CHAMP_MIN_LVL = Integer.parseInt(pValue);
		} else if (pName.equalsIgnoreCase("ChampionMaxLevel")) {
			L2JMOD_CHAMP_MAX_LVL = Integer.parseInt(pValue);
		} else if (pName.equalsIgnoreCase("ChampionHp")) {
			L2JMOD_CHAMPION_HP = Integer.parseInt(pValue);
		} else if (pName.equalsIgnoreCase("ChampionHpRegen")) {
			L2JMOD_CHAMPION_HP_REGEN = Float.parseFloat(pValue);
		} else if (pName.equalsIgnoreCase("ChampionRewards")) {
			L2JMOD_CHAMPION_REWARDS = Integer.parseInt(pValue);
		} else if (pName.equalsIgnoreCase("ChampionAdenasRewards")) {
			L2JMOD_CHAMPION_ADENAS_REWARDS = Integer.parseInt(pValue);
		} else if (pName.equalsIgnoreCase("ChampionAtk")) {
			L2JMOD_CHAMPION_ATK = Float.parseFloat(pValue);
		} else if (pName.equalsIgnoreCase("ChampionSpdAtk")) {
			L2JMOD_CHAMPION_SPD_ATK = Float.parseFloat(pValue);
		} else if (pName.equalsIgnoreCase("ChampionRewardItem")) {
			L2JMOD_CHAMPION_REWARD = Integer.parseInt(pValue);
		} else if (pName.equalsIgnoreCase("ChampionRewardItemID")) {
			L2JMOD_CHAMPION_REWARD_ID = Integer.parseInt(pValue);
		} else if (pName.equalsIgnoreCase("ChampionRewardItemQty")) {
			L2JMOD_CHAMPION_REWARD_QTY = Integer.parseInt(pValue);
		} else if (pName.equalsIgnoreCase("AllowWedding")) {
			L2JMOD_ALLOW_WEDDING = Boolean.valueOf(pValue);
		} else if (pName.equalsIgnoreCase("WeddingPrice")) {
			L2JMOD_WEDDING_PRICE = Integer.parseInt(pValue);
		} else if (pName.equalsIgnoreCase("WeddingPunishInfidelity")) {
			L2JMOD_WEDDING_PUNISH_INFIDELITY = Boolean.parseBoolean(pValue);
		} else if (pName.equalsIgnoreCase("WeddingTeleport")) {
			L2JMOD_WEDDING_TELEPORT = Boolean.parseBoolean(pValue);
		} else if (pName.equalsIgnoreCase("WeddingTeleportPrice")) {
			L2JMOD_WEDDING_TELEPORT_PRICE = Integer.parseInt(pValue);
		} else if (pName.equalsIgnoreCase("WeddingTeleportDuration")) {
			L2JMOD_WEDDING_TELEPORT_DURATION = Integer.parseInt(pValue);
		} else if (pName.equalsIgnoreCase("WeddingAllowSameSex")) {
			L2JMOD_WEDDING_SAMESEX = Boolean.parseBoolean(pValue);
		} else if (pName.equalsIgnoreCase("WeddingFormalWear")) {
			L2JMOD_WEDDING_FORMALWEAR = Boolean.parseBoolean(pValue);
		} else if (pName.equalsIgnoreCase("WeddingDivorceCosts")) {
			L2JMOD_WEDDING_DIVORCE_COSTS = Integer.parseInt(pValue);
		} else if (pName.equalsIgnoreCase("TvTEventEnabled")) {
			TVT_EVENT_ENABLED = Boolean.parseBoolean(pValue);
		} else if (pName.equalsIgnoreCase("TvTEventInterval")) {
			TVT_EVENT_INTERVAL = Integer.parseInt(pValue);
		} else if (pName.equalsIgnoreCase("TvTEventParticipationTime")) {
			TVT_EVENT_PARTICIPATION_TIME = Integer.parseInt(pValue);
		} else if (pName.equalsIgnoreCase("TvTEventRunningTime")) {
			TVT_EVENT_RUNNING_TIME = Integer.parseInt(pValue);
		} else if (pName.equalsIgnoreCase("TvTEventParticipationNpcId")) {
			TVT_EVENT_PARTICIPATION_NPC_ID = Integer.parseInt(pValue);
		} else if (pName.equalsIgnoreCase("MinKarma")) {
			KARMA_MIN_KARMA = Integer.parseInt(pValue);
		} else if (pName.equalsIgnoreCase("MaxKarma")) {
			KARMA_MAX_KARMA = Integer.parseInt(pValue);
		} else if (pName.equalsIgnoreCase("XPDivider")) {
			KARMA_XP_DIVIDER = Integer.parseInt(pValue);
		} else if (pName.equalsIgnoreCase("BaseKarmaLost")) {
			KARMA_LOST_BASE = Integer.parseInt(pValue);
		} else if (pName.equalsIgnoreCase("CanGMDropEquipment")) {
			KARMA_DROP_GM = Boolean.valueOf(pValue);
		} else if (pName.equalsIgnoreCase("AwardPKKillPVPPoint")) {
			KARMA_AWARD_PK_KILL = Boolean.valueOf(pValue);
		} else if (pName.equalsIgnoreCase("MinimumPKRequiredToDrop")) {
			KARMA_PK_LIMIT = Integer.parseInt(pValue);
		} else if (pName.equalsIgnoreCase("PvPVsNormalTime")) {
			PVP_NORMAL_TIME = Integer.parseInt(pValue);
		} else if (pName.equalsIgnoreCase("PvPVsPvPTime")) {
			PVP_PVP_TIME = Integer.parseInt(pValue);
		} else if (pName.equalsIgnoreCase("GlobalChat")) {
			DEFAULT_GLOBAL_CHAT = pValue;
		} else if (pName.equalsIgnoreCase("TradeChat")) {
			DEFAULT_TRADE_CHAT = pValue;
		} else if (pName.equalsIgnoreCase("MenuStyle")) {
			GM_ADMIN_MENU_STYLE = pValue;
		} else {
			return false;
		}
		return true;
	}
	
	/**
	 * Allow the player to use L2Walker ?
	 * @param player (L2PcInstance) : Player trying to use L2Walker
	 * @return boolean : true if (L2Walker allowed as a general rule) or (L2Walker client allowed for GM and player is a GM)
	 */
	public static boolean allowL2Walker(L2PcInstance player) {
		return ((ALLOW_L2WALKER_CLIENT == L2WalkerAllowed.True) || ((ALLOW_L2WALKER_CLIENT == L2WalkerAllowed.GM) && (player != null) && player.isGM()));
	}
	
	// it has no instances
	private Config() {
	}
	
	/**
	 * Save hexadecimal ID of the server in the properties file.
	 * @param serverId
	 * @param string (String) : hexadecimal ID of the server to store
	 * @see #HEXID_FILE
	 * @see #saveHexid(int, String, String)
	 */
	public static void saveHexid(int serverId, String string) {
		Config.saveHexid(serverId, string, HEXID_FILE);
	}
	
	/**
	 * Save hexadecimal ID of the server in the properties file.
	 * @param serverId
	 * @param hexId (String) : hexadecimal ID of the server to store
	 * @param fileName (String) : name of the properties file
	 */
	public static void saveHexid(int serverId, String hexId, String fileName) {
		try {
			Properties hexSetting = new Properties();
			File file = new File(fileName);
			// Create a new empty file only if it doesn't exist
			file.createNewFile();
			OutputStream out = new FileOutputStream(file);
			hexSetting.setProperty("ServerID", String.valueOf(serverId));
			hexSetting.setProperty("HexID", hexId);
			hexSetting.store(out, "the hexID to auth into login");
			out.close();
		} catch (Exception e) {
			_log.warning("Failed to save hex id to " + fileName + " File.");
			e.printStackTrace();
		}
	}

	private static void loadTvTConfig() {
		String[] participationNpcCoordinates = l2JMods().getTvTEventParticipationNpcCoordinates().split(",");
		String[] team1Coordinates = l2JMods().getTvTEventTeam1Coordinates().split(",");
		String[] team2Coordinates = l2JMods().getTvTEventTeam2Coordinates().split(",");
		String[] eventDoors = l2JMods().getTvTEventDoorsCloseOpenOnStartEnd().split(";");
		String[] eventRewards = l2JMods().getTvTEventReward().split(";");

		if (TVT_EVENT_PARTICIPATION_NPC_ID == 0) {
			TVT_EVENT_ENABLED = false;
			System.out.println("TvTEventEngine[Config.load()]: invalid config property -> TvTEventParticipationNpcId");
		}

		if (participationNpcCoordinates.length < 3) {
			TVT_EVENT_ENABLED = false;
			System.out.println("TvTEventEngine[Config.load()]: invalid config property -> TvTEventParticipationNpcCoordinates");
		}

		if (team1Coordinates.length < 3) {
			TVT_EVENT_ENABLED = false;
			System.out.println("TvTEventEngine[Config.load()]: invalid config property -> TvTEventTeam1Coordinates");
		}

		if (team2Coordinates.length < 3) {
			TVT_EVENT_ENABLED = false;
			System.out.println("TvTEventEngine[Config.load()]: invalid config property -> TvTEventTeam2Coordinates");
		}

		if (!TVT_EVENT_ENABLED) {
			return;
		}

		TVT_EVENT_PARTICIPATION_NPC_COORDINATES[0] = Integer.parseInt(participationNpcCoordinates[0]);
		TVT_EVENT_PARTICIPATION_NPC_COORDINATES[1] = Integer.parseInt(participationNpcCoordinates[1]);
		TVT_EVENT_PARTICIPATION_NPC_COORDINATES[2] = Integer.parseInt(participationNpcCoordinates[2]);

		TVT_EVENT_TEAM_1_COORDINATES[0] = Integer.parseInt(team1Coordinates[0]);
		TVT_EVENT_TEAM_1_COORDINATES[1] = Integer.parseInt(team1Coordinates[1]);
		TVT_EVENT_TEAM_1_COORDINATES[2] = Integer.parseInt(team1Coordinates[2]);

		TVT_EVENT_TEAM_2_COORDINATES[0] = Integer.parseInt(team2Coordinates[0]);
		TVT_EVENT_TEAM_2_COORDINATES[1] = Integer.parseInt(team2Coordinates[1]);
		TVT_EVENT_TEAM_2_COORDINATES[2] = Integer.parseInt(team2Coordinates[2]);

		for (String door : eventDoors) {
			try {
				TVT_EVENT_DOOR_IDS.add(Integer.valueOf(door));
			} catch (NumberFormatException nfe) {
				if (door.isEmpty()) {
					System.out.println("TvTEventEngine[Config.load()]: invalid config property -> TvTEventDoorsCloseOpenOnStartEnd \"" + door + "\"");
				}
			}
		}

		for (String reward : eventRewards) {
			String[] rewardSplit = reward.split(",");

			if (rewardSplit.length != 2) {
				System.out.println("TvTEventEngine[Config.load()]: invalid config property -> TvTEventReward \"" + reward + "\"");
			} else {
				try {
					TVT_EVENT_REWARDS.add(new int[] {
						Integer.parseInt(rewardSplit[0]),
						Integer.parseInt(rewardSplit[1])
					});
				} catch (NumberFormatException nfe) {
					if (reward.isEmpty()) {
						System.out.println("TvTEventEngine[Config.load()]: invalid config property -> TvTEventReward \"" + reward + "\"");
					}
				}
			}
		}
	}
}
