package ru.job4j.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class EvenNumberFile {
    public static void main(String[] args) {
       try (FileInputStream in = new FileInputStream("even.txt")) {
           StringBuilder text = new StringBuilder();
           int read;
           while ((read = in.read()) != -1) {
               text.append((char) read);
           }
           int num = 10;
           boolean rsl = num % 2 == 0;
           System.out.println(rsl);
       } catch (IOException e) {
           e.printStackTrace();
       }
    }
}
