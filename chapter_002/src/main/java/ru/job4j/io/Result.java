package ru.job4j.io;

import java.io.FileOutputStream;

public class Result {
    public static void main(String[] args) {
        try (FileOutputStream out = new FileOutputStream("C:\\projects\\result.txt")) {
            out.write("Hello, world!".getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
