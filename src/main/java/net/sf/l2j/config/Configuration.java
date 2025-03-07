package net.sf.l2j.config;

import org.aeonbits.owner.ConfigFactory;

public class Configuration {
    private static final ServerConfiguration server = ConfigFactory.create(ServerConfiguration.class);

    private static final OptionsConfiguration options = ConfigFactory.create(OptionsConfiguration.class);

    private static final HexIDConfiguration hexID = ConfigFactory.create(HexIDConfiguration.class);

    public static ServerConfiguration server() {
        return server;
    }

    public static OptionsConfiguration options() {
        return options;
    }

    public static HexIDConfiguration hexID() { return hexID; }
}
