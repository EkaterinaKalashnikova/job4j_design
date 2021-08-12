package ru.job4j.lsp.order;

import ru.job4j.order.srp.Order;
import ru.job4j.order.srp.OrderProcessor;

public class OrderStockValidator extends OrderProcessor {
    public boolean isValid(Order order) {
        for (Item item : order.getItems()) {
            if (!item.isInStock()) {
                return false;
            }
        }
        return true;
    }
}
