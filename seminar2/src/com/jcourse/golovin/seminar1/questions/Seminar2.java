package com.jcourse.golovin.seminar1.questions;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class Seminar2 {
    public static void main(String[] args) {
//        stringEquals();

        Integer i1 = 127;
        Integer i2 = 127;

        System.out.println("i1 == i2: " + (i1 == i2));
        System.out.println("i1.equals(i2): " + (i1.equals(i2)));

        //byte -128;127
        Integer i3 = 128;
        Integer i4 = 128;

        System.out.println("i3 == i4: " + (i3 == i4));
        System.out.println("i3.equals(i4): " + (i3.equals(i4)));
    }

    private static void stringEquals() {
        String s1 = "Hello";
        String s2 = s1;

        System.out.println("s1 == s2: " + (s1 == s2));
        System.out.println("s1.equals(s2): " + (s1.equals(s2)));

        String s3 = "Hello";
        System.out.println("s1 == s3: " + (s1 == s3));
        System.out.println("s1.equals(s3): " + (s1.equals(s3)));

        String s4 = "Hel";
        String s5 = "lo";
        System.out.println("s1 == s4 + s5: " + (s1 == (s4 + s5)));
        System.out.println("s1.equals(s4 + s5): " + (s1.equals(s4 + s5)));

        System.out.println("s1 == s4 + s5: " + (s1 == (s4 + s5).intern()));
        System.out.println("s1.equals(s4 + s5): " + (s1.equals(s4 + s5)));
    }
}

class MyClass {
    private int a;
    private String b;
    private MyClass c;

    public MyClass(int a) {
        this.a = a;
    }

    //    @Override
//    public boolean equals(Object ob) {
//        if (ob == null) {
//            return false;
//        }
//        if (ob.getClass() != MyClass.class) {
//            return false;
//        }
//        MyClass myClass = (MyClass) ob;
//        return a == myClass.a &&
//                b.equals(myClass.b) &&
//                c.equals(myClass.c);
//    }

    static class A {
        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || obj instanceof A) return false;
            return true;
        }
    }
    static class B extends A {

    }

    public static void main(String[] args) {
        A b = new B();
        A a = new A();
        System.out.println(a.equals(b));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || o instanceof MyClass) return false;
        MyClass myClass = (MyClass) o;

        class LocalClass {

        }
        LocalClass localClass = new LocalClass();
        return a == myClass.a &&
                Objects.equals(b, myClass.b) &&
                Objects.equals(c, myClass.c);
    }

    @Override
    public int hashCode() {
        return Objects.hash(a, b, c);
    }
}

class Outer {

    static class Nested {
        private int n1;
    }

    class Inner {
        private int o1;
    }

    //детали реализации
    private static class Context {

        int a;
        int b;
        String c;
        InputStream stream;
    }
    void foo(Context context) {
        bar(context);
    }

    void bar(Context context) {

    }

    public static void main(String[] args) {
        Nested nested = new Nested();
        Outer outer = new Outer();
        Inner inner = outer.new Inner();
//        Statistic.PartnerStatistic partnerStatistic;

        Object myClass = new MyClass(42);
//        if (myClass instanceof String) {
//            System.out.println("Это строка");
//        } else if (myClass instanceof Integer) {
//
//        } else if (myClass instanceof MyClass) {
//
//        }
//        pattern matching

    }
}

//есть очень локальный, контекст в котором нужно использовать классы
class Statistic {
    List<PartnerStatistic> partnerStatistic = new ArrayList<>();

    class PartnerStatistic {
        String partnerType;
        List<DateStatistic> statistics;
    }

    class DateStatistic {
        Date date;
        BigDecimal purchaseAmount;
        BigDecimal refundAmount;
    }
}

//Вместо instanceof применяйте наследование + виртуальные методы
abstract class Shape {
    abstract void print();
}

class Triangle extends Shape {
    @Override
    void print() {
        try {
            var stream = System.in;
            var nextInt = stream.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class Rectangle extends Shape {
    @Override
    void print() {
    }
}

//ax^2 + bx + c
//X1 = (-b + sqrt(b*b – 4ac)) / 2a
//DEFINE a 1
//DEFINE b -2;
//DEFINE c 3
//PUSH a
//PUSH 2
//* (2a)
//PUSH b
//PUSH -1
//* (-b, 2a)
//PUSH b
//PUSH b
//* (b^2, -b, 2a)
//PUSH 4
//PUSH a
//PUSH c
//* (ac, 4, b^2, -b, 2a)
//* (4ac, b^2, -b, 2a
//- (b^2 - 4ac, -b, 2a)
//sqrt (sqrt(b^2 - 4ac), -b, 2a
//+ (sqrt(b^2 - 4ac) -b, 2a
/// (sqrt(b^2 - 4ac) -b / 2a
//PRINT

//Stack
//(-b + sqrt(b*b – 4ac)) - 1 число
//2a - второе
// Double b = stack.pop();
// Double a = stack.pop();
// return a / b;

// Stack []
// Map []
// + (EmptyStackException)

