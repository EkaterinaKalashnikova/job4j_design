package ru.job4j.serialization.json;

public class Kontact {
    private final String phone;

    public Kontact( String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Contact{"
                + "phone='" + phone + '\''
                + '}';
    }
}
