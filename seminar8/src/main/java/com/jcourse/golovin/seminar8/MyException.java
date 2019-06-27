package com.jcourse.golovin.seminar8;

public class MyException extends Exception {
    public MyException(String message) {
        super(message, null);
    }

    @Override
    public String getMessage() {
        String message = super.getMessage();
        System.out.println("message = " + message);
        return message;
    }
}
