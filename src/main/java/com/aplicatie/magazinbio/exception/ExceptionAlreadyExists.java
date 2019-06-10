package com.aplicatie.magazinbio.exception;

public class ExceptionAlreadyExists extends Exception {
    private String message;

    public ExceptionAlreadyExists(String message) {
        super();
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
