package net.sf.l2j.messaging.handler;

import net.sf.l2j.messaging.dto.MessageDTO;

import java.util.Map;

public interface MessageHandler {
    void handleMessage(MessageDTO messageDTO);
}
