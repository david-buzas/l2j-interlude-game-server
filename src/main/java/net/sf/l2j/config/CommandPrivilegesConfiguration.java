package net.sf.l2j.config;

import org.aeonbits.owner.Config;

import static java.util.concurrent.TimeUnit.MINUTES;
import static org.aeonbits.owner.Config.HotReloadType.ASYNC;
import static org.aeonbits.owner.Config.LoadType.MERGE;

/**
 * Alternative Configure GM commands access level
 *
 * This file only read if "AltPrivilegesAdmin = True"!!!
 *
 * Information:
 * 1) If AltPrivilegesSecureCheck = True
 * Every commands need an entry in this file, else the command cannot be executed.
 * else if a command haven't got an entry in this file the minimun access level is
 * AltPrivilegesDefaultLevel (default = 100)
 * 2) Some commands need a correct access level on GM Access table too, like:
 * the commands contained into AdminEditChar.java,AdminEditNpc.java,AdminSpawn.java files
 */
@Config.Sources({
        "system:env",
        "file:${L2J_HOME}/custom/game/config/command-privileges.properties",
        "file:./config/command-privileges.properties",
        "classpath:config/command-privileges.properties"
})
@Config.LoadPolicy(MERGE)
@Config.HotReload(value = 20, unit = MINUTES, type = ASYNC)
public interface CommandPrivilegesConfiguration extends Config {
    /** Access level required for command "admin_admin". Default: 100. */
    @Key("admin_admin")
    @DefaultValue("100")
    int getAdminAdmin();

    /** Access level required for command "admin_admin1". Default: 100. */
    @Key("admin_admin1")
    @DefaultValue("100")
    int getAdminAdmin1();

    /** Access level required for command "admin_admin2". Default: 100. */
    @Key("admin_admin2")
    @DefaultValue("100")
    int getAdminAdmin2();

    /** Access level required for command "admin_admin3". Default: 100. */
    @Key("admin_admin3")
    @DefaultValue("100")
    int getAdminAdmin3();

    /** Access level required for command "admin_admin4". Default: 100. */
    @Key("admin_admin4")
    @DefaultValue("100")
    int getAdminAdmin4();

    /** Access level required for command "admin_admin5". Default: 100. */
    @Key("admin_admin5")
    @DefaultValue("100")
    int getAdminAdmin5();


    /*
     * COMMON COMMANDS
     */
    /** Access level required for command "admin_delete". Default: 100. */
    @Key("admin_delete")
    @DefaultValue("100")
    int getAdminDelete();

    /** Access level required for command "admin_gmshop". Default: 100. */
    @Key("admin_gmshop")
    @DefaultValue("100")
    int getAdminGmshop();

    /** Access level required for command "admin_heal". Default: 75. */
    @Key("admin_heal")
    @DefaultValue("75")
    int getAdminHeal();

    /** Access level required for command "admin_help". Default: 75. */
    @Key("admin_help")
    @DefaultValue("75")
    int getAdminHelp();

    /** Access level required for command "admin_vis". Default: 75. */
    @Key("admin_vis")
    @DefaultValue("75")
    int getAdminVis();

    /** Access level required for command "admin_invis". Default: 75. */
    @Key("admin_invis")
    @DefaultValue("75")
    int getAdminInvis();

    /** Access level required for command "admin_invis_menu". Default: 75. */
    @Key("admin_invis_menu")
    @DefaultValue("75")
    int getAdminInvisMenu();

    /** Access level required for command "admin_invul". Default: 75. */
    @Key("admin_invul")
    @DefaultValue("75")
    int getAdminInvul();

    /** Access level required for command "admin_kill". Default: 75. */
    @Key("admin_kill")
    @DefaultValue("75")
    int getAdminKill();

    /** Access level required for command "admin_res". Default: 75. */
    @Key("admin_res")
    @DefaultValue("75")
    int getAdminRes();

    /** Access level required for command "admin_silence". Default: 75. */
    @Key("admin_silence")
    @DefaultValue("75")
    int getAdminSilence();

    /** Access level required for command "admin_target". Default: 75. */
    @Key("admin_target")
    @DefaultValue("75")
    int getAdminTarget();


    /*
     * CHAR MANAGEMENT
     */
    /** Access level required for command "admin_ban". Default: 100. */
    @Key("admin_ban")
    @DefaultValue("100")
    int getAdminBan();

    /** Access level required for command "admin_banchat". Default: 75. */
    @Key("admin_banchat")
    @DefaultValue("75")
    int getAdminBanchat();

    /** Access level required for command "admin_jail". Default: 100. */
    @Key("admin_jail")
    @DefaultValue("100")
    int getAdminJail();

    /** Access level required for command "admin_character_disconnect". Default: 75. */
    @Key("admin_character_disconnect")
    @DefaultValue("75")
    int getAdminCharacterDisconnect();

    /** Access level required for command "admin_kick". Default: 75. */
    @Key("admin_kick")
    @DefaultValue("75")
    int getAdminKick();

    /** Access level required for command "admin_unban". Default: 100. */
    @Key("admin_unban")
    @DefaultValue("100")
    int getAdminUnban();

    /** Access level required for command "admin_unbanchat". Default: 75. */
    @Key("admin_unbanchat")
    @DefaultValue("75")
    int getAdminUnbanchat();

    /** Access level required for command "admin_unjail". Default: 100. */
    @Key("admin_unjail")
    @DefaultValue("100")
    int getAdminUnjail();


    /*
     * CLAN HALL
     */
    /** Access level required for command "admin_clanhall". Default: 100. */
    @Key("admin_clanhall")
    @DefaultValue("100")
    int getAdminClanhall();

    /** Access level required for command "admin_clanhalldel". Default: 100. */
    @Key("admin_clanhalldel")
    @DefaultValue("100")
    int getAdminClanhalldel();

    /** Access level required for command "admin_clanhallset". Default: 100. */
    @Key("admin_clanhallset")
    @DefaultValue("100")
    int getAdminClanhallset();

    /** Access level required for command "admin_clanhallopendoors". Default: 100. */
    @Key("admin_clanhallopendoors")
    @DefaultValue("100")
    int getAdminClanhallopendoors();

    /** Access level required for command "admin_clanhallteleportself". Default: 100. */
    @Key("admin_clanhallteleportself")
    @DefaultValue("100")
    int getAdminClanhallteleportself();


    /*
     * ANNOUNCEMENT
     */
    /** Access level required for command "admin_add_announcement". Default: 100. */
    @Key("admin_add_announcement")
    @DefaultValue("100")
    int getAdminAddAnnouncement();

    /** Access level required for command "admin_announce". Default: 75. */
    @Key("admin_announce")
    @DefaultValue("75")
    int getAdminAnnounce();

    /** Access level required for command "admin_announce_announcements". Default: 75. */
    @Key("admin_announce_announcements")
    @DefaultValue("75")
    int getAdminAnnounceAnnouncements();

    /** Access level required for command "admin_announce_menu". Default: 75. */
    @Key("admin_announce_menu")
    @DefaultValue("75")
    int getAdminAnnounceMenu();

    /** Access level required for command "admin_del_announcement". Default: 100. */
    @Key("admin_del_announcement")
    @DefaultValue("100")
    int getAdminDelAnnouncement();

    /** Access level required for command "admin_list_announcements". Default: 75. */
    @Key("admin_list_announcements")
    @DefaultValue("75")
    int getAdminListAnnouncements();

    /** Access level required for command "admin_reload_announcements". Default: 100. */
    @Key("admin_reload_announcements")
    @DefaultValue("100")
    int getAdminReloadAnnouncements();


    /*
     * RELOAD COMMANDS
     */
    /** Access level required for command "admin_cache_htm_rebuild". Default: 100. */
    @Key("admin_cache_htm_rebuild")
    @DefaultValue("100")
    int getAdminCacheHtmRebuild();

    /** Access level required for command "admin_cache_htm_reload". Default: 100. */
    @Key("admin_cache_htm_reload")
    @DefaultValue("100")
    int getAdminCacheHtmReload();

    /** Access level required for command "admin_cache_crest_fix". Default: 100. */
    @Key("admin_cache_crest_fix")
    @DefaultValue("100")
    int getAdminCacheCrestFix();

    /** Access level required for command "admin_cache_crest_rebuild". Default: 100. */
    @Key("admin_cache_crest_rebuild")
    @DefaultValue("100")
    int getAdminCacheCrestRebuild();

    /** Access level required for command "admin_cache_crest_reload". Default: 100. */
    @Key("admin_cache_crest_reload")
    @DefaultValue("100")
    int getAdminCacheCrestReload();

    /** Access level required for command "admin_quest_reload". Default: 100. */
    @Key("admin_quest_reload")
    @DefaultValue("100")
    int getAdminQuestReload();

    /** Access level required for command "admin_teleport_reload". Default: 100. */
    @Key("admin_teleport_reload")
    @DefaultValue("100")
    int getAdminTeleportReload();

    /** Access level required for command "admin_spawn_reload". Default: 100. */
    @Key("admin_spawn_reload")
    @DefaultValue("100")
    int getAdminSpawnReload();

    /** Access level required for command "admin_zone_reload". Default: 100. */
    @Key("admin_zone_reload")
    @DefaultValue("100")
    int getAdminZoneReload();


    /*
     * DOOR CONTROL
     */
    /** Access level required for command "admin_close". Default: 75. */
    @Key("admin_close")
    @DefaultValue("75")
    int getAdminClose();

    /** Access level required for command "admin_closeall". Default: 100. */
    @Key("admin_closeall")
    @DefaultValue("100")
    int getAdminCloseall();

    /** Access level required for command "admin_open". Default: 75. */
    @Key("admin_open")
    @DefaultValue("75")
    int getAdminOpen();

    /** Access level required for command "admin_openall". Default: 100. */
    @Key("admin_openall")
    @DefaultValue("100")
    int getAdminOpenall();


    /*
     * CHAR MODIFICATION
     */
    /** Access level required for command "admin_setclass". Default: 100. */
    @Key("admin_setclass")
    @DefaultValue("100")
    int getAdminSetclass();

    /** Access level required for command "admin_add_exp_sp". Default: 100. */
    @Key("admin_add_exp_sp")
    @DefaultValue("100")
    int getAdminAddExpSp();

    /** Access level required for command "admin_add_exp_sp_to_character". Default: 100. */
    @Key("admin_add_exp_sp_to_character")
    @DefaultValue("100")
    int getAdminAddExpSpToCharacter();

    /** Access level required for command "admin_add_level". Default: 100. */
    @Key("admin_add_level")
    @DefaultValue("100")
    int getAdminAddLevel();

    /** Access level required for command "admin_set_level". Default: 100. */
    @Key("admin_set_level")
    @DefaultValue("100")
    int getAdminSetLevel();

    /** Access level required for command "admin_changename". Default: 100. */
    @Key("admin_changename")
    @DefaultValue("100")
    int getAdminChangename();

    /** Access level required for command "admin_changename_menu". Default: 100. */
    @Key("admin_changename_menu")
    @DefaultValue("100")
    int getAdminChangenameMenu();

    /** Access level required for command "admin_character_list". Default: 75. */
    @Key("admin_character_list")
    @DefaultValue("75")
    int getAdminCharacterList();

    /** Access level required for command "admin_character_info". Default: 75. */
    @Key("admin_character_info")
    @DefaultValue("75")
    int getAdminCharacterInfo();

    /** Access level required for command "admin_current_player". Default: 75. */
    @Key("admin_current_player")
    @DefaultValue("75")
    int getAdminCurrentPlayer();

    /** Access level required for command "admin_edit_character". Default: 100. */
    @Key("admin_edit_character")
    @DefaultValue("100")
    int getAdminEditCharacter();

    /** Access level required for command "admin_find_character". Default: 75. */
    @Key("admin_find_character")
    @DefaultValue("75")
    int getAdminFindCharacter();

    /** Access level required for command "admin_find_ip". Default: 75. */
    @Key("admin_find_ip")
    @DefaultValue("75")
    int getAdminFindIp();

    /** Access level required for command "admin_find_account". Default: 75. */
    @Key("admin_find_account")
    @DefaultValue("75")
    int getAdminFindAccount();

    /** Access level required for command "admin_nokarma". Default: 100. */
    @Key("admin_nokarma")
    @DefaultValue("100")
    int getAdminNokarma();

    /** Access level required for command "admin_rec". Default: 75. */
    @Key("admin_rec")
    @DefaultValue("75")
    int getAdminRec();

    /** Access level required for command "admin_repair". Default: 75. */
    @Key("admin_repair")
    @DefaultValue("75")
    int getAdminRepair();

    /** Access level required for command "admin_restore". Default: 75. */
    @Key("admin_restore")
    @DefaultValue("75")
    int getAdminRestore();

    /** Access level required for command "admin_setew". Default: 100. */
    @Key("admin_setew")
    @DefaultValue("100")
    int getAdminSetew();

    /** Access level required for command "admin_setkarma". Default: 100. */
    @Key("admin_setkarma")
    @DefaultValue("100")
    int getAdminSetkarma();

    /** Access level required for command "admin_save_modifications". Default: 100. */
    @Key("admin_save_modifications")
    @DefaultValue("100")
    int getAdminSaveModifications();

    /** Access level required for command "admin_setcolor". Default: 75. */
    @Key("admin_setcolor")
    @DefaultValue("75")
    int getAdminSetcolor();

    /** Access level required for command "admin_setname". Default: 100. */
    @Key("admin_setname")
    @DefaultValue("100")
    int getAdminSetname();

    /** Access level required for command "admin_setsex". Default: 100. */
    @Key("admin_setsex")
    @DefaultValue("100")
    int getAdminSetsex();

    /** Access level required for command "admin_settitle". Default: 75. */
    @Key("admin_settitle")
    @DefaultValue("75")
    int getAdminSettitle();

    /** Access level required for command "admin_show_characters". Default: 75. */
    @Key("admin_show_characters")
    @DefaultValue("75")
    int getAdminShowCharacters();


    /*
     * EDIT NPC
     */
    /** Access level required for command "admin_edit_npc". Default: 100. */
    @Key("admin_edit_npc")
    @DefaultValue("100")
    int getAdminEditNpc();

    /** Access level required for command "admin_save_npc". Default: 100. */
    @Key("admin_save_npc")
    @DefaultValue("100")
    int getAdminSaveNpc();

    /** Access level required for command "admin_show_droplist". Default: 100. */
    @Key("admin_show_droplist")
    @DefaultValue("100")
    int getAdminShowDroplist();

    /** Access level required for command "admin_edit_drop". Default: 100. */
    @Key("admin_edit_drop")
    @DefaultValue("100")
    int getAdminEditDrop();

    /** Access level required for command "admin_add_drop". Default: 100. */
    @Key("admin_add_drop")
    @DefaultValue("100")
    int getAdminAddDrop();

    /** Access level required for command "admin_del_drop". Default: 100. */
    @Key("admin_del_drop")
    @DefaultValue("100")
    int getAdminDelDrop();

    /** Access level required for command "admin_showShop". Default: 100. */
    @Key("admin_showShop")
    @DefaultValue("100")
    int getAdminShowshop();

    /** Access level required for command "admin_showShopList". Default: 100. */
    @Key("admin_showShopList")
    @DefaultValue("100")
    int getAdminShowshoplist();

    /** Access level required for command "admin_addShopItem". Default: 100. */
    @Key("admin_addShopItem")
    @DefaultValue("100")
    int getAdminAddshopitem();

    /** Access level required for command "admin_delShopItem". Default: 100. */
    @Key("admin_delShopItem")
    @DefaultValue("100")
    int getAdminDelshopitem();

    /** Access level required for command "admin_box_access". Default: 100. */
    @Key("admin_box_access")
    @DefaultValue("100")
    int getAdminBoxAccess();

    /** Access level required for command "admin_editShopItem". Default: 100. */
    @Key("admin_editShopItem")
    @DefaultValue("100")
    int getAdminEditshopitem();


    /*
     * EFFECTS
     */
    /** Access level required for command "admin_atmosphere". Default: 75. */
    @Key("admin_atmosphere")
    @DefaultValue("75")
    int getAdminAtmosphere();

    /** Access level required for command "admin_invisible". Default: 75. */
    @Key("admin_invisible")
    @DefaultValue("75")
    int getAdminInvisible();

    /** Access level required for command "admin_visible". Default: 75. */
    @Key("admin_visible")
    @DefaultValue("75")
    int getAdminVisible();

    /** Access level required for command "admin_earthquake". Default: 75. */
    @Key("admin_earthquake")
    @DefaultValue("75")
    int getAdminEarthquake();

    /** Access level required for command "admin_bighead". Default: 100. */
    @Key("admin_bighead")
    @DefaultValue("100")
    int getAdminBighead();

    /** Access level required for command "admin_shrinkhead". Default: 100. */
    @Key("admin_shrinkhead")
    @DefaultValue("100")
    int getAdminShrinkhead();

    /** Access level required for command "admin_gmspeed". Default: 75. */
    @Key("admin_gmspeed")
    @DefaultValue("75")
    int getAdminGmspeed();

    /** Access level required for command "admin_unpara_all". Default: 100. */
    @Key("admin_unpara_all")
    @DefaultValue("100")
    int getAdminUnparaAll();

    /** Access level required for command "admin_para_all". Default: 100. */
    @Key("admin_para_all")
    @DefaultValue("100")
    int getAdminParaAll();

    /** Access level required for command "admin_unpara". Default: 100. */
    @Key("admin_unpara")
    @DefaultValue("100")
    int getAdminUnpara();

    /** Access level required for command "admin_para". Default: 100. */
    @Key("admin_para")
    @DefaultValue("100")
    int getAdminPara();

    /** Access level required for command "admin_polymorph". Default: 75. */
    @Key("admin_polymorph")
    @DefaultValue("75")
    int getAdminPolymorph();

    /** Access level required for command "admin_unpolymorph". Default: 75. */
    @Key("admin_unpolymorph")
    @DefaultValue("75")
    int getAdminUnpolymorph();

    /** Access level required for command "admin_polyself". Default: 75. */
    @Key("admin_polyself")
    @DefaultValue("75")
    int getAdminPolyself();

    /** Access level required for command "admin_unpolyself". Default: 75. */
    @Key("admin_unpolyself")
    @DefaultValue("75")
    int getAdminUnpolyself();

    /** Access level required for command "admin_clearteams". Default: 100. */
    @Key("admin_clearteams")
    @DefaultValue("100")
    int getAdminClearteams();

    /** Access level required for command "admin_setteam_close". Default: 100. */
    @Key("admin_setteam_close")
    @DefaultValue("100")
    int getAdminSetteamClose();

    /** Access level required for command "admin_setteam". Default: 100. */
    @Key("admin_setteam")
    @DefaultValue("100")
    int getAdminSetteam();

    /** Access level required for command "admin_effect". Default: 100. */
    @Key("admin_effect")
    @DefaultValue("100")
    int getAdminEffect();

    /** Access level required for command "admin_social". Default: 100. */
    @Key("admin_social")
    @DefaultValue("100")
    int getAdminSocial();

    /** Access level required for command "admin_play_sounds". Default: 75. */
    @Key("admin_play_sounds")
    @DefaultValue("75")
    int getAdminPlaySounds();

    /** Access level required for command "admin_play_sound". Default: 75. */
    @Key("admin_play_sound")
    @DefaultValue("75")
    int getAdminPlaySound();

    /** Access level required for command "admin_abnormal". Default: 100. */
    @Key("admin_abnormal")
    @DefaultValue("100")
    int getAdminAbnormal();

    /** Access level required for command "admin_atmosphere_menu". Default: 75. */
    @Key("admin_atmosphere_menu")
    @DefaultValue("75")
    int getAdminAtmosphereMenu();

    /** Access level required for command "admin_unpara_all_menu". Default: 100. */
    @Key("admin_unpara_all_menu")
    @DefaultValue("100")
    int getAdminUnparaAllMenu();

    /** Access level required for command "admin_para_all_menu". Default: 100. */
    @Key("admin_para_all_menu")
    @DefaultValue("100")
    int getAdminParaAllMenu();

    /** Access level required for command "admin_unpara_menu". Default: 100. */
    @Key("admin_unpara_menu")
    @DefaultValue("100")
    int getAdminUnparaMenu();

    /** Access level required for command "admin_para_menu". Default: 100. */
    @Key("admin_para_menu")
    @DefaultValue("100")
    int getAdminParaMenu();

    /** Access level required for command "admin_polymorph_menu". Default: 75. */
    @Key("admin_polymorph_menu")
    @DefaultValue("75")
    int getAdminPolymorphMenu();

    /** Access level required for command "admin_unpolymorph_menu". Default: 75. */
    @Key("admin_unpolymorph_menu")
    @DefaultValue("75")
    int getAdminUnpolymorphMenu();

    /** Access level required for command "admin_polyself_menu". Default: 75. */
    @Key("admin_polyself_menu")
    @DefaultValue("75")
    int getAdminPolyselfMenu();

    /** Access level required for command "admin_unpolyself_menu". Default: 75. */
    @Key("admin_unpolyself_menu")
    @DefaultValue("75")
    int getAdminUnpolyselfMenu();

    /** Access level required for command "admin_social_menu". Default: 100. */
    @Key("admin_social_menu")
    @DefaultValue("100")
    int getAdminSocialMenu();

    /** Access level required for command "admin_effect_menu". Default: 100. */
    @Key("admin_effect_menu")
    @DefaultValue("100")
    int getAdminEffectMenu();

    /** Access level required for command "admin_abnormal_menu". Default: 100. */
    @Key("admin_abnormal_menu")
    @DefaultValue("100")
    int getAdminAbnormalMenu();


    /*
     * ENCHANT MENU
     */
    /** Access level required for command "admin_seteh". Default: 100. */
    @Key("admin_seteh")
    @DefaultValue("100")
    int getAdminSeteh();

    /** Access level required for command "admin_setec". Default: 100. */
    @Key("admin_setec")
    @DefaultValue("100")
    int getAdminSetec();

    /** Access level required for command "admin_seteg". Default: 100. */
    @Key("admin_seteg")
    @DefaultValue("100")
    int getAdminSeteg();

    /** Access level required for command "admin_setel". Default: 100. */
    @Key("admin_setel")
    @DefaultValue("100")
    int getAdminSetel();

    /** Access level required for command "admin_seteb". Default: 100. */
    @Key("admin_seteb")
    @DefaultValue("100")
    int getAdminSeteb();

    /** Access level required for command "admin_setes". Default: 100. */
    @Key("admin_setes")
    @DefaultValue("100")
    int getAdminSetes();

    /** Access level required for command "admin_setle". Default: 100. */
    @Key("admin_setle")
    @DefaultValue("100")
    int getAdminSetle();

    /** Access level required for command "admin_setre". Default: 100. */
    @Key("admin_setre")
    @DefaultValue("100")
    int getAdminSetre();

    /** Access level required for command "admin_setlf". Default: 100. */
    @Key("admin_setlf")
    @DefaultValue("100")
    int getAdminSetlf();

    /** Access level required for command "admin_setrf". Default: 100. */
    @Key("admin_setrf")
    @DefaultValue("100")
    int getAdminSetrf();

    /** Access level required for command "admin_seten". Default: 100. */
    @Key("admin_seten")
    @DefaultValue("100")
    int getAdminSeten();

    /** Access level required for command "admin_setun". Default: 100. */
    @Key("admin_setun")
    @DefaultValue("100")
    int getAdminSetun();

    /** Access level required for command "admin_setba". Default: 100. */
    @Key("admin_setba")
    @DefaultValue("100")
    int getAdminSetba();

    /** Access level required for command "admin_enchant". Default: 100. */
    @Key("admin_enchant")
    @DefaultValue("100")
    int getAdminEnchant();


    /*
     * EVENT
     */
    /** Access level required for command "admin_event". Default: 100. */
    @Key("admin_event")
    @DefaultValue("100")
    int getAdminEvent();

    /** Access level required for command "admin_event_new". Default: 100. */
    @Key("admin_event_new")
    @DefaultValue("100")
    int getAdminEventNew();

    /** Access level required for command "admin_event_choose". Default: 100. */
    @Key("admin_event_choose")
    @DefaultValue("100")
    int getAdminEventChoose();

    /** Access level required for command "admin_event_store". Default: 100. */
    @Key("admin_event_store")
    @DefaultValue("100")
    int getAdminEventStore();

    /** Access level required for command "admin_event_set". Default: 100. */
    @Key("admin_event_set")
    @DefaultValue("100")
    int getAdminEventSet();

    /** Access level required for command "admin_event_change_teams_number". Default: 100. */
    @Key("admin_event_change_teams_number")
    @DefaultValue("100")
    int getAdminEventChangeTeamsNumber();

    /** Access level required for command "admin_event_announce". Default: 100. */
    @Key("admin_event_announce")
    @DefaultValue("100")
    int getAdminEventAnnounce();

    /** Access level required for command "admin_event_panel". Default: 100. */
    @Key("admin_event_panel")
    @DefaultValue("100")
    int getAdminEventPanel();

    /** Access level required for command "admin_event_control_begin". Default: 100. */
    @Key("admin_event_control_begin")
    @DefaultValue("100")
    int getAdminEventControlBegin();

    /** Access level required for command "admin_event_control_teleport". Default: 100. */
    @Key("admin_event_control_teleport")
    @DefaultValue("100")
    int getAdminEventControlTeleport();

    /** Access level required for command "admin_add". Default: 100. */
    @Key("admin_add")
    @DefaultValue("100")
    int getAdminAdd();

    /** Access level required for command "admin_event_see". Default: 100. */
    @Key("admin_event_see")
    @DefaultValue("100")
    int getAdminEventSee();

    /** Access level required for command "admin_event_del". Default: 100. */
    @Key("admin_event_del")
    @DefaultValue("100")
    int getAdminEventDel();

    /** Access level required for command "admin_delete_buffer". Default: 100. */
    @Key("admin_delete_buffer")
    @DefaultValue("100")
    int getAdminDeleteBuffer();

    /** Access level required for command "admin_event_control_sit". Default: 100. */
    @Key("admin_event_control_sit")
    @DefaultValue("100")
    int getAdminEventControlSit();

    /** Access level required for command "admin_event_name". Default: 100. */
    @Key("admin_event_name")
    @DefaultValue("100")
    int getAdminEventName();

    /** Access level required for command "admin_event_control_kill". Default: 100. */
    @Key("admin_event_control_kill")
    @DefaultValue("100")
    int getAdminEventControlKill();

    /** Access level required for command "admin_event_control_res". Default: 100. */
    @Key("admin_event_control_res")
    @DefaultValue("100")
    int getAdminEventControlRes();

