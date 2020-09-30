package ru.job4j.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;

public class Config {
    private final String path;
    private final Map<String, String> values;
    private String[] keys;

    public Config(final String path) {
        this.path = path;
        values = new HashMap<String, String>();
    }

    public static void main(String[] args) {
        System.out.println(new Config("./data/pair_without_comment.properties"));
        System.out.println(new Config("./data/text_with_comment.properties"));
    }

    public void load() {
        int index = 0;
        try (BufferedReader rd = new BufferedReader(new FileReader(path))) {
              rd.lines()
                .filter(n -> !n.isEmpty() && !n.startsWith("#"))
                .map(line -> line.split("="))
                .filter(keys -> keys.length == 2)
                .forEach(keys -> values.put(keys[0], keys[1]));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String value(String key) {
        return values.get(key);
        // throw new UnsupportedOperationException("Don't impl this method yet!");
    }

    @Override
    public String toString() {
        StringJoiner out = new StringJoiner(System.lineSeparator());
        try (BufferedReader read = new BufferedReader(new FileReader(this.path))) {
            read.lines().forEach(out::add);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return out.toString();
    }
}
