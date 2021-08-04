package ru.job4j.order.srp;

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
}
