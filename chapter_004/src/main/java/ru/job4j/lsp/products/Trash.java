package ru.job4j.lsp.products;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Trash implements Storage {
    List<Food> foods = new ArrayList<>();

    @Override
    public void add(Food food) {
        if (isAppropriate(food)) {
            foods.add(food);
        }
    }

    @Override
    public List<Food> getFoods() {
        return foods;
    }

    @Override
    public boolean isAppropriate(Food food) {
        //  Если срок годности вышел. Отправить продукт в мусорку.
        return Calendar.getInstance().getTimeInMillis() - food.getExpiryDate().getTimeInMillis() > 0;
    }
}
