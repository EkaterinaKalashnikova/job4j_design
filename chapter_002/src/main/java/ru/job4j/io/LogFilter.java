package ru.job4j.io;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LogFilter {
    public static List<String> filter(String file) {
        List<String> line = new ArrayList<>();
        try (BufferedReader in = new BufferedReader(new FileReader("log.txt"))) {
               line = in.lines()
               .skip(Long.parseLong("404"))
               .limit(1)
               .collect(Collectors.toList());
        line.forEach(System.out::println);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return line;
    }
        public static void main(String[] args) {
        List<String> log = filter("log.txt");
        System.out.println(log);
    }
}
