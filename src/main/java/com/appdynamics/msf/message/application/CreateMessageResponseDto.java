package com.appdynamics.msf.message.application;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class CreateMessageResponseDto {

    private String accessLink;
    private Date expiry;

    public CreateMessageResponseDto(String accessLink, Date expiry) {
        this.accessLink = accessLink;
        this.expiry = expiry;
    }

    public String getAccessLink() {
        return accessLink;
    }

    @JsonFormat(pattern="MMM dd, yyyy HH:mm:ss zz")
    public Date getExpiry() {
        return expiry;
    }
}
