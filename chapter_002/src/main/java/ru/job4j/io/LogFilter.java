package ru.job4j.io;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static java.lang.String.format;

public class LogFilter {
    public static List<String> filter(String file) {
        List<String> line = new ArrayList<>();
        try (BufferedReader in = new BufferedReader(new FileReader(file))) {
               line = in.lines()
               .filter(s -> s.contains("404"))
               .collect(Collectors.toList());
           line.forEach(System.out::println);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return line;
    }

    public static void save(List<String> log, String file) {
        try (PrintWriter out = new PrintWriter(
                new BufferedOutputStream(
                        new FileOutputStream(file)
                ))) {
            log.forEach(n -> {
                out.write(n + System.lineSeparator());
            });
           } catch (IOException e) {
            e.printStackTrace();
        }
    }
        public static void main(String[] args) {
        List<String> log = filter("log.txt");
        System.out.println(log);
         save(log, "404.txt");
    }
}
