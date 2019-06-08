package com.jcourse.golovin;

import org.junit.*;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class CalcTest {

    private Calc calc;
    private int i = 0;

    @Before
//    @BeforeClass
    public void setUp() throws Exception {
        calc = new Calc();
    }

    @After
//    @AfterClass
    public void tearDown() throws Exception {
        System.out.println("Тест завершен");
    }

    @Test
    public void add() {
        i += 2;
        int result = calc.add(2, i);
        Assert.assertEquals(4, result);
    }

    @Test
    public void subtract() {
        int result = calc.subtract(i, 2);
        Assert.assertEquals(0, result);
    }

    @Test
    public void testCalculator() {
        Class<? extends CalcTest> aClass = getClass();
        InputStream stream = aClass
                .getResourceAsStream("calc-test.txt");
        Stack<Double> stack = new Stack<Double>();
        Map<String, Double> variables = new HashMap<>();
        Parser parser = new FileParser(stream, stack, variables);
//        Calc calc = new Calc(parser);
//        calc.execute();
        Assert.assertEquals(5.0, stack.peek(), 0.01);
    }

    static void staticMethod() {
        Class<CalcTest> calcTestClass = CalcTest.class;
    }
}