package ru.job4j.ocp.logger;

public class SmtpMailer {
    private String logger;

    public SmtpMailer(String logger) {
        this.logger = logger;
    }
//
//    public void sendMessage(String message) {
//        // отсылка сообщения
//        Logger logger = new Logger();
//        logger.log(String.format("Отправлено '{0}'", message));
//    }

    public void sendMessage(String message) {
        // отсылка сообщения
        DatabaseLogger databaseLogger = new DatabaseLogger();
        databaseLogger.log(String.format("Отправлено '{0}'", message));
    }
}
