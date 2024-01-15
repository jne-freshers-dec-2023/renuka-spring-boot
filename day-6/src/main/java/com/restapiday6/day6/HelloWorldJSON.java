package com.restapiday6.day6;

public class HelloWorldJSON {
    private String message;

    public HelloWorldJSON() {
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public HelloWorldJSON(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "HelloWorldJSON{" +
                "message='" + message + '\'' +
                '}';
    }
}
