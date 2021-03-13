package ru.job4j.db;

public interface UserAction {
    String name();

    boolean execute(Input input, MemTracker tracker);
}
