package net.sf.l2j.config;

import org.aeonbits.owner.ConfigFactory;

public class Configuration {
    private static final ServerConfiguration server = ConfigFactory.create(ServerConfiguration.class);

    private static final OptionsConfiguration options = ConfigFactory.create(OptionsConfiguration.class);

    private static final HexIDConfiguration hexID = ConfigFactory.create(HexIDConfiguration.class);

    private static final RatesConfiguration rates = ConfigFactory.create(RatesConfiguration.class);

    private static final L2JModsConfiguration l2JMods = ConfigFactory.create(L2JModsConfiguration.class);

    private static final TelnetConfiguration telnet = ConfigFactory.create(TelnetConfiguration.class);

    private static final IDFactoryConfiguration idFactory = ConfigFactory.create(IDFactoryConfiguration.class);

    public static ServerConfiguration server() {
        return server;
    }

    public static OptionsConfiguration options() {
        return options;
    }

    public static HexIDConfiguration hexID() {
        return hexID;
    }

    public static RatesConfiguration rates() {
        return rates;
    }

    public static L2JModsConfiguration l2JMods() {
        return l2JMods;
    }

    public static TelnetConfiguration telnet() {
        return telnet;
    }

    public static IDFactoryConfiguration idFactory() {
        return idFactory;
    }
}
