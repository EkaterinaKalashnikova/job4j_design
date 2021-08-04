package ru.job4j.order.srp;

public class MySQLOrderRepository {
    public boolean save(Order order) {
        MySqlConnection connection = new MySqlConnection();
        // сохраняем заказ в базу данных
        return true;
    }
}
