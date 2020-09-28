package ru.job4j.io;

import java.io.File;
import java.util.Objects;

public class DirUno {
    public static void main(String[] args) {
       // File file = new File("c:\\projects\\job4j_design");
       // File file = new File(".src\\main\\java\\ru.job4j.io\\Config");
        File file = new File(".text_with_comment.properties");
        System.out.println("File name: " + file.getName());
        System.out.println("Parent folder: " + file.getParent());
        System.out.println("Путь: " + file.getPath());
        System.out.println("Полный путь: " + file.getAbsolutePath());
        System.out.println("Родительский каталог: " + file.getParent());
        System.out.println("Последняя модификация файла : " + file.lastModified());
        System.out.println("Размер файла : " + file.length() + " bytes");

        if (!file.exists()) {
            throw new IllegalArgumentException(String.format("Not exist %s", file.getAbsoluteFile()));
        }
        if (!file.isDirectory()) {
            throw new IllegalArgumentException(String.format("Not directory %s", file.getAbsoluteFile()));
        }
        System.out.println(String.format("size : %s", file.getTotalSpace()));
        for (File subfile : Objects.requireNonNull(file.listFiles())) {
            System.out.println(String.format("size : %s ", subfile.getName()));
        }
    }
}
