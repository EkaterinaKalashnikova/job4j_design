package ru.job4j.phone.srp;

public interface ConnectionManager {
    void dial(String phoneNumber);
    void disconnect();
}
