package ru.job4j.lsp.products;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Trash implements Storage {
     List<Food> foods = new ArrayList<>();

    @Override
    public void add(Food food) {
      //  Если срок годности вышел. Отправить продукт в мусорку.
        if (Calendar.getInstance().getTimeInMillis() - food.getExpiryDate().getTimeInMillis() > 0) {
            foods.add(food);
        }
    }

    @Override
    public List<Food> getFoods() {
        return foods;
    }
}
