package com.jcourse.golovin.seminar9;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class IndexHtmlGenerator {

    public static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat(
            "YYYY-MM-dd'T'HH:mm:ss");

    static byte[] generateIndexHtml(File file) throws IOException {
        if (!file.exists()) {
            throw new FileNotFoundException(file.getName());
        }
        if (file.isDirectory()) {
            StringBuilder out = new StringBuilder(
                    "<html><head><meta charset=\"utf-8\"/></head><body><table>");
            File[] filesInDir = file.listFiles();
            sortFiles(filesInDir);
            writeTableHead(out);
            writeLinkToParent(out);
            for (File f : filesInDir) {
                writeFile(f, out);
            }
            out.append("</table></body></html>");
            return out.toString().getBytes();
        } else {
            return Files.readAllBytes(file.toPath());
        }
    }

    private static void writeFile(File file, StringBuilder out) throws UnsupportedEncodingException {
        out.append("<tr><td>");
        out.append("<a href=\"" + URLEncoder.encode(file.getName(), "UTF-8") +
                (file.isDirectory() ? "/" : "") +
                "\">");
        out.append(file.getName());
        out.append("</td><td>");
        out.append(file.length());
        out.append("</td><td>");
        long millis = file.lastModified();
        Date date = new Date(millis);
        out.append(DATE_FORMAT.format(date));
        out.append("</td></tr>");
    }

    private static StringBuilder writeLinkToParent(StringBuilder out) {
        return out.append("<tr><td><a href=\"..\">Parent</a></td><td></td><td></td></tr>");
    }

    private static void writeTableHead(StringBuilder out) {
        out.append("<tr><td>File Name</td><td>Size</td><td>Last Modified</td></tr>");
    }

    private static void sortFiles(File[] filesInDir) {
        Arrays.sort(filesInDir, (f1, f2) -> {
            if (f1.isDirectory() && f2.isDirectory() ||
                    f1.isFile() && f2.isFile()) {
                return f1.getName().compareTo(f2.getName());
            } else if (f1.isDirectory()) {
                return -1;
            } else {
                return 1;
            }
        });
    }
}

