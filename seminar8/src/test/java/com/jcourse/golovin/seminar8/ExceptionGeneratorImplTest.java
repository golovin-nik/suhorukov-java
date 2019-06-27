package com.jcourse.golovin.seminar8;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class ExceptionGeneratorImplTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    private ExceptionGenerator exceptionGenerator;

    @Before
    public void initGenerator() {
        exceptionGenerator = new ExceptionGeneratorImpl();
    }

    @Test(expected = NullPointerException.class)
    public void generateNullPointerException() {
        exceptionGenerator.generateNullPointerException();
    }

    @Test
    public void generateClassCastException() {
    }

    @Test
    public void generateNumberFormatException() {
    }

    @Test
    public void generateStackOverflowError() {
    }

    @Test(expected = OutOfMemoryError.class)
    public void generateOutOfMemoryError() {
        exceptionGenerator.generateOutOfMemoryError();
    }

    @Test
    public void generateMyException() {
        thrown.expect(MyException.class);
        thrown.expectMessage("ОШИБКА");
    }
}