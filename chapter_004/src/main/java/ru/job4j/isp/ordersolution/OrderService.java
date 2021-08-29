package ru.job4j.isp.ordersolution;

import ru.job4j.isp.order.Order;

public interface OrderService {
    Order createOrder();

    Order amendOrder();

    boolean cancelOrder(int orderId);

    Order submit(int orderId);

    Order getOrder(int orderId);

}
