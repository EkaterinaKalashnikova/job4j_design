package ru.job4j.order.srp;

public class ProcessorOrder {
    //заказ верно сформирован
    public void process(Order order) {
        MySQLOrderRepository repository = new MySQLOrderRepository();
        ConfirmationEmailSender mailSender = new ConfirmationEmailSender();
        if (order.isValid() && repository.save(order)) {
            mailSender.sendConfirmationEmail(order);
        }
    }
}
