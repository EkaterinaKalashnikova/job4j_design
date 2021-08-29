package ru.job4j.isp.order;

public interface OrderService {
    Order createOrder();

    Order amendOrder();

    boolean cancelOrder(int orderId);

    Order submit(int orderId);

    Order getOrder(int orderId);

    boolean processOrder(int orderId);
}
