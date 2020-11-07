package ru.job4j.io;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

public class EchoServerChatBot {
    private static SimpleDateFormat format = new SimpleDateFormat("EEE, d MMM yyyy HH:mm:Ss z");

    static void ok(BufferedWriter out) throws IOException {
        String res = "HTTP/1.1 200 OK\n"
                + "Server: HTTP server/0.1\n"
                + "Date: "
                + format.format(new java.util.Date ())
                + "\n";
        out.write(res);
    }

    static void transferMsg(String msg, BufferedWriter out) throws IOException {
        ok(out);
        String res = "Content-type: text/html; charset=UTF-8\n"
                + "Content-Length: " + msg.length() + "\n\n"
                + msg;
        out.write(res);
        out.flush();
    }

    static void badRequest(BufferedWriter out) throws IOException {
        String msg = "<HTML><HEAD>\n"
                + "<TITLE>400 Bad Request</TITLE>\n "
                + "</HEAD><BODY>\n"
                + "<H1>Bad Request</H1>\n"
                + "</BODY></HTML>";
        String res = "HTTP/1.1 400 Bad Request\n"
                + "Server: HTTP server/0.1\n"
                + "Date: " + format.format(new java.util.Date ())
                + "\n"
                + "Content-type: text/html; charset = UTF-8\n"
                + "Content-Length: " + msg.length() + "\n" + msg;
        out.write(res);
        out.flush();
    }

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(80)) {
            while (true) {
                Socket socket = server.accept ();
                Map<String, String> road = new HashMap<>();
                road.put("Hello", "Hello I'm bot");
                road.put("Buy", "Buy!!!");
                try (BufferedWriter out =
                             new BufferedWriter(
                                     new OutputStreamWriter(socket.getOutputStream()));
                     BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))
                ) {
                    String str;
                    if (!(str = in.readLine()).isEmpty()) {
                        try {
                            str = str.split(" ")[ 1 ].split("=")[ 1 ];
                            String req = road.get(str);
                            if (req == null) {
                                badRequest(out);
                            } else {
                                transferMsg(req, out);
                                out.flush();
                            }
                        } catch (IndexOutOfBoundsException e) {
                            badRequest(out);
                        }

                    }

                }
            }
        } catch (IOException e) {
            e.printStackTrace ();
        }
    }
}
