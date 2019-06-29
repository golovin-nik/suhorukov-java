package com.jcourse.golovin.seminar9.httpserver;

import javax.activation.MimetypesFileTypeMap;
import java.io.*;
import java.net.Socket;
import java.net.URLDecoder;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

class ClientHandler implements Runnable {
    private static final String ROOT_DIR = "/home/n1k1t4";
    private static final List<String> SUPPORTED_COMMANDS = Arrays.asList("GET", "HEAD");

    private Socket socket;

    public ClientHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try (InputStream in = socket.getInputStream();
             OutputStream out = socket.getOutputStream()) {

            StringBuilder sb = readFirstLine(in);
            String firstLine = sb.toString();
            String[] tokens = firstLine.split(" ");

            if (!SUPPORTED_COMMANDS.contains(tokens[0])) {
                handleUnsupportedCommand(out);
                return;
            }

            String requestedFilename = tokens[1];
            if ("/favicon.ico".equals(requestedFilename)) {
                return;
            }
            // \\, /
            Path requestedPath = Paths.get(ROOT_DIR,
                    URLDecoder.decode(requestedFilename, "UTF-8"));
            File requestedFile = requestedPath.toFile();
            String contentType = getContentType(requestedFile);
            try {
                handleOkResponse(out, requestedFile, contentType);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                handleFileNotFound(out);
            } catch (Exception e) {
                e.printStackTrace();
                handleInternalServerError(out);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void handleOkResponse(OutputStream out, File requestedFile, String contentType) throws IOException {
        byte[] resultBytes =
                IndexHtmlGenerator.generateIndexHtml(requestedFile);
        out.write("HTTP/1.0 200 OK\r\n".getBytes());
        out.write(("Content-Type: " + contentType + "\r\n").getBytes());
        out.write(("Content-Length: "+resultBytes.length+"\r\n").getBytes());
        out.write("\r\n".getBytes());
        out.write(resultBytes);
        out.flush();
    }

    private String getContentType(File requestedFile) {
        String contentType;
        if (requestedFile.isDirectory()) {
            contentType = "text/html";
        } else {
            contentType = new MimetypesFileTypeMap().getContentType(requestedFile);
        }
        return contentType;
    }

    private StringBuilder readFirstLine(InputStream in) throws IOException {
        //GET /wiki/HTTP HTTP/1.0
        StringBuilder sb = new StringBuilder();
        int c;
        while((c =in.read())!=-1 && c!=10 && c!=13){
            sb.append((char)c);
        }
        return sb;
    }

    private void handleUnsupportedCommand(OutputStream out) throws IOException {
        out.write("HTTP/1.1 501 Not Implemented\r\n".getBytes());
        out.write("\r\n".getBytes());
        out.flush();
    }

    private void handleFileNotFound(OutputStream out) throws IOException {
        out.write("HTTP/1.1 404 Not Found\r\n".getBytes());
        out.write("\r\n".getBytes());
        out.flush();
    }

    private void handleInternalServerError(OutputStream out) throws IOException {
        out.write("HTTP/1.1 500 Internal Server Error\r\n".getBytes());
        out.write("\r\n".getBytes());
        out.flush();
    }
}
