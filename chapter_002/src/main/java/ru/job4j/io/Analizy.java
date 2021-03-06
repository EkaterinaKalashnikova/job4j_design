package ru.job4j.io;

import java.io.*;
import java.util.Arrays;

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
            String begin = "";
            String line;
            String end = "";
            boolean isActiv = true;
            while ((line = reader.readLine()) != null) {
               if ((line.startsWith("400") || line.startsWith("500")) && isActiv) {
                    begin = line.split(" ")[1];
                    isActiv = false;
                } else if ((line.startsWith("200") || line.startsWith("300")) && !isActiv) {
                   end = line.split(" ")[1];
                   writer.write(begin + " ; " + end + System.lineSeparator());
                   isActiv = true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
