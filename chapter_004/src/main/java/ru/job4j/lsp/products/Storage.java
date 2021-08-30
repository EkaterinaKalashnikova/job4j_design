package ru.job4j.lsp.products;

import java.util.List;

public interface Storage {
    //добавление продукции
    void add(Food food);

    //получение всех продуктов
   List<Food> getFoods();

   //получить подходящий продукт
    boolean isAppropriate(Food food);
}
