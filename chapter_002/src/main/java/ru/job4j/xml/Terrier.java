package ru.job4j.xml;

public class Terrier {
    private final String name;

    public Terrier(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Terrier{"
                + "name='" + name + '\''
                + '}';
    }
}
