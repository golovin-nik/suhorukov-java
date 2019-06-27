package com.jcourse.golovin.seminar8;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class IndexHtmlGenerator {
    static String generateIndexHtml(String dirName) {
        File dir = new File(dirName);
        StringBuilder out = new StringBuilder(
                "<html><head></head><body><table>");
        if (dir.isDirectory()) {
            File[] filesInDir = dir.listFiles();
            Arrays.sort(filesInDir, (f1, f2) -> {
                if (f1.isDirectory() && f2.isDirectory()) {

                }
                return 0;
            });
            //<td><a href="..">Parent</a></td>
            for (File file : filesInDir) {
                out.append("<tr>");
                out.append("<td>");
                out.append("<a href=\"" + file.getName() + "\">");
                out.append(file.getName());
                out.append("</td>");
                long millis = file.lastModified();// дата последней модификации
                Date date = new Date(millis);
                formatDate(date);
                file.length(); //размер в байтах
            }
        }
        return null;
    }

    private static String formatDate(Date date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(
                "YYYY-MM-dd'T'HH:mm:ss");
        return dateFormat.format(date);
    }

    public static void main(String[] args) {
        System.out.println(formatDate(new Date()));
//        String indexHtml = generateIndexHtml("<your_path>");
//        try (FileWriter writer = new FileWriter("index.html")) {
//            writer.write(indexHtml);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }
}
