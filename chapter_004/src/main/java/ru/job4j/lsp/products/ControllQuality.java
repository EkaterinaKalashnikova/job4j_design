package ru.job4j.lsp.products;

import java.util.List;

public class ControllQuality {
    private List<Storage> listStores;

    public ControllQuality(List<Storage> listStores) {
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
}
