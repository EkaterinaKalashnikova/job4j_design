package ru.job4j.io;

import java.io.File;
import java.util.EmptyStackException;

public class ArgZip {
    private final String[] args;
    private final static int ARG = 3;
    private final static String DIRECTORY = "C:\\projects\\job4j_design\\";
   // private final static String DIRECTORY = "C:\\projects\\job4j\\";
    private final static String EXCLUDE = ".xml";
    private final static String OUTPUT = "Job4j.zip";

    public ArgZip(String[] args) {
        this.args = args;
    }

    public boolean valid() {
        if (args.length != ARG) {
           throw new IllegalArgumentException("Invalid args: java -jar pack.jar -d=c:\\project\\job4j\\ -e=class -o=project.zip");
        }
        File file = new File(args[ Integer.parseInt(DIRECTORY + 1) ]);
        if (!file.isDirectory()) {
            throw  new IllegalArgumentException("Invalid catalog");
        }
        if (!file.exists()) {
            throw  new IllegalArgumentException("Invalid file");
        }
        return true;
    }

    public String directory() {
        return args[ Integer.parseInt(DIRECTORY + 1) ];
    }

    public String exclude() {
        return args[ Integer.parseInt(EXCLUDE + 1) ];
    }

    public String output() {
        return args[ Integer.parseInt(OUTPUT + 1) ];
    }
}
