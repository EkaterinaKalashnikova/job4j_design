package ru.job4j.order.srp;

public class ConfirmationEmailSender {
    public void sendConfirmationEmail(Order order) {
        String name = order.getCustomerName();
        String email = order.getCustomerEmail();
        // Шлем письмо клиенту
    }
}
