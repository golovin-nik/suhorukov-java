
package com.jcourse.golovin.seminar1;

import java.io.Console;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

import static java.lang.Math.abs;
import static java.lang.Math.*;

//название классов PascalCase
public class Main {

//    Object
    //статические константы
    private static final int STATIC_CONST_FIELD = 3;

    protected final int constField;

    int myField;

    //public - доступ имеют все классы и объекты
    public Main() {
        this.constField = 42;
    }

    //методы, переменные, поля пишутся в camelCase
    public static void main(String[] args) throws UnsupportedEncodingException {
//        com.jcourse.golovin.seminar1.Main.STATIC_CONST_FIELD;

//        Main main = new Main();
////        main.myField;
//
//        System.out.println("Hello, World!");
//
//        main.myField += 30;
//        System.out.println("main.myField = " + main.myField);
//
//        System.out.println(Main.class.getSimpleName());
//        System.out.println(Main.class.getCanonicalName());
//
//        System.out.println(abs(-50));
//        System.out.println(log(50));
//
//        int variable = 10;
//        method(variable, main);
//        System.out.println("variable = " + variable);
//        System.out.println("main.myField = " + main.myField);

        Integer a = 5, b = 7;
//        swap(a, b); //a = 7, b = 5
        Integer i1 = 66; // i1 -> |  |
        Integer i2 = i1; // i2 -> |66|

        System.out.println(i1 == i2);
        i1 += 1;
        System.out.println(i1 == i2);
        AtomicInteger ai1 = new AtomicInteger(5);
        AtomicInteger ai2 = new AtomicInteger(7);
        swap(ai1, ai2);
        System.out.println("ai1 = " + ai1.get());
        System.out.println("ai2 = " + ai2.get());

        String s1 = "Hello";
        String s2 = ", World!";
        String intString = "77.0";
//        int ii = Integer.parseInt(intString);
        double d = Double.parseDouble(intString);
        Scanner scanner = new Scanner(System.in);
        String encoding = System.getProperty("file.encoding");
        System.setProperty("file.encoding", "UTF-8");
        System.setProperty("file.encoding", "cp1251");
        String s = new String("Привет!".getBytes(), encoding);
        System.out.println(s);

        Random random = new Random();
        int guessNumber = random.nextInt(101);

        if (guessNumber < d) {
            System.out.println("Меньше");
        } else {
            System.out.println("Больше");
        }

        try {
            int i = Integer.parseInt("aabb");
        } catch (NumberFormatException e) {
            System.err.println("Строка не является числом");
        }

        System.out.println(d);

//        Integer, Byte, Short, Character, Boolean
//        Integer integer = 42; //autoboxing
//        int bb = integer; //unboxing
//
//        Integer anotherInteger = null;
//        List<Integer> list = new ArrayList<>();
//        int, byte, short, long, double, float
        // char
//        boolean
//        int[], byte[] - массивы
        // Main - классы, Color - перечисления
    }

    static void method(int a, Main main) {
        a += 10;
        main.myField += 10;
    }

    static void swap(AtomicInteger a, AtomicInteger b) {
        int tmp = a.get();
        a.set(b.intValue());
        b.set(tmp);
    }
}

class МойКласс {
    int мояПеременная;

    void добавить(int надбавку) {
        мояПеременная += надбавку;
    }
}

//перечисления также как и константы
enum Color {
    RED, GREEN, YELLOW
}

// package
// <Название компании>.<Группа проектов>.<Название проект>
// google.com -> com.google
// jcourse.com
// package: com.jcourse.golovin.seminar1