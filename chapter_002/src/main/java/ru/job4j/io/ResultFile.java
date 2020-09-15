package ru.job4j.io;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ResultFile {
    public static void main(String[] args) {
        try (FileOutputStream out = new FileOutputStream("result.txt")) {
            for (int i = 1; i < 10; i++) {
                for (int j = 1; j < 10; j++) {
                    String s = j + "*" + i + "=" + (i * j)  + "\t\t";
                    System.out.println(s);
                }
                System.out.println();
                out.write("Hello, world!".getBytes());
            }
            out.flush();
            } catch (Exception e) {
                e.printStackTrace();
        }
    }
}

