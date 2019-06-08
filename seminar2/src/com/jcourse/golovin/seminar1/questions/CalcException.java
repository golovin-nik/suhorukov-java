package com.jcourse.golovin.seminar1.questions;

public class CalcException extends Exception/*RuntimeException*/ {
    public CalcException(String message, Throwable t) {
        super(message, t);
    }
}

class ExceptionHandler {
    public static void main(String[] args) throws CalcException {
        if (args.length == 0) {
            throw new IllegalArgumentException("");
        }
        String argument = "a";
        try {
            double a = Double.parseDouble(argument);
        } catch (NumberFormatException e) {
            String message = "Аргумент: " + argument + " не число";
            throw new CalcException(message, e);
//            CalcException exception = new CalcException(message);
//            exception.initCause(e);
//            throw exception;
        }

//        throw new IllegalArgumentException("");
//        throw new IllegalStateException("");
    }
}