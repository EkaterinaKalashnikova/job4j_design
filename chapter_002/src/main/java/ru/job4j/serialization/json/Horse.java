package ru.job4j.serialization.json;

import java.util.Arrays;

public class Horse {
    private final boolean sex;
    private final int age;
    private final Horses horses;
    private final String[] suites;

    public Horse( boolean sex, int age, Horses horses, String... suites) {
        this.sex = sex;
        this.age = age;
        this.horses = horses;
        this.suites = suites;
    }

    @Override
    public String toString() {
        return "Horse{"
                + "sex=" + sex
                + ", age=" + age
                + ", horses=" + horses
                + ", suites=" + Arrays.toString(suites)
                + '}';
    }
}
