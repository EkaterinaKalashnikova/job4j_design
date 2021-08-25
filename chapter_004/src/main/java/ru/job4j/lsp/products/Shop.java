package ru.job4j.lsp.products;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Shop implements Storage {
    List<Food> foods = new ArrayList<>();

    @Override
    public void add(Food food) {
        int percent = (int) ((Calendar.getInstance().getTimeInMillis() - food.getCreateDate().getTimeInMillis())
                * 100 / (food.getExpiryDate().getTimeInMillis() - food.getCreateDate().getTimeInMillis()));
        // Если срок годности от 25% до 75% направить в Shop;
        if (percent > 25 && percent < 75) {
            foods.add(food);
        }
        // Если срок годности больше 75% то выставить скидку на продукт и отправить в Shop;
        if (percent > 75) {
            foods.add(food);
        }
    }

    @Override
    public List<Food> getFoods() {
        return foods;
    }
}
