package ru.job4j.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.regex.Pattern;

public class EchoServerBot {
    private static String hello = "Hello";
    private static String exit = "Exit";
    private static String any = "any";
   // private static Pattern pattern = Pattern.compile("\\?msg=" + "HTTP/1.1", Pattern.CASE_INSENSITIVE);

    public static void main(String[] args)  {
        try (ServerSocket server = new ServerSocket(9000)) {
            while (!server.isClosed()) {
                Socket socket = server.accept();
                try (OutputStream out = socket.getOutputStream();
                     BufferedReader in = new BufferedReader(
                             new InputStreamReader(socket.getInputStream()))) {
                    String str = in.readLine();
                    if (!(str.isEmpty()) && str != null && str.contains("msg=")) {
                        String request = str.substring(str.lastIndexOf("="), str.lastIndexOf(" "));
                        String response = String.valueOf(hello.equalsIgnoreCase(request));
                        System.out.println("HELLO");
                        if (any.equalsIgnoreCase(request)) {
                            System.out.println(" ");
                        }
                        if (exit.equalsIgnoreCase(response)) {
                            System.out.println("STOP");
                        }
                        out.write("HTTP/1.1 200 OK\r\n\r\n".getBytes());
                        out.write("Hello, dear friend.".getBytes());
                       // out.write("Hello, dear friend.".getBytes());
                        out.write(request.getBytes());
                        if (exit.equalsIgnoreCase(response)) {
                            System.out.println("STOP");
                            server.close();
                        }
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }
}
