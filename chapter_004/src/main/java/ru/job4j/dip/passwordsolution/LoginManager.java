package ru.job4j.dip.passwordsolution;

import ru.job4j.dip.password.SimpleLogin;
import ru.job4j.dip.password.User;

//high level class
public class LoginManager {
   Authentificator authentificator;

    public LoginManager(Authentificator authentificator) {
        this.authentificator = authentificator;
    }

    public void login(User user) {
        authentificator.autenthificate(user);
    }
}
