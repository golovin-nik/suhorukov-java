package com.jcourse.golovin.seminar5;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Stream;

class WordCount implements Comparable<WordCount> {
    private String word;
    private long count;

    public WordCount(String word, long count) {
        this.word = word;
        this.count = count;
    }

    public int compareTo(WordCount o) {
        if (count < o.count) {
            return 1;
        } else if (count > o.count) {
            return -1;
        } else {
            return word.compareTo(o.word);
        }
    }

    @Override
    public String toString() {
        return "WordCount{" +
                "word='" + word + '\'' +
                ", count=" + count +
                '}';
    }

    public String getWord() {
        return word;
    }

    public long getCount() {
        return count;
    }
}

public class Main {
    public static void main(String[] args) throws URISyntaxException {
        System.out.println(String.format("%.5f%%", 77.12345678));

        String path1 = Main.class
                .getClassLoader()
                .getResource("in.txt")
                .toURI()
                .getPath();

        Path path = Paths.get(path1);
        int count = 0;
        int[] arrayCount = {0};
        AtomicLong atomicLong = new AtomicLong(0);
        try (Stream<String> lines = Files.lines(path);
             OutputStreamWriter writer = new OutputStreamWriter(
                     new FileOutputStream("out.txt"))) {
            //операция не выполняется, пока не вызовется терминальный метод
//            Stream<String> filtered = lines.filter(s -> !s.isEmpty());
//            long count = filtered.count();
            lines
//                    .map() // f: X -> Y
                    .flatMap((String line) -> { // f: X -> Stream<Y>
                        System.out.println("line = " + line);
                        String[] tokens = line.split(" ");
                        return Arrays.stream(tokens);
                    })
                    .map(word -> new WordCount(word, 1))
//                    .peek() // пройтись в peek по всем словам и подсчитать общее кол-во
//                    .filter()
//                    .collect(Collectors.groupingBy()) //
                    .forEach(wordCount -> {
//                        count++;
                        try {
                            arrayCount[0]++;
                            writer.write(1);
                            atomicLong.incrementAndGet();
                            System.out.println("wordCount = " + wordCount);
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void waysToCompareObjects() {
        Map<String, Integer> map = new HashMap<>();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            WordCount wordCount =
                    new WordCount(entry.getKey(), entry.getValue());
        }
        WordCount[] wordCountsArray = {
                new WordCount("abc", 5),
                new WordCount("cba", 5),
                new WordCount("hello", 3),
                new WordCount("good bye", 7)
        };
        Arrays.sort(wordCountsArray);

        List<WordCount> wordCountList = Arrays.asList(
                new WordCount("abc", 5),
                new WordCount("cba", 5),
                new WordCount("hello", 3),
                new WordCount("good bye", 7));

        System.out.println("before sort wordCountList = " + wordCountList);
        wordCountList.sort(Comparator.naturalOrder());
        System.out.println("after sort wordCountList = " + wordCountList);

        System.out.println("--------------------------------------------");
        Collections.shuffle(wordCountList);

        System.out.println("before sort wordCountList = " + wordCountList);
        wordCountList.sort(null);
        System.out.println("after sort wordCountList = " + wordCountList);

        System.out.println("--------------------------------------------");
        Collections.shuffle(wordCountList);

        System.out.println("before sort wordCountList = " + wordCountList);
        Set<WordCount> wordCountSet = new TreeSet<>(wordCountList);
        System.out.println("after sort wordCountSet = " + wordCountSet);

        System.out.println("--------------------------------------------");
        Collections.shuffle(wordCountList);
        System.out.println("before sort wordCountList = " + wordCountList);
        Collections.sort(wordCountList);
        System.out.println("after sort wordCountSet = " + wordCountSet);


        System.out.println("--------------------------------------------");
        Collections.shuffle(wordCountList);
        System.out.println("before sort wordCountList = " + wordCountList);

        Map<String, Integer> anotherMap = new HashMap<>();
        anotherMap.entrySet().stream()
                .sorted(Comparator.comparingLong(
                        Map.Entry<String, Integer>::getValue)
                        .reversed()
                        .thenComparing(Map.Entry::getKey));
        Comparator<WordCount> comparator = Comparator
                .comparingLong(WordCount::getCount)
                .reversed()
                .thenComparing(WordCount::getWord);
        wordCountList.sort(comparator);
        System.out.println("after sort wordCountList = " + wordCountList);
    }
}