    /** Access level required for command "admin_event_control_poly". Default: 100. */
    @Key("admin_event_control_poly")
    @DefaultValue("100")
    int getAdminEventControlPoly();

    /** Access level required for command "admin_event_control_unpoly". Default: 100. */
    @Key("admin_event_control_unpoly")
    @DefaultValue("100")
    int getAdminEventControlUnpoly();

    /** Access level required for command "admin_event_control_prize". Default: 100. */
    @Key("admin_event_control_prize")
    @DefaultValue("100")
    int getAdminEventControlPrize();

    /** Access level required for command "admin_event_control_chatban". Default: 100. */
    @Key("admin_event_control_chatban")
    @DefaultValue("100")
    int getAdminEventControlChatban();

    /** Access level required for command "admin_event_control_finish". Default: 100. */
    @Key("admin_event_control_finish")
    @DefaultValue("100")
    int getAdminEventControlFinish();


    /*
     * SERVER SETTINGS
     */
    /** Access level required for command "admin_server_shutdown". Default: 100. */
    @Key("admin_server_shutdown")
    @DefaultValue("100")
    int getAdminServerShutdown();

    /** Access level required for command "admin_server_restart". Default: 75. */
    @Key("admin_server_restart")
    @DefaultValue("75")
    int getAdminServerRestart();

    /** Access level required for command "admin_server_abort". Default: 75. */
    @Key("admin_server_abort")
    @DefaultValue("75")
    int getAdminServerAbort();

    /** Access level required for command "admin_server_gm_only". Default: 100. */
    @Key("admin_server_gm_only")
    @DefaultValue("100")
    int getAdminServerGmOnly();

    /** Access level required for command "admin_server_all". Default: 100. */
    @Key("admin_server_all")
    @DefaultValue("100")
    int getAdminServerAll();

    /** Access level required for command "admin_server_max_player". Default: 100. */
    @Key("admin_server_max_player")
    @DefaultValue("100")
    int getAdminServerMaxPlayer();

    /** Access level required for command "admin_server_list_clock". Default: 100. */
    @Key("admin_server_list_clock")
    @DefaultValue("100")
    int getAdminServerListClock();

    /** Access level required for command "admin_server_login". Default: 100. */
    @Key("admin_server_login")
    @DefaultValue("100")
    int getAdminServerLogin();


    /*
     * MENU
     */
    /** Access level required for command "admin_char_manage". Default: 75. */
    @Key("admin_char_manage")
    @DefaultValue("75")
    int getAdminCharManage();

    /** Access level required for command "admin_teleport_character_to_menu". Default: 75. */
    @Key("admin_teleport_character_to_menu")
    @DefaultValue("75")
    int getAdminTeleportCharacterToMenu();

    /** Access level required for command "admin_recall_char_menu". Default: 75. */
    @Key("admin_recall_char_menu")
    @DefaultValue("75")
    int getAdminRecallCharMenu();

    /** Access level required for command "admin_recall_party_menu". Default: 75. */
    @Key("admin_recall_party_menu")
    @DefaultValue("75")
    int getAdminRecallPartyMenu();

    /** Access level required for command "admin_recall_clan_menu". Default: 75. */
    @Key("admin_recall_clan_menu")
    @DefaultValue("75")
    int getAdminRecallClanMenu();

    /** Access level required for command "admin_goto_char_menu". Default: 75. */
    @Key("admin_goto_char_menu")
    @DefaultValue("75")
    int getAdminGotoCharMenu();

    /** Access level required for command "admin_kick_menu". Default: 75. */
    @Key("admin_kick_menu")
    @DefaultValue("75")
    int getAdminKickMenu();

    /** Access level required for command "admin_kill_menu". Default: 100. */
    @Key("admin_kill_menu")
    @DefaultValue("100")
    int getAdminKillMenu();

    /** Access level required for command "admin_ban_menu". Default: 100. */
    @Key("admin_ban_menu")
    @DefaultValue("100")
    int getAdminBanMenu();

    /** Access level required for command "admin_unban_menu". Default: 100. */
    @Key("admin_unban_menu")
    @DefaultValue("100")
    int getAdminUnbanMenu();


    /*
     * MOB GROUP
     */
    /** Access level required for command "admin_mobmenu". Default: 100. */
    @Key("admin_mobmenu")
    @DefaultValue("100")
    int getAdminMobmenu();

    /** Access level required for command "admin_mobgroup_create". Default: 100. */
    @Key("admin_mobgroup_create")
    @DefaultValue("100")
    int getAdminMobgroupCreate();

    /** Access level required for command "admin_mobgroup_spawn". Default: 100. */
    @Key("admin_mobgroup_spawn")
    @DefaultValue("100")
    int getAdminMobgroupSpawn();

    /** Access level required for command "admin_mobgroup_unspawn". Default: 100. */
    @Key("admin_mobgroup_unspawn")
    @DefaultValue("100")
    int getAdminMobgroupUnspawn();

    /** Access level required for command "admin_mobgroup_kill". Default: 100. */
    @Key("admin_mobgroup_kill")
    @DefaultValue("100")
    int getAdminMobgroupKill();

    /** Access level required for command "admin_mobgroup_idle". Default: 100. */
    @Key("admin_mobgroup_idle")
    @DefaultValue("100")
    int getAdminMobgroupIdle();

    /** Access level required for command "admin_mobgroup_attack". Default: 100. */
    @Key("admin_mobgroup_attack")
    @DefaultValue("100")
    int getAdminMobgroupAttack();

    /** Access level required for command "admin_mobgroup_rnd". Default: 100. */
    @Key("admin_mobgroup_rnd")
    @DefaultValue("100")
    int getAdminMobgroupRnd();

    /** Access level required for command "admin_mobgroup_return". Default: 100. */
    @Key("admin_mobgroup_return")
    @DefaultValue("100")
    int getAdminMobgroupReturn();

    /** Access level required for command "admin_mobgroup_follow". Default: 100. */
    @Key("admin_mobgroup_follow")
    @DefaultValue("100")
    int getAdminMobgroupFollow();

    /** Access level required for command "admin_mobgroup_casting". Default: 100. */
    @Key("admin_mobgroup_casting")
    @DefaultValue("100")
    int getAdminMobgroupCasting();

    /** Access level required for command "admin_mobgroup_nomove". Default: 100. */
    @Key("admin_mobgroup_nomove")
    @DefaultValue("100")
    int getAdminMobgroupNomove();

    /** Access level required for command "admin_mobgroup_attackgrp". Default: 100. */
    @Key("admin_mobgroup_attackgrp")
    @DefaultValue("100")
    int getAdminMobgroupAttackgrp();

    /** Access level required for command "admin_mobgroup_invul". Default: 100. */
    @Key("admin_mobgroup_invul")
    @DefaultValue("100")
    int getAdminMobgroupInvul();

