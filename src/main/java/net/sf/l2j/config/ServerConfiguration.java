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
    String getGameserverHostname();

    @Key("GameserverPort")
    int getGameserverPort();

    @Key("LoginPort")
    int getLoginPort();

    @Key("LoginHost")
    String getLoginHost();

    @Key("RequestServerID")
    int getRequestServerID();

    @Key("AcceptAlternateID")
    boolean getAcceptAlternateID();

    @Key("Driver")
    String getDriver();

    @Key("URL")
    String getURL();

    @Key("Login")
    String getLogin();

    @Key("Password")
    String getPassword();

    @Key("MaximumDbConnections")
    int getMaximumDbConnections();

    @Key("DatapackRoot")
    String getDatapackRoot();

    @Key("CnameTemplate")
    String getCnameTemplate();

    @Key("PetNameTemplate")
    String getPetNameTemplate();

    @Key("CharMaxNumber")
    int getCharMaxNumber();

    @Key("MaximumOnlineUsers")
    int getMaximumOnlineUsers();

    @Key("MinProtocolRevision")
    int getMinProtocolRevision();

    @Key("MaxProtocolRevision")
    int getMaxProtocolRevision();
}
