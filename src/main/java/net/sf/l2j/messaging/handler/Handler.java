package net.sf.l2j.messaging.handler;

import org.json.JSONObject;

public interface Handler {
    public void handleMessage(String command, String message, JSONObject jsonObject);
}
