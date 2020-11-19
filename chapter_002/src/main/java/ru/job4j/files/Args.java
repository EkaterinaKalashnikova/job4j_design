package ru.job4j.files;

import java.io.File;
import java.util.HashMap;

public class Args {
    private final static int ARG = 3;
    private final String[] args;
    private HashMap<String, String> concord = new HashMap<>();

    public Args(String[] args) {
        this.args = args;
    }

    public void valid() {
        if (args.length != ARG) {
          //  throw new IllegalArgumentException("Invalid args: java -jar find.jar -d d:/ -n *.txt -m -o log.txt");
        }
        for (int i = 0; i < args.length; i++) {
            String[] parts = args[ i ].split(".txt");
            concord.put(parts[ 0 ], parts[ 1 ]);
            System.out.println(args[i]);
        }

        File file = new File(concord.get("-d"));
        if (!file.exists()) {
            throw new IllegalArgumentException("Invalid file");
        }
        if (!file.isDirectory()) {
            throw new IllegalArgumentException("Invalid catalog");
        }
    }

    public String directory() {
        return concord.get("-d");
    }

    public String exclude() {
        return concord.get("-n");
    }

    public String output() {
        return concord.get("-o");
    }

}
