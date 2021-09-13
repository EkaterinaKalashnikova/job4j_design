package ru.job4j.productsrefactoring;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ControlQuality {
    private List<Storage> listStores;

    public ControlQuality(List<Storage> listStores) {
        this.listStores = listStores;
    }

    public void distribution(Food... foods) {
        for (Food food : foods) {
            for (int i = 0; i < listStores.size(); i++) {
                listStores.get(i).add(food);
            }
        }
        //  Arrays.asList(foods).forEach(food -> listStores.forEach(storage -> storage.add(food)));
        // storage == listStores.get(i)
    }

    public void resort() {
        List<Food> allProducts = new ArrayList<>();
        for (Storage storage : listStores) {
            allProducts.addAll(storage.getFoods());
            storage.clear();
        }
       allProducts.forEach(food -> distribution(food));
    }

//    public void distribution(List<Food> foodList) {
//        for (Food f : foodList) {
//            distribution(f);
//        }
//    }
}
