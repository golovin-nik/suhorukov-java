package com.jcourse.golovin.seminar1.questions;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Seminar1 {

    public static void main(String[] args) {
        part1();
    }

    private static void part1() {
        byte[] bytes = "Привет, Мир!".getBytes();
        String encoding = System.getProperty("file.encoding");
        try {
            String s = new String(bytes, encoding);
            Charset charset = Charset.forName("cp1251");
            String s2 = new String(bytes, charset);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}

// Single Responsibility Principle (S из SOLID)
class Game {
    private static final int GUESSED_NUMBER_BOND = 101;
    private static final int MAX_ATTEMPTS = 8;
    private final Reader reader;

    public Game(Reader reader) {
        this.reader = reader;
    }

    public void runGame() {
        Random random = new Random(GUESSED_NUMBER_BOND);
        for (int i = 0; i < MAX_ATTEMPTS; i++) {
        }
        try {
            int nextNumber = reader.getNextNumber();
        } catch (Exception e) {
            System.err.println("Это не число");
        }
    }

    void method(int[] array) {
        for (int i = 0; i < 100; i++) {
            int i1 = array[i];
            int b = 42 / i1;
        }
    }
}

interface Reader {
    int getNextNumber();
}

class DesktopReader implements Reader {

    @Override
    public int getNextNumber() {
        return 0;
    }
}

class ConsoleReader implements Reader {
    @Override
    public int getNextNumber() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите следующее число");
        try {
            return scanner.nextInt();
        } catch (InputMismatchException e) {
            System.err.println("Ошибка");
            throw e;
        }
    }
}

class TestReader implements Reader {
    @Override
    public int getNextNumber() {
        return 42;
    }
}