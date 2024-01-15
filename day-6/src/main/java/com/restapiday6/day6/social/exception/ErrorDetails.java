package com.restapiday6.day6.social.exception;

import java.time.LocalDate;

public class ErrorDetails {
    private Boolean success;
    private String message;

    public ErrorDetails(Boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public Boolean getSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }
}
