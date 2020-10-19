package ru.job4j.io;

import java.io.File;

public class ArgZip {
    private final String[] args;
    private final static int ARG = 3;
    private final static String DIRECTORY = "c:\\projects\\job4j_design\\";
    private final static String EXCLUDE = ".xml";
    private final static String OUTPUT = "job4j_design.zip";

    public ArgZip(String[] args) {
        this.args = args;
    }

    public void valid() {
        if (args.length != ARG) {
           throw new IllegalArgumentException("Invalid args: java -jar pack.jar -d=c:\\projects\\job4j_design\\ -e=class -o=projects.zip");
        }
        File file = new File(args[ Integer.parseInt(DIRECTORY) ]);
        if (!file.isDirectory()) {
            throw  new IllegalArgumentException("Invalid catalog");
        }
        if (!file.exists()) {
            throw  new IllegalArgumentException("Invalid file");
        }
    }

    public String directory() {
        return args[ Integer.parseInt(DIRECTORY) ];
    }

    public String exclude() {
        return args[ Integer.parseInt(EXCLUDE) ];
    }

    public String output() {
        return args[ Integer.parseInt(OUTPUT) ];
    }
}
