package ru.job4j.dip.diporderssolution;

import ru.job4j.order.srp.Order;

public interface MailSender {
    void sendConfirmationEmail(Order order);
}
