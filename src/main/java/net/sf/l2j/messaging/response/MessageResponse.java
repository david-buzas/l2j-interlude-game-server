package net.sf.l2j.messaging.response;

import net.sf.l2j.messaging.producer.Producer;
import org.json.JSONObject;

public class MessageResponse implements Response {
    private final Producer producer;
    private final JSONObject request;

    public MessageResponse(Producer producer, JSONObject request) {
        this.producer = producer;
        this.request = request;
    }

    public void sendResponse(boolean success, String message) {
        JSONObject response = new JSONObject();
        response.put("request", request);
        response.put("success", success);

        if (message != null) {
            response.put("message", message);
        }

        producer.createMessage(String.valueOf(response));
    }

    public void sendError(String message) {
        sendResponse(false, message);
    }

    public void sendSuccess(String message) {
        sendResponse(true, message);
    }

    public void sendSuccess() {
        sendResponse(true, null);
    }
}
