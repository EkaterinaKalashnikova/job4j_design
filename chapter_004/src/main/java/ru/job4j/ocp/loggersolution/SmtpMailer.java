package ru.job4j.ocp.loggersolution;

public class SmtpMailer {
    private String logger;

    public SmtpMailer(String logger) {
        this.logger = logger;
    }

    public void sendMessage(String message) {
        Logger logger = new Logger();
        logger.log(String.format("Отправлено '{0}'", message));
        DatabaseLogger logger1 = new DatabaseLogger();
        logger1.log(String.format("Отправлено '{0}'", message));
    }
}
