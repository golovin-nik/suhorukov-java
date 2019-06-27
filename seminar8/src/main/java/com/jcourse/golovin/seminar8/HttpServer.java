package com.jcourse.golovin.seminar8;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class HttpServer {
    public static void main(String[] args) {
        // 255.255.255.255, 0-65535
        // 127.0.0.1 - локальный адресс
        // localhost
        try (ServerSocket serverSocket = new ServerSocket(8080);
             Socket socket = serverSocket.accept();
             InputStream is = socket.getInputStream();
             OutputStream out = socket.getOutputStream();
             Scanner scanner = new Scanner(is)) {
            String str;
            while ((str = scanner.nextLine()) != null) {
                System.out.println("str = " + str);
                //\r\n
                //\r\n\r\n
            }
            //send answer index.html
//            out.write();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
