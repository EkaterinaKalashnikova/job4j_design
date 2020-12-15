package ru.job4j.files;

import java.io.File;

public class Args {
    private final static int ARG = 7;
    private final static int DIRECTORY_KEY = 1;
    private final static int TEMPLATE_KEY= 2; //шаблоны по ключу
    private final static int SEARCH_KEY = 4; //поиск значения по ключу
    private final static int ARG_PATH_KEY = 5; //пути аргументов
    private final String[] args;
    //private HashMap<String, String> concord = new HashMap<>();

    public Args(String[] args) {
        this.args = args;
    }

    public void valid() {
        if (args.length != ARG) {
            throw new IllegalArgumentException("Invalid args: java -jar find.jar -d d:/ -n *.txt -m -o log.txt");
        }
        File directory = null;
        //проверяем заданный набор символов из одного промежутка
        if (!args[ DIRECTORY_KEY ].startsWith("-")
                || args[ TEMPLATE_KEY ].startsWith("-")
                || args[ SEARCH_KEY ].startsWith("-")
                || args[ ARG_PATH_KEY ].startsWith("-")) {
            throw new IllegalArgumentException("Invalid args with -");
        }
        //
        if (!args[ DIRECTORY_KEY ].equalsIgnoreCase("-d")
                || args[ TEMPLATE_KEY ].equalsIgnoreCase("-n")
                || args[ ARG_PATH_KEY ].equalsIgnoreCase("-o")) {
            throw new IllegalArgumentException("Invalid args");
        }

        directory = new File(args[ DIRECTORY_KEY ]);
        if (!directory.exists()) {
            throw new IllegalArgumentException("Invalid catalog");
        }
    }

    public String directory() {
        return args[DIRECTORY_KEY];
    }

    public String pattern() {
        return args[TEMPLATE_KEY];
    }

    public String output() {
        return args[ARG_PATH_KEY];
    }
}
