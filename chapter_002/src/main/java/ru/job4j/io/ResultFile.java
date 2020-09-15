package ru.job4j.io;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ResultFile {
    public static void main(String[] args) {
        try (FileOutputStream out = new FileOutputStream("result.txt")) {
            for (int i = 1; i < 10; i++) {
                for (int j = 2; j < 10; j++) {
                    out.write(Integer.parseInt(j + "*" + i + "=" + (i * j)  + "\t\t"));
                }
                out.write("Hello, world!".getBytes());
            }
            } catch (Exception e) {
                e.printStackTrace();
        }
    }
}

