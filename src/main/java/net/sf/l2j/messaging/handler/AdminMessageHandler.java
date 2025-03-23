package net.sf.l2j.messaging.handler;

import net.sf.l2j.gameserver.handler.AdminCommandHandler;
import net.sf.l2j.gameserver.handler.IAdminCommandHandler;
import net.sf.l2j.gameserver.model.L2World;
import net.sf.l2j.gameserver.model.actor.instance.L2PcInstance;
import net.sf.l2j.messaging.dto.MessageDTO;

import java.util.Arrays;

public class AdminMessageHandler implements MessageHandler {
    private final L2PcInstance superAdminPlayer;
    private final String[] allowedCommands = {
            "kill", "add_level", "set_level", "announce", "changelvl", "seteh",
            "setec", "seteg", "setel", "seteb", "setew", "setes",
            "setle", "setre", "setlf", "setrf", "seten", "setun",
            "setba", "server_shutdown", "server_restart", "server_abort",
    };

    public AdminMessageHandler() {
        superAdminPlayer = L2PcInstance.createDummyPlayer(-1, "Super admin");
        superAdminPlayer.setAccessLevel(100);
        superAdminPlayer.setIsGM(true);
    }

    public void handleMessage(MessageDTO messageDTO) {
        String command = messageDTO.getValue("command");
        String adminCommand = messageDTO.getPrefixedValue("command", "admin", "_");
        String adminCommandWithParam = messageDTO.getPrefixedValue("parameter", adminCommand, " ");

        if (!isAllowed(command)) {
            return;
        }

        IAdminCommandHandler commandHandler = AdminCommandHandler
                .getInstance()
                .getAdminCommandHandler(adminCommand);

        if (commandHandler == null) {
            return;
        }

        if (messageDTO.hasValue("target")) {
            String target = messageDTO.getValue("target");

            L2PcInstance player = L2World
                    .getInstance()
                    .getPlayer(target);

            if (player == null) {
                return;
            }

            superAdminPlayer.setTarget(player);
        }

        commandHandler.useAdminCommand(adminCommandWithParam, superAdminPlayer);

    }

    private boolean isAllowed(String command) {
        return Arrays.asList(allowedCommands).contains(command);
    }
}
