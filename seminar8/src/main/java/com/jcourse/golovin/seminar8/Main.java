package com.jcourse.golovin.seminar8;

import java.io.*;

class MyClass implements Serializable {
    private String str;
    private int i;
}

public class Main {
    public static void main(String[] args) {

    }


    private static void fastCopy() throws IOException {
        FileInputStream inputStream = new FileInputStream("in.txt");
        FileOutputStream outputStream = new FileOutputStream("out.txt");
        inputStream.transferTo(outputStream);
    }
}

interface ExceptionGenerator {
    void generateNullPointerException();
    void generateClassCastException();
    void generateNumberFormatException();
    void generateStackOverflowError();
    void generateOutOfMemoryError();
    void generateMyException(String message) throws MyException;
}

class ExceptionGeneratorImpl implements ExceptionGenerator {

    @Override
    public void generateNullPointerException() {

    }

    @Override
    public void generateClassCastException() {

    }

    @Override
    public void generateNumberFormatException() {

    }

    @Override
    public void generateStackOverflowError() {

    }

    @Override
    public void generateOutOfMemoryError() {
        int[] longArray = new int[Integer.MAX_VALUE];
    }

    @Override
    public void generateMyException(String message) throws MyException {
        //throw new MyException(message);
        //e.getMessage();
    }
}