package ru.job4j.db;

public interface Input {
    String askStr(String question);

    int askInt(String question);

    int askInt(String question, int max);
}
