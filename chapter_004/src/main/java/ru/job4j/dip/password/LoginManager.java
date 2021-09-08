package ru.job4j.dip.password;

//high level class
public class LoginManager {
    SimpleLogin simpleLogin = new SimpleLogin();

    public void login(User user) {
        simpleLogin.autenthificate(user);
    }
}
