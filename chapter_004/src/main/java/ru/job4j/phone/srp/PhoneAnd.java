package ru.job4j.phone.srp;

public class PhoneAnd implements ConnectionManager, DataManager, Phone {
    private ConnectionManager connectionManager;
    private DataManager dataManager;

    public PhoneAnd(ConnectionManager connectionManager, DataManager dataManager) {
        this.connectionManager = connectionManager;
        this.dataManager = dataManager;
    }

    @Override
    public void dial(String phoneNumber) {
        System.out.println("connection established");
    }

    @Override
    public void disconnect() {
        System.out.println("disconnected");
    }

    @Override
    public void send(String message) {
        System.out.println("message sent successfully");
    }

    @Override
    public int receive() {
        System.out.println("data received successfully");
        return 0;
    }
}
