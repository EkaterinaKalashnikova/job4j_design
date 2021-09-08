package ru.job4j.dip.passwordsolution;

import ru.job4j.dip.password.User;

public interface Authentificator {
    boolean autenthificate(User user);
}
