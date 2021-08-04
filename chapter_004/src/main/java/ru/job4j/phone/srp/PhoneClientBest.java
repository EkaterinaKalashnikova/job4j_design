package ru.job4j.phone.srp;

public class PhoneClientBest {
    public static void main(String[] args) {
        Phone phone = new PhoneAnd(new ConnectionManagerImplementation(), new DateManagerImplementation());
        phone.dial("012345");
        phone.disconnect();
        phone.send("message");
        phone.receive();
    }
}

