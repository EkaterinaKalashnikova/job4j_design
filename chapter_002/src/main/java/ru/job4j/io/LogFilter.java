package ru.job4j.io;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.CharBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

public class LogFilter {
    public static List<String> filter(String file) {
        List<String> line = new ArrayList<>();
        try (BufferedReader in = new BufferedReader(new FileReader("C:\\projects\\log.txt"))) {
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

    public static void save(List<String> log, String file) {
        try (BufferedReader in = new BufferedReader(new FileReader("C:\\projects\\log.txt"))) {
            long i1 = 1;
            for (long i = 1; i <= i1; i++) {
                String s = Long.toString(i);
                System.out.println(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
        public static void main(String[] args) {
        List<String> log = filter("C:\\projects\\log.txt");
        System.out.println(log);
         save(log, "404.txt");
    }
}
