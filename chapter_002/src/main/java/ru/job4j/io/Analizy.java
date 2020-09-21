package ru.job4j.io;

import java.io.*;

public class Analizy {
    public static void main(String[] args) {
        try (PrintWriter out = new PrintWriter(new FileOutputStream("unavailable.csv"))) {
            out.println("15:01:30;15:02:32");
            out.println("15:10:30;23:12:32");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void unavailable(String source, String target) {
        try (BufferedReader reader = new BufferedReader(new FileReader(source));
             BufferedWriter writer = new BufferedWriter(new FileWriter(target))) {
            String start = "";
            String line;
            String end = null;
            boolean flag = false;
            while ((line = reader.readLine()) != null) {
                //  System.out.println(line);
                if (line.startsWith("400") | line.startsWith("500")) {
                    writer.write("%s; %x", line.lastIndexOf(start), Integer.parseInt("\n"));
                    flag = true;
                } else if (line.startsWith("300") | line.startsWith("200")) {
                    assert false;
                    writer.write("%s; %x", Integer.parseInt(start), line.lastIndexOf(end));
                    flag = false;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
