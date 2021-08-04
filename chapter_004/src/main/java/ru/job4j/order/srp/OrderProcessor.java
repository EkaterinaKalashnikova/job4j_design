package ru.job4j.order.srp;

public class OrderProcessor {

    public void process(Order order) {
        if (order.isValid() && save(order)) {
            sendConfirmationEmail(order);
            // заказ верно сформирован
        }
    }

    private boolean save(Order order) {
        MySqlConnection connection = new MySqlConnection();
        // сохраняем заказ в базу данных

        return true;
    }

    private void sendConfirmationEmail(Order order) {
        String name = order.getCustomerName();
        String email = order.getCustomerEmail();
        // Шлем письмо клиенту
    }
}
