package ru.job4j.lsp.products;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Warehouse implements Storage {
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
        // 01.01.21 - 01.11.21 = 10 (100%)
        long percent1 = (food.getExpiryDate().getTimeInMillis() - food.getCreateDate().getTimeInMillis());
        // 01.08.21 = ?
        long percent2 = (Calendar.getInstance().getTimeInMillis() - food.getCreateDate().getTimeInMillis());
        // 1000 days = 100%
        // 250 days = ?
        int percent = (int) ((Calendar.getInstance().getTimeInMillis() - food.getCreateDate().getTimeInMillis())
                * 100 / (food.getExpiryDate().getTimeInMillis() - food.getCreateDate().getTimeInMillis()));
        //Если срок годности израсходован меньше чем на 25% направить в Warehouse
        if (percent < 25) {
            return true;
        } else return false;
    }
}
