package com.aegisai.dto;

public class LoginResponse {

    private String message;
    private String token;

    public LoginResponse() {
    }

    // Constructor for only message
    public LoginResponse(String message) {
        this.message = message;
    }

    // Constructor for message + token
    public LoginResponse(String message, String token) {
        this.message = message;
        this.token = token;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}