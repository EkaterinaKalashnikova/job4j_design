package ru.job4j.dip.diporderssolution;

import ru.job4j.order.srp.Order;

public interface OrderRepository {
    boolean save(Order order);
}
