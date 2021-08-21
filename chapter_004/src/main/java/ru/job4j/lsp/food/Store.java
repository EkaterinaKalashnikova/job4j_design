package ru.job4j.lsp.food;

import java.util.List;

public interface Store {

    boolean receiver(Food food);

    void add();

    List<Food> liquidation();
}
