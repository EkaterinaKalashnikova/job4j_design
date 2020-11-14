package ru.job4j.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UsageLog {
    private static final Logger LOG = LoggerFactory.getLogger(UsageLog4j.class.getName());

    public static void main(String[] args) {
        String name = "Petr Arsentev";
        int age = 33;
        double size = 43.5;
        float line = 5.56f;
        byte step = 2;
        short jump = 12;
        long head = 57;
        boolean mind = true;
        char unique = 's';
        LOG.debug("User info name : {}, age : {}, size : {}, line : {}, step : {}, jump : {}, head : {}, mind : {}, unique : {}",
                name, age, size, line, step, jump, head, mind, unique);
    }
}
