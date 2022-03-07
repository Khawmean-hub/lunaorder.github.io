package com.kosign.luna.model;

public class ResponseMessage {
    String message;
    int code;

    public ResponseMessage(String message) {
        this.message = message;
    }

    public ResponseMessage(String message, int code) {
        this.message = message;
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