    /** Access level required for command "admin_mobinst". Default: 100. */
    @Key("admin_mobinst")
    @DefaultValue("100")
    int getAdminMobinst();

    /** Access level required for command "admin_mobgroup_remove". Default: 100. */
    @Key("admin_mobgroup_remove")
    @DefaultValue("100")
    int getAdminMobgroupRemove();


    /*
     * PATH NODE
     */
    /** Access level required for command "admin_pn_info". Default: 100. */
    @Key("admin_pn_info")
    @DefaultValue("100")
    int getAdminPnInfo();

    /** Access level required for command "admin_show_path". Default: 100. */
    @Key("admin_show_path")
    @DefaultValue("100")
    int getAdminShowPath();

    /** Access level required for command "admin_path_debug". Default: 100. */
    @Key("admin_path_debug")
    @DefaultValue("100")
    int getAdminPathDebug();

    /** Access level required for command "admin_show_pn". Default: 100. */
    @Key("admin_show_pn")
    @DefaultValue("100")
    int getAdminShowPn();

    /** Access level required for command "admin_find_path". Default: 100. */
    @Key("admin_find_path")
    @DefaultValue("100")
    int getAdminFindPath();


    /*
     * RIDE
     */
    /** Access level required for command "admin_ride_wyvern". Default: 75. */
    @Key("admin_ride_wyvern")
    @DefaultValue("75")
    int getAdminRideWyvern();

    /** Access level required for command "admin_ride_strider". Default: 75. */
    @Key("admin_ride_strider")
    @DefaultValue("75")
    int getAdminRideStrider();

    /** Access level required for command "admin_unride_wyvern". Default: 75. */
    @Key("admin_unride_wyvern")
    @DefaultValue("75")
    int getAdminUnrideWyvern();

    /** Access level required for command "admin_unride_strider". Default: 75. */
    @Key("admin_unride_strider")
    @DefaultValue("75")
    int getAdminUnrideStrider();

    /** Access level required for command "admin_unride". Default: 75. */
    @Key("admin_unride")
    @DefaultValue("75")
    int getAdminUnride();


    /*
     * SIEGE
     */
    /** Access level required for command "admin_siege". Default: 100. */
    @Key("admin_siege")
    @DefaultValue("100")
    int getAdminSiege();

    /** Access level required for command "admin_add_attacker". Default: 100. */
    @Key("admin_add_attacker")
    @DefaultValue("100")
    int getAdminAddAttacker();

    /** Access level required for command "admin_add_defender". Default: 100. */
    @Key("admin_add_defender")
    @DefaultValue("100")
    int getAdminAddDefender();

    /** Access level required for command "admin_add_guard". Default: 100. */
    @Key("admin_add_guard")
    @DefaultValue("100")
    int getAdminAddGuard();

    /** Access level required for command "admin_list_siege_clans". Default: 100. */
    @Key("admin_list_siege_clans")
    @DefaultValue("100")
    int getAdminListSiegeClans();

    /** Access level required for command "admin_clear_siege_list". Default: 100. */
    @Key("admin_clear_siege_list")
    @DefaultValue("100")
    int getAdminClearSiegeList();

    /** Access level required for command "admin_move_defenders". Default: 100. */
    @Key("admin_move_defenders")
    @DefaultValue("100")
    int getAdminMoveDefenders();

    /** Access level required for command "admin_spawn_doors". Default: 100. */
    @Key("admin_spawn_doors")
    @DefaultValue("100")
    int getAdminSpawnDoors();

    /** Access level required for command "admin_endsiege". Default: 100. */
    @Key("admin_endsiege")
    @DefaultValue("100")
    int getAdminEndsiege();

    /** Access level required for command "admin_startsiege". Default: 100. */
    @Key("admin_startsiege")
    @DefaultValue("100")
    int getAdminStartsiege();

    /** Access level required for command "admin_setcastle". Default: 100. */
    @Key("admin_setcastle")
    @DefaultValue("100")
    int getAdminSetcastle();


    /*
     * SKILL
     */
    /** Access level required for command "admin_show_skills". Default: 100. */
    @Key("admin_show_skills")
    @DefaultValue("100")
    int getAdminShowSkills();

    /** Access level required for command "admin_remove_skills". Default: 100. */
    @Key("admin_remove_skills")
    @DefaultValue("100")
    int getAdminRemoveSkills();

    /** Access level required for command "admin_skill_list". Default: 100. */
    @Key("admin_skill_list")
    @DefaultValue("100")
    int getAdminSkillList();

    /** Access level required for command "admin_skill_index". Default: 100. */
    @Key("admin_skill_index")
    @DefaultValue("100")
    int getAdminSkillIndex();

    /** Access level required for command "admin_add_skill". Default: 100. */
    @Key("admin_add_skill")
    @DefaultValue("100")
    int getAdminAddSkill();

    /** Access level required for command "admin_add_clan_skill". Default: 100. */
    @Key("admin_add_clan_skill")
    @DefaultValue("100")
    int getAdminAddClanSkill();

    /** Access level required for command "admin_remove_skill". Default: 100. */
    @Key("admin_remove_skill")
    @DefaultValue("100")
    int getAdminRemoveSkill();

    /** Access level required for command "admin_get_skills". Default: 100. */
    @Key("admin_get_skills")
    @DefaultValue("100")
    int getAdminGetSkills();

    /** Access level required for command "admin_reset_skills". Default: 100. */
    @Key("admin_reset_skills")
    @DefaultValue("100")
    int getAdminResetSkills();

    /** Access level required for command "admin_give_all_skills". Default: 100. */
    @Key("admin_give_all_skills")
    @DefaultValue("100")
    int getAdminGiveAllSkills();

    /** Access level required for command "admin_remove_all_skills". Default: 100. */
    @Key("admin_remove_all_skills")
    @DefaultValue("100")
    int getAdminRemoveAllSkills();


    /*
     * SPAWN
     */
    /** Access level required for command "admin_mammon_find". Default: 75. */
    @Key("admin_mammon_find")
    @DefaultValue("75")
    int getAdminMammonFind();

    /** Access level required for command "admin_mammon_respawn". Default: 75. */
    @Key("admin_mammon_respawn")
    @DefaultValue("75")
    int getAdminMammonRespawn();

    /** Access level required for command "admin_list_spawns". Default: 75. */
    @Key("admin_list_spawns")
    @DefaultValue("75")
    int getAdminListSpawns();

    /** Access level required for command "admin_show_spawns". Default: 75. */
    @Key("admin_show_spawns")
    @DefaultValue("75")
    int getAdminShowSpawns();

    /** Access level required for command "admin_spawn". Default: 100. */
    @Key("admin_spawn")
    @DefaultValue("100")
    int getAdminSpawn();

    /** Access level required for command "admin_spawn_once". Default: 100. */
    @Key("admin_spawn_once")
    @DefaultValue("100")
    int getAdminSpawnOnce();

    /** Access level required for command "admin_spawn_index". Default: 100. */
    @Key("admin_spawn_index")
    @DefaultValue("100")
    int getAdminSpawnIndex();

    /** Access level required for command "admin_spawn_monster". Default: 100. */
    @Key("admin_spawn_monster")
    @DefaultValue("100")
    int getAdminSpawnMonster();

    /** Access level required for command "admin_respawnall". Default: 100. */
    @Key("admin_respawnall")
    @DefaultValue("100")
    int getAdminRespawnall();

    /** Access level required for command "admin_unspawnall". Default: 100. */
    @Key("admin_unspawnall")
    @DefaultValue("100")
    int getAdminUnspawnall();


    /*
     * TELEPORT
     */
    /** Access level required for command "admin_show_moves". Default: 75. */
    @Key("admin_show_moves")
    @DefaultValue("75")
    int getAdminShowMoves();

    /** Access level required for command "admin_show_moves_other". Default: 75. */
    @Key("admin_show_moves_other")
    @DefaultValue("75")
    int getAdminShowMovesOther();

    /** Access level required for command "admin_show_teleport". Default: 75. */
    @Key("admin_show_teleport")
    @DefaultValue("75")
    int getAdminShowTeleport();

    /** Access level required for command "admin_teleport_to_character". Default: 75. */
    @Key("admin_teleport_to_character")
    @DefaultValue("75")
    int getAdminTeleportToCharacter();

    /** Access level required for command "admin_teleportto". Default: 75. */
    @Key("admin_teleportto")
    @DefaultValue("75")
    int getAdminTeleportto();

    /** Access level required for command "admin_move_to". Default: 75. */
    @Key("admin_move_to")
    @DefaultValue("75")
    int getAdminMoveTo();

    /** Access level required for command "admin_teleport_character". Default: 75. */
    @Key("admin_teleport_character")
    @DefaultValue("75")
    int getAdminTeleportCharacter();

    /** Access level required for command "admin_recall". Default: 75. */
    @Key("admin_recall")
    @DefaultValue("75")
    int getAdminRecall();

    /** Access level required for command "admin_walk". Default: 75. */
    @Key("admin_walk")
    @DefaultValue("75")
    int getAdminWalk();

    /** Access level required for command "admin_explore". Default: 75. */
    @Key("admin_explore")
    @DefaultValue("75")
    int getAdminExplore();

    /** Access level required for command "admin_recall_npc". Default: 100. */
    @Key("admin_recall_npc")
    @DefaultValue("100")
    int getAdminRecallNpc();

    /** Access level required for command "admin_gonorth". Default: 75. */
    @Key("admin_gonorth")
    @DefaultValue("75")
    int getAdminGonorth();

    /** Access level required for command "admin_gosouth". Default: 75. */
    @Key("admin_gosouth")
    @DefaultValue("75")
    int getAdminGosouth();

    /** Access level required for command "admin_goeast". Default: 75. */
    @Key("admin_goeast")
    @DefaultValue("75")
    int getAdminGoeast();

    /** Access level required for command "admin_gowest". Default: 75. */
    @Key("admin_gowest")
    @DefaultValue("75")
    int getAdminGowest();

    /** Access level required for command "admin_goup". Default: 75. */
    @Key("admin_goup")
    @DefaultValue("75")
    int getAdminGoup();

    /** Access level required for command "admin_godown". Default: 75. */
    @Key("admin_godown")
    @DefaultValue("75")
    int getAdminGodown();

    /** Access level required for command "admin_tele". Default: 75. */
    @Key("admin_tele")
    @DefaultValue("75")
    int getAdminTele();

    /** Access level required for command "admin_teleto". Default: 75. */
    @Key("admin_teleto")
    @DefaultValue("75")
    int getAdminTeleto();


    /*
     * TEST COMMANDS
     */
    /** Access level required for command "admin_known". Default: 100. */
    @Key("admin_known")
    @DefaultValue("100")
    int getAdminKnown();

    /** Access level required for command "admin_mp". Default: 100. */
    @Key("admin_mp")
    @DefaultValue("100")
    int getAdminMp();

    /** Access level required for command "admin_msg". Default: 100. */
    @Key("admin_msg")
    @DefaultValue("100")
    int getAdminMsg();

    /** Access level required for command "admin_forge". Default: 100. */
    @Key("admin_forge")
    @DefaultValue("100")
    int getAdminForge();

    /** Access level required for command "admin_forge2". Default: 100. */
    @Key("admin_forge2")
    @DefaultValue("100")
    int getAdminForge2();

    /** Access level required for command "admin_forge3". Default: 100. */
    @Key("admin_forge3")
    @DefaultValue("100")
    int getAdminForge3();

    /** Access level required for command "admin_skill_test". Default: 75. */
    @Key("admin_skill_test")
    @DefaultValue("75")
    int getAdminSkillTest();

    /** Access level required for command "admin_st". Default: 75. */
    @Key("admin_st")
    @DefaultValue("75")
    int getAdminSt();

    /** Access level required for command "admin_stats". Default: 100. */
    @Key("admin_stats")
    @DefaultValue("100")
    int getAdminStats();

    /** Access level required for command "admin_test". Default: 100. */
    @Key("admin_test")
    @DefaultValue("100")
    int getAdminTest();

    /** Access level required for command "admin_zone_check". Default: 100. */
    @Key("admin_zone_check")
    @DefaultValue("100")
    int getAdminZoneCheck();

    /** Access level required for command "admin_fight_calculator". Default: 100. */
    @Key("admin_fight_calculator")
    @DefaultValue("100")
    int getAdminFightCalculator();

    /** Access level required for command "admin_fight_calculator_show". Default: 100. */
    @Key("admin_fight_calculator_show")
    @DefaultValue("100")
    int getAdminFightCalculatorShow();

    /** Access level required for command "admin_fcs". Default: 100. */
    @Key("admin_fcs")
    @DefaultValue("100")
    int getAdminFcs();


    /*
     * PETITIONS
     */
    /** Access level required for command "admin_accept_petition". Default: 75. */
    @Key("admin_accept_petition")
    @DefaultValue("75")
    int getAdminAcceptPetition();

    /** Access level required for command "admin_reject_petition". Default: 75. */
    @Key("admin_reject_petition")
    @DefaultValue("75")
    int getAdminRejectPetition();

    /** Access level required for command "admin_reset_petitions". Default: 100. */
    @Key("admin_reset_petitions")
    @DefaultValue("100")
    int getAdminResetPetitions();

    /** Access level required for command "admin_view_petition". Default: 75. */
    @Key("admin_view_petition")
    @DefaultValue("75")
    int getAdminViewPetition();

