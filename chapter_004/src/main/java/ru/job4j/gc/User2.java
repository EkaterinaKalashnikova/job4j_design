package ru.job4j.gc;

public class User2 {
    private int id;
    private String name;
    //private String address;

    public User2(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.printf("Removed %d %s%n ", id, name);
    }
}
