package ru.job4j.files;

import java.io.File;

public class Args  {
    private final static int ARG = 7;
    private final static int DIRECTORY_KEY = 0;
    private final static int TEMPLATE_KEY = 2; //шаблоны по ключу
    private final static int TYPE_KEY = 4; //поиск значения по ключу
    private final static int ARG_PATH_KEY = 5; //пути аргументов
    private final String[] args;

    public Args(String[] args) {
        this.args = args;
    }

    public void valid() {
        if (args.length != ARG) {
            throw new IllegalArgumentException("Invalid args: java -jar find.jar -d d:/ -n *.txt -m -o log.txt");
        }
        //проверяем заданный набор символов из одного промежутка
        if (!args[ DIRECTORY_KEY ].startsWith("-")
                || !args[ TEMPLATE_KEY ].startsWith("-")
                || !args[ TYPE_KEY ].startsWith("-")
                || !args[ ARG_PATH_KEY ].startsWith("-")) {
            throw new IllegalArgumentException("Invalid args with -");
        }
        //проверяем заданные параметры в строках
        if (!args[ DIRECTORY_KEY ].equalsIgnoreCase("-d")
                || !args[ TEMPLATE_KEY ].equalsIgnoreCase("-n")
                || !args[ ARG_PATH_KEY ].equalsIgnoreCase("-o")) {
            throw new IllegalArgumentException("Invalid args");
        }

        //
       File directory = new File(args[1]);
        if (!directory.exists()) {
            throw new IllegalArgumentException("Invalid catalog");
        }
    }

    public String directory() {
        return this.args[1];
    }

    public String typeSearch() {
        return this.args[TYPE_KEY];
    }

    public String pattern() {
        return this.args[TEMPLATE_KEY];
    }

    public String output() {
        return this.args[ARG_PATH_KEY];
    }

    public String logName() {
        return this.args[6];
    }

    public String valKey() {
        return this.args[3];
    }
}
