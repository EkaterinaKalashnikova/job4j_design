package ru.job4j.dip.orders;

import ru.job4j.order.srp.ConfirmationEmailSender;
import ru.job4j.order.srp.MySQLOrderRepository;
import ru.job4j.order.srp.Order;

public class OrderProcessor {
    public void process(Order order) {

        MySQLOrderRepository repository = new MySQLOrderRepository();
        ConfirmationEmailSender mailSender = new ConfirmationEmailSender();

        if (order.isValid() && repository.save(order)) {
            mailSender.sendConfirmationEmail(order);
        }
    }
}
