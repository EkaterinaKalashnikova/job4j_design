package ru.job4j.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class EvenNumberFile {
    public static void main(String[] args) {
       try (FileInputStream in = new FileInputStream("C:\\projects.even.txt")) {
           StringBuilder text = new StringBuilder();
           int read;
           while ((read = in.read()) != -1) {
               text.append((char) read);
           }
           int num = 10;
           String[] lines = text.toString().split(System.lineSeparator());
           for (String line : lines) {
               int lineInt = Integer.parseInt("line");
               if (lineInt % 2 == 0) {
                   boolean rsl = true;
               }
               System.out.println(lineInt);
           }
       } catch (IOException e) {
           e.printStackTrace();
       }
    }
}
