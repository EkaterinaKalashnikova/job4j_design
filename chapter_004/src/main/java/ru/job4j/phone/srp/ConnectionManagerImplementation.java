package ru.job4j.phone.srp;

public class ConnectionManagerImplementation implements ConnectionManager {
    @Override
    public void dial(String phoneNumber) {
        System.out.println("connection established");
    }

    @Override
    public void disconnect() {
        System.out.println("disconnected");
    }
}
