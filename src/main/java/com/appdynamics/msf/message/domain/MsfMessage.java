package com.appdynamics.msf.message.domain;

import java.util.Date;

// TODO: add missing fields
public class MsfMessage {

    private final String id;
    private String message;
    private Boolean isOpened = Boolean.FALSE;
    private Date expiryDate;

    //created Instance
    // ttl
    // boolean isOpened

    // (CurrentTime < CreatedTime + TTL && !isOpened)
    // message can be accessed
    public MsfMessage(String id,
                      String message,
                      Date expiryDate) {
        this.id = id;
        this.message = message;
        this.expiryDate = expiryDate;
    }

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

    public Boolean getOpened() {
        return isOpened;
    }

    public void setOpened(Boolean opened) {
        isOpened = opened;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }
}
