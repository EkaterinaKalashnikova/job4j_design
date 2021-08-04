package ru.job4j.phone.srp;

public class IPhone implements Phone {
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
