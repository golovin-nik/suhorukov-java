package com.jcourse.golovin.seminar4;

import javafx.util.Pair;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.function.Consumer;

class MyClass {
    private int someState;

    @Override
    public boolean equals(Object obj) {
//        return someState == obj.someState;
        return true;
    }

    //работает с любым листом
    public void handleCollection(List<?> anyList) {
        Class<? extends MyClass> aClass = getClass();
    }
}

@SuppressWarnings("unchecked")
public class Seminar4 {
    public static void main(String[] args) {
//        classCastExceptionRuntime();

        List<Integer> genericList = new ArrayList<>();
        genericList.add(1);
//        genericList.add("s");
        Integer integer = (Integer) genericList.get(0);

        List<Integer> intList = new ArrayList<>();
        Number integerNumber = 42;
//        intList.add(integerNumber);
//        intList.add(42.0);

        extendsNumber();
        superNumber(integerNumber);
        // мнемоника PECS

        int[] intArray = {54, 21, -1, 52, 7, 6, 18};
        for (int i = 0; i < intArray.length; i++) {
            for (int j = i + 1; j < intArray.length; j++) {
                if (intArray[i] < intArray[j]) {
                    int tmp = intArray[i];
                    intArray[i] = intArray[j];
                    intArray[j] = tmp;
                }
            }
        }
        //O(n^2)
        //O(n*log n)
        //ax^2 + bx + c=0;
        //6x + 7x = 0
        //NP задачи - не решаются за O(n)
        System.out.println(Arrays.toString(intArray));

//        O(1)
//        Collection (List, Set, Queue), Map
        //List: ArrayList[,,,] поиск за O(1), LinkedList []->[]->[] поиск за O(n)
        //Кормен - структуры данных

        //Set - уникальное множество элементов
        //Map - ассоциативная карта
        Map<String, Integer> hashMap = new HashMap<>(); // поиск за O(1)
        Map<String, Integer> treeMap = new TreeMap<>(); // поиск за log n
        //Comparable - интерефейс, int compareTo(T)
//        TreeSet<MyClass> myClasses = new TreeSet<>(); - реализованы через RB-trees
//        myClasses.add(new MyClass());

//        List<List<Pair<String, Integer>>> - так устроена HashMap

    }

    private static void classCastExceptionRuntime() {
        List array = new ArrayList();
        array.add(1);
        array.add("s");
        for (int i = 0; i < array.size(); i++) {
            Integer value = (Integer) array.get(i);
        }
    }

    private static void superNumber(Number integerNumber) {
        List<? super Number> superNumber = new ArrayList<>();
        superNumber.add(integerNumber);
        superNumber.add(42);
        superNumber.add(42.0);
//        superNumber.add(new Object());
        superNumber.add(null);
    }

    private static <T extends String> void extendsNumber() {
        //Heap pollution - вместо объета требуемого типа, оказывается другой
        List<? extends Number> extendsNumber = new ArrayList<>();
//        extendsNumber.add(1); - не можем, т.к. лист может быть параметризован Integer,
//        или Double, или Number и т.п.
//        extendsNumber.add(1.0);
        extendsNumber.add(null);

        //true way
        List<Number> number = new ArrayList<>();
        number.add(1);
        number.add(1.0);

        loops(number);
        return;
    }

    private static void loops(List<Number> number) {
        for (int i = 0; i < number.size(); i++) {
            break;
        }
        while (true) {
            break;
        }
        do {
            break;
        } while (true);
        for (Number n: number) {

        }
        MyCollection<Integer> myCollection = new MyCollection<>();
        //Iterable
        for (Integer i : myCollection) {

        }
//        Iterator
//        Arrays, Collections, Files, Paths,

        try (InputStreamReader reader =
                     new InputStreamReader(new FileInputStream(""))){
            while (true) {
                int read = reader.read();
                if (read < 0) {
                    break;
                }
                if (Character.isLetterOrDigit(read)) {

                }
                StringBuilder sb = new StringBuilder();
                sb.append((char) read);
                System.out.println(sb.toString());
            }
        } catch (IOException e) {

        }
    }
}

class MyCollection<T> implements Iterable<T> {
    @Override
    public Iterator<T> iterator() {
        return null;
    }

    @Override
    public void forEach(Consumer<? super T> action) {

    }

    @Override
    public Spliterator<T> spliterator() {
        return null;
    }
}

class PhoneNumber {
    private String countryCode;
    private String cityCode;
    private String number;

    private String fullNumber; //== country + cityCode + number

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PhoneNumber that = (PhoneNumber) o;
        return Objects.equals(countryCode, that.countryCode) &&
                Objects.equals(cityCode, that.cityCode) &&
                Objects.equals(number, that.number);
    }

    //hashCode должен оперировать не большим количеством полей, чем equals
    @Override
    public int hashCode() {
        return Objects.hash(countryCode, cityCode, number, fullNumber);
    }


}