package com.jcourse.golovin.seminar5;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamImplementation {
    public static void main(String[] args) {
        try (Stream<String> lines = Files.lines(Paths.get(args[0]));
             OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream("out.txt"))) {
            AtomicLong total = new AtomicLong(0);
            lines
                    .flatMap(line -> Arrays.stream(
                            line.split("[^\\p{L}\\p{N}]+")))
                    .filter(word -> !word.isEmpty())
                    .peek(word -> total.incrementAndGet())
//                    .collect(Collectors.toMap(word -> word, word -> 1,
//                            (freq1, freq2) -> freq1 + freq2))
                    .collect(Collectors.groupingBy(word -> word, Collectors.counting()))
                    .entrySet()
                    .stream()
                    .sorted(Comparator.comparingLong(
                            Map.Entry<String, Long>::getValue)
                            .reversed()
                            .thenComparing(Map.Entry::getKey))
                    .forEach(entry -> {
                        try {
                            writer.write(entry.getKey() + ";" +
                                    entry.getValue() + ";" +
                                    (entry.getValue() * 100.0 / total.get() + "\n"));
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    });

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
