package com.aplicatie.magazinbio.exception;


public class ExceptionIncorrectInput extends Exception {
    private static final long serialVersionUID = -3712981290802922344L;

    private String message;

    public ExceptionIncorrectInput(String message) {
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