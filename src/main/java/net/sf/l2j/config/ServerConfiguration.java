package net.sf.l2j.config;

import org.aeonbits.owner.Config;

import static java.util.concurrent.TimeUnit.MINUTES;
import static org.aeonbits.owner.Config.HotReloadType.ASYNC;
import static org.aeonbits.owner.Config.LoadType.MERGE;

@Config.Sources({
        "system:env",
        "file:${L2J_HOME}/custom/game/config/server.properties",
        "file:./config/server.properties",
        "classpath:config/server.properties"
})
@Config.LoadPolicy(MERGE)
@Config.HotReload(value = 20, unit = MINUTES, type = ASYNC)
public interface ServerConfiguration extends Config {
    @Key("GameserverHostname")
    @DefaultValue("*")
    String getGameserverHostname();

    @Key("GameserverPort")
    @DefaultValue("7777")
    int getGameserverPort();

    @Key("LoginPort")
    @DefaultValue("9014")
    int getLoginPort();

    @Key("LoginHost")
    @DefaultValue("127.0.0.1")
    String getLoginHost();

    @Key("RequestServerID")
    @DefaultValue("0")
    int getRequestServerID();

    @Key("AcceptAlternateID")
    @DefaultValue("true")
    boolean getAcceptAlternateID();

    @Key("Driver")
    @DefaultValue("com.mysql.jdbc.Driver")
    String getDriver();

    @Key("URL")
    @DefaultValue("jdbc:mariadb://127.0.0.1:3307/l2j_bartz")
    String getURL();

    @Key("Login")
    @DefaultValue("root")
    String getLogin();

    @Key("Password")
    @DefaultValue("root")
    String getPassword();

    @Key("MaximumDbConnections")
    @DefaultValue("10")
    int getMaximumDbConnections();

    @Key("DatapackRoot")
    @DefaultValue(".")
    String getDatapackRoot();

    @Key("CnameTemplate")
    @DefaultValue(".*")
    String getCnameTemplate();

    @Key("PetNameTemplate")
    @DefaultValue(".*")
    String getPetNameTemplate();

    @Key("CharMaxNumber")
    @DefaultValue("0")
    int getCharMaxNumber();

    @Key("MaximumOnlineUsers")
    @DefaultValue("100")
    int getMaximumOnlineUsers();

    @Key("MinProtocolRevision")
    @DefaultValue("740")
    int getMinProtocolRevision();

    @Key("MaxProtocolRevision")
    @DefaultValue("746")
    int getMaxProtocolRevision();
}
