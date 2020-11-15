package ru.job4j.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.SQLOutput;

public class EchoServerBot {
    private static final String HELLO = "hello";
    private static final String EXIT = "exit";
    private static final String ACTION = "msg=";
    // private static Pattern pattern = Pattern.compile("\\?msg=" + "HTTP/1.1", Pattern.CASE_INSENSITIVE);

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(9000)) {
            while (!server.isClosed()) {
                Socket socket = server.accept();
                try (OutputStream out = socket.getOutputStream();
                     BufferedReader in = new BufferedReader(
                             new InputStreamReader(socket.getInputStream()))) {
                    String str = in.readLine();
                    String answer = "";
                    //str = str.replaceAll ("GET (?:.*msg=(.*))?.* .*", "$1");
                    //GET /?msg=asdf
                    if (str != null && !str.isEmpty() && str.contains("msg=")) {
                        String request = str.substring(str.lastIndexOf(ACTION) + ACTION.length(), str.lastIndexOf(" "));

                        if (HELLO.equalsIgnoreCase(request)) {
                            answer = "HELLO USER!";
                            System.out.println(answer);
                        } else if (EXIT.equalsIgnoreCase(answer)) {
                            answer = "SERVER IS CLOSING";
                        } else {
                            answer = request;
                        }

                        out.write("HTTP/1.1 200 OK\r\n\r\n".getBytes());
                        out.write(("Hello, dear friend." + answer).getBytes());
                        out.flush();

                        if (EXIT.equalsIgnoreCase(request)) {
                            server.close();
                        }
                    } else {
                        out.write("HTTP/1.1 400 Bad Request".getBytes());
                        out.flush();
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }
}
