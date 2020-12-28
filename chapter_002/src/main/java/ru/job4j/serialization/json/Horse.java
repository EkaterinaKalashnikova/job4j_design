package ru.job4j.serialization.json;

import java.util.Arrays;

public class Don {
    private final boolean sex;
    private final int age;
    private final Horse horse;
    private final String[] suit;

    public Don(boolean sex, int age, Horse horse, String... suit) {
        this.sex = sex;
        this.age = age;
        this.horse = horse;
        this.suit = suit;
    }

    @Override
    public String toString() {
        return "Don{"
                + "sex=" + sex
                + ", age=" + age
                + ", horse=" + horse
                + ", suit=" + Arrays.toString(suit)
                + '}';
    }
}
