package com.appdynamics.msf.message.application;

public class RetrieveMessageResponseDto {

    private final String message;

    public RetrieveMessageResponseDto(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
