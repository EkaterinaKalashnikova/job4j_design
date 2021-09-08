package ru.job4j.dip.diporderssolution;

import ru.job4j.order.srp.Order;

public class ConfirmationEmailSender implements MailSender {
    @Override
    public void sendConfirmationEmail(Order order) {
        String name = order.getCustomerName();
        String email = order.getCustomerEmail();

        // Шлем письмо клиенту
    }
}
