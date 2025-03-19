package net.sf.l2j.messaging.response;

public interface Response {
    void sendResponse(boolean success, String error);

    void sendError(String message);

    void sendSuccess(String message);

    void sendSuccess();
}
