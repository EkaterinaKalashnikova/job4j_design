package ru.job4j.log;

//import java.util.logging.LogManager;
//import java.util.logging.Logger;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class UsageLog4j {
    private static final Logger LOG = LogManager.getLogger(UsageLog4j.class.getName());


    public static void main(String[] args) {
        LOG.trace("trace message");
        LOG.debug("debug message");
        LOG.info("info message");
        LOG.warn("warn message");
        LOG.error("error message");
        BasicConfigurator.configure();
    }

    private static class BasicConfigurator {
        public static void configure() {
        }
    }
}
