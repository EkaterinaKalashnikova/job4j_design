package ru.job4j.io;

import java.io.File;
import java.util.HashMap;

public class ArgZip {
    private final String[] args;
    private final static int ARG = 3;
    private HashMap<String, String> pairs = new HashMap<>();

    public ArgZip(String[] args) {
        this.args = args;
    }

    public void valid() {
        if (args.length != ARG) {
           throw new IllegalArgumentException("Invalid args: -d=d:\\resume\\ -e=class -o=projects.zip");
        }
        for (int i = 0; i < args.length; i++) {
            String[] parts = args[i].split("=");
            pairs.put(parts[0], parts[1]);
        }

        File file = new File(pairs.get("-d"));
        if (!file.exists()) {
            throw  new IllegalArgumentException("Invalid file");
        }
        if (!file.isDirectory()) {
            throw  new IllegalArgumentException("Invalid catalog");
        }
    }

    public String directory() {
        return pairs.get("-d");
    }

    public String exclude() {
        return pairs.get("-e");
    }

    public String output() {
        return pairs.get("-o");
    }
}
