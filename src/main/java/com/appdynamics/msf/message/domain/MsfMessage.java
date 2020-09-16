package com.appdynamics.msf.message.domain;

// TODO: add missing fields
public class MsfMessage {

    private final String id;
    private String message;

    public MsfMessage(String id,
                      String message) {
        this.id = id;
        this.message = message;
    }

    public String getId() {
        return id;
    }

    public String getMessage() {
        return message;
    }
}
