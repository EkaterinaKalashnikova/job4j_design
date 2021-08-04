package ru.job4j.phone.srp;

import ru.job4j.phone.srp.IPhone;

public class PhoneClient {
    public static void main(String[] args) {
        IPhone phone = new IPhone();
        phone.dial("012345");
        phone.disconnect();
        phone.send("message");
        phone.receive();
    }
}
