package net.sf.l2j.messaging.handler;

import net.sf.l2j.gameserver.handler.AdminCommandHandler;
import net.sf.l2j.gameserver.handler.IAdminCommandHandler;
import net.sf.l2j.gameserver.model.L2World;
import net.sf.l2j.gameserver.model.actor.instance.L2PcInstance;
import net.sf.l2j.messaging.factory.ProducerFactory;
import net.sf.l2j.messaging.producer.Producer;
import net.sf.l2j.messaging.response.MessageResponse;
import org.json.JSONObject;

import java.util.Arrays;

public class AdminMessageHandler implements Handler {
    private Producer producer;
    private final L2PcInstance superAdminPlayer;
    private String[] allowedCommands = {
            "kill",
            "add_level",
            "set_level",
            "announce",
            "changelvl", // change access level
            "seteh", // PAPERDOLL_HEAD
            "setec", // PAPERDOLL_CHEST
            "seteg", // PAPERDOLL_GLOVES
            "setel", // PAPERDOLL_LEGS
            "seteb", // PAPERDOLL_FEET
            "setew", // PAPERDOLL_RHAND
            "setes", // PAPERDOLL_LHAND
            "setle", // PAPERDOLL_LEAR
            "setre", // PAPERDOLL_REAR
            "setlf", // PAPERDOLL_LFINGER
            "setrf", // PAPERDOLL_RFINGER
            "seten", // PAPERDOLL_NECK
            "setun", // PAPERDOLL_UNDER
            "setba", // PAPERDOLL_BACK
            "server_shutdown",
            "server_restart",
            "server_abort",
    };

    public AdminMessageHandler() {
        producer = ProducerFactory.create("server-response");
        superAdminPlayer = L2PcInstance.createDummyPlayer(-1, "Super admin");
        superAdminPlayer.setAccessLevel(100);
        superAdminPlayer.setIsGM(true);
    }

    public void handleMessage(String command, String message, JSONObject jsonObject) {
        MessageResponse response = new MessageResponse(producer, jsonObject);

        if (!Arrays.asList(allowedCommands).contains(command)) {
            response.sendError("Command not allowed!");

            return;
        }

        command = "admin_" + command;
        IAdminCommandHandler commandHandler = AdminCommandHandler.getInstance().getAdminCommandHandler(command);
        command += " " + message;

        if (commandHandler == null) {
            response.sendError("Command handler not found!");

            return;
        }

        if (jsonObject.has("target")) {
            L2PcInstance player = L2World.getInstance().getPlayer(jsonObject.getString("target"));

            if (player == null) {
                response.sendError("Target not found!");
            }

            superAdminPlayer.setTarget(player);
        }

        boolean success = commandHandler.useAdminCommand(command, superAdminPlayer);

        response.sendResponse(success, null);
    }
}
