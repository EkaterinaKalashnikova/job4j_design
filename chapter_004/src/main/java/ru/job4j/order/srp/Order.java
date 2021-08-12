package ru.job4j.order.srp;

import ru.job4j.lsp.order.Item;

public interface Order {
    void process(Order order);

    boolean isValid();

    private boolean save() {
        return false;
    }

    String getCustomerEmail();

    String getCustomerName();

    private void sendConfirmationEmail() {
    }

    Item[] getItems();

   Item getId();
}
