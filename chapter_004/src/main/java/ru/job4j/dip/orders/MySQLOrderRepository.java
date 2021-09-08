package ru.job4j.dip.orders;

import ru.job4j.order.srp.MySqlConnection;
import ru.job4j.order.srp.Order;

public class MySQLOrderRepository {
    public boolean save(Order order) {
        MySqlConnection connection = new MySqlConnection("database.url");
        // сохраняем заказ в базу данных

        return true;
    }
}
