package net.sf.l2j.util;

import net.sf.l2j.config.CommandPrivilegesConfiguration;
import org.aeonbits.owner.ConfigFactory;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.logging.Logger;
import java.util.stream.Collectors;

/**
 * Utility helper for resolving required access level of admin commands
 * based on {@link CommandPrivilegesConfiguration}.
 */
public final class CommandPrivileges {

    // Create the config instance once (Owner supports hot reload)
    private static final CommandPrivilegesConfiguration CONFIG =
            ConfigFactory.create(CommandPrivilegesConfiguration.class);

    // Alt privileges setting
    private static final Logger privilegesLog = Logger.getLogger("AltPrivilegesAdmin");

    private CommandPrivileges() {
        // Utility class -> prevent instantiation
    }

    /**
     * Resolves the required access level for a given command.
     *
     * @param command the raw command string (same as the property key, e.g. "admin_cache_htm_reload")
     * @return the required access level, or -1 if not found
     */
    public static int getRequiredLevel(String command) {
        try {
            // Build the getter name: "admin_cache_htm_reload" -> "getAdminCacheHtmReload"
            String methodName = "get" + Arrays.stream(command.split("[._-]+"))
                    .map(s -> s.substring(0, 1).toUpperCase() + s.substring(1))
                    .collect(Collectors.joining());

            // Reflectively invoke the getter
            Method method = CommandPrivilegesConfiguration.class.getMethod(methodName);
            return (int) method.invoke(CONFIG);
        }
        catch (NoSuchMethodException e) {
            // No such config defined
            return -1;
        }
        catch (Exception e) {
            privilegesLog.warning(e.getMessage());
            return -1;
        }
    }
}
