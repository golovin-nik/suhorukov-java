package com.jcourse.golovin.seminar1.questions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

enum MyEnum {
    FIRST {
        @Override
        public String prettyName() {
            return "Первый";
        }
    },
    SECOND {
        @Override
        public String prettyName() {
            return "Второй";
        }
    },
    THIRD {
        @Override
        public String prettyName() {
            return "Третий";
        }
    };

    public String beautyName() {
        switch (this) {
            case FIRST:
                return "First";
            case SECOND:
                return "Second";
            case THIRD:
                return "Third";
            default:
                return "NONE";
        }
    }

    public abstract String prettyName();
}

enum Algorithm {
    MD5 {
        @Override
        public String encode(InputStream stream) {
            return null;
        }
    };

    public abstract String encode(InputStream stream);
}

public class EnumExamples {
    public static void main(String[] args) throws FileNotFoundException {
        System.out.println(MyEnum.FIRST.beautyName());
        System.out.println(MyEnum.FIRST.prettyName());
        Algorithm.MD5.encode(new FileInputStream(""));
    }
}
