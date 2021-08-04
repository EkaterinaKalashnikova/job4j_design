package ru.job4j.phone.srp;

public class DateManagerImplementation implements DataManager {
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
