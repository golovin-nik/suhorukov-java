package com.jcourse.golovin.seminar1.questions;

import java.awt.*;

class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Point)) return false;
        Point point = (Point) o;
        return x == point.x &&
                y == point.y;
    }
}

class ColorPoint extends Point {
    Color color;

    public ColorPoint(int x, int y, Color color) {
        super(x, y);
        this.color = color;
    }
}

public class Colors {
    public static void main(String[] args) {
        ColorPoint p1 = new ColorPoint(2, 4, Color.RED);
        Point p2 = new Point(2, 4);
        ColorPoint p3 = new ColorPoint(2, 4, Color.BLUE);

        System.out.println(p1.equals(p2));
        System.out.println(p2.equals(p3));
        System.out.println(p1.equals(p3));

        // Effective Java
        // Java: concurrency in practice
    }

}
