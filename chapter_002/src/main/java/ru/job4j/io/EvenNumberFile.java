package ru.job4j.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class EvenNumberFile {
    public static void main(String[] args) {
       try (FileInputStream in = new FileInputStream("C:\\projects\\even.txt")) {
           StringBuilder text = new StringBuilder();
           int read;
           while ((read = in.read()) != -1) {
               text.append((char) read);
           }
           int num = 10;
           String[] lines = text.toString().split(System.lineSeparator());
           for (int i = 0; i < lines.length; i++) {
               int line1 = Integer.parseInt("line");
               if (line1 % 2 == 0) {
                   boolean rsl = true;
               }
               System.out.println(line1);
           }
       } catch (IOException e) {
           e.printStackTrace();
       }
    }
}