    /** Access level required for command "admin_view_petitions". Default: 75. */
    @Key("admin_view_petitions")
    @DefaultValue("75")
    int getAdminViewPetitions();


    /*
     * GM SETTINGS
     */
    /** Access level required for command "admin_changelvl". Default: 100. */
    @Key("admin_changelvl")
    @DefaultValue("100")
    int getAdminChangelvl();

    /** Access level required for command "admin_gm". Default: 75. */
    @Key("admin_gm")
    @DefaultValue("75")
    int getAdminGm();

    /** Access level required for command "admin_gmchat". Default: 75. */
    @Key("admin_gmchat")
    @DefaultValue("75")
    int getAdminGmchat();

    /** Access level required for command "admin_gmchat_menu". Default: 75. */
    @Key("admin_gmchat_menu")
    @DefaultValue("75")
    int getAdminGmchatMenu();

    /** Access level required for command "admin_gmlistoff". Default: 75. */
    @Key("admin_gmlistoff")
    @DefaultValue("75")
    int getAdminGmlistoff();

    /** Access level required for command "admin_gmliston". Default: 75. */
    @Key("admin_gmliston")
    @DefaultValue("75")
    int getAdminGmliston();

    /** Access level required for command "admin_snoop". Default: 75. */
    @Key("admin_snoop")
    @DefaultValue("75")
    int getAdminSnoop();


    /*
     * MISCELLANEOUS
     */
    /** Access level required for command "admin_buy". Default: 100. */
    @Key("admin_buy")
    @DefaultValue("100")
    int getAdminBuy();

    /** Access level required for command "admin_create_item". Default: 100. */
    @Key("admin_create_item")
    @DefaultValue("100")
    int getAdminCreateItem();

    /** Access level required for command "admin_itemcreate". Default: 100. */
    @Key("admin_itemcreate")
    @DefaultValue("100")
    int getAdminItemcreate();

    /** Access level required for command "admin_pledge". Default: 100. */
    @Key("admin_pledge")
    @DefaultValue("100")
    int getAdminPledge();

    /** Access level required for command "admin_set". Default: 100. */
    @Key("admin_set")
    @DefaultValue("100")
    int getAdminSet();

    /** Access level required for command "admin_set_menu". Default: 100. */
    @Key("admin_set_menu")
    @DefaultValue("100")
    int getAdminSetMenu();

    /** Access level required for command "admin_set_mod". Default: 100. */
    @Key("admin_set_mod")
    @DefaultValue("100")
    int getAdminSetMod();

    /** Access level required for command "admin_tradeoff". Default: 75. */
    @Key("admin_tradeoff")
    @DefaultValue("75")
    int getAdminTradeoff();

    /** Access level required for command "admin_unblockip". Default: 100. */
    @Key("admin_unblockip")
    @DefaultValue("100")
    int getAdminUnblockip();


    /*
     * GEODATA
     */
    /** Access level required for command "admin_geo_z". Default: 100. */
    @Key("admin_geo_z")
    @DefaultValue("100")
    int getAdminGeoZ();

    /** Access level required for command "admin_geo_type". Default: 100. */
    @Key("admin_geo_type")
    @DefaultValue("100")
    int getAdminGeoType();

    /** Access level required for command "admin_geo_nswe". Default: 100. */
    @Key("admin_geo_nswe")
    @DefaultValue("100")
    int getAdminGeoNswe();

    /** Access level required for command "admin_geo_los". Default: 100. */
    @Key("admin_geo_los")
    @DefaultValue("100")
    int getAdminGeoLos();

    /** Access level required for command "admin_geo_position". Default: 100. */
    @Key("admin_geo_position")
    @DefaultValue("100")
    int getAdminGeoPosition();

    /** Access level required for command "admin_geo_bug". Default: 100. */
    @Key("admin_geo_bug")
    @DefaultValue("100")
    int getAdminGeoBug();

    /** Access level required for command "admin_geo_load". Default: 100. */
    @Key("admin_geo_load")
    @DefaultValue("100")
    int getAdminGeoLoad();

    /** Access level required for command "admin_geo_unload". Default: 100. */
    @Key("admin_geo_unload")
    @DefaultValue("100")
    int getAdminGeoUnload();

    /** Access level required for command "admin_geoeditor_connect". Default: 100. */
    @Key("admin_geoeditor_connect")
    @DefaultValue("100")
    int getAdminGeoeditorConnect();

    /** Access level required for command "admin_geoeditor_join". Default: 100. */
    @Key("admin_geoeditor_join")
    @DefaultValue("100")
    int getAdminGeoeditorJoin();

    /** Access level required for command "admin_geoeditor_leave". Default: 100. */
    @Key("admin_geoeditor_leave")
    @DefaultValue("100")
    int getAdminGeoeditorLeave();


    /*
     * ZARICHE
     */
    /** Access level required for command "admin_cw_info". Default: 75. */
    @Key("admin_cw_info")
    @DefaultValue("75")
    int getAdminCwInfo();

    /** Access level required for command "admin_cw_info_menu". Default: 75. */
    @Key("admin_cw_info_menu")
    @DefaultValue("75")
    int getAdminCwInfoMenu();

    /** Access level required for command "admin_cw_add". Default: 75. */
    @Key("admin_cw_add")
    @DefaultValue("75")
    int getAdminCwAdd();

    /** Access level required for command "admin_cw_remove". Default: 75. */
    @Key("admin_cw_remove")
    @DefaultValue("75")
    int getAdminCwRemove();

    /** Access level required for command "admin_cw_goto". Default: 75. */
    @Key("admin_cw_goto")
    @DefaultValue("75")
    int getAdminCwGoto();

    /** Access level required for command "admin_cw_reload". Default: 100. */
    @Key("admin_cw_reload")
    @DefaultValue("100")
    int getAdminCwReload();


    /*
     * MANOR
     */
    /** Access level required for command "admin_manor_info". Default: 75. */
    @Key("admin_manor_info")
    @DefaultValue("75")
    int getAdminManorInfo();

    /** Access level required for command "admin_manor_setnext". Default: 100. */
    @Key("admin_manor_setnext")
    @DefaultValue("100")
    int getAdminManorSetnext();

    /** Access level required for command "admin_manor_approve". Default: 100. */
    @Key("admin_manor_approve")
    @DefaultValue("100")
    int getAdminManorApprove();

    /** Access level required for command "admin_manor_disable". Default: 100. */
    @Key("admin_manor_disable")
    @DefaultValue("100")
    int getAdminManorDisable();

    /** Access level required for command "admin_manor_setmaintenance". Default: 100. */
    @Key("admin_manor_setmaintenance")
    @DefaultValue("100")
    int getAdminManorSetmaintenance();

    /** Access level required for command "admin_manor_save". Default: 75. */
    @Key("admin_manor_save")
    @DefaultValue("75")
    int getAdminManorSave();

}
