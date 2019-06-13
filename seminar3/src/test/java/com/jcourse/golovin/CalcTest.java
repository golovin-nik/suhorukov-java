package com.jcourse.golovin;

import org.junit.*;
import org.junit.rules.ExpectedException;

import java.io.*;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.zip.GZIPOutputStream;

public class CalcTest {

    @Rule
    public ExpectedException thrown =
            ExpectedException.none();
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

    @Test
    public void thrownNumberFormatException() {
        thrown.expect(NumberFormatException.class);
        thrown.expectMessage("");

        double abc = Double.parseDouble("abc");

        //InputStream, OutputStream - работа с байтами
        //Reader, Writer - работа с символами
        //InputStreamReader - можно указать кодировку
        //BufferedReader - они осуществляют чтение в буфер
        //BufferedWriter - для буферизованного вывода

        try (FileOutputStream fos = new FileOutputStream("file.gz");
             GZIPOutputStream gzip = new GZIPOutputStream(fos);
             OutputStreamWriter out = new OutputStreamWriter(gzip, "cp1251");
             BufferedWriter writer = new BufferedWriter(out)) {

        } catch (IOException e) {
            e.printStackTrace();
        }
//        logger.info("arguments: {}, {}", 1, "s");
//        log4j -> slf4j, logback
    }
}

//IOC-container @Inject
//Банда четырех
//Шаблон проектирования