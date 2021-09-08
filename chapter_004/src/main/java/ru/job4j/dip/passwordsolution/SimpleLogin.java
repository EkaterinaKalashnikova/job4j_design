package ru.job4j.dip.passwordsolution;

import ru.job4j.dip.password.User;

//low level class
public class SimpleLogin implements Authentificator {

    public boolean autenthificate(User user) {
        //logic - database
        return true;
    }
}
