package ru.job4j.db;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

public class MemTracker {
    /**
     * Массив для хранение заявок.
     */
    private final List<Item> items = new ArrayList<>(100);

    /**
     * Указатель ячейки для новой заявки.
     */
    private static final Random RM = new Random();
    private int index;

    /**
     * Метод реализаущий добавление заявки в хранилище
     *
     * @param item новая заявка
     * @return item;
     */
    public Item add(Item item) {
        item.setId(this.generateId());
        items.add(item); // вставка в коллекцию.
        return item;
    }

    /**
     * Метод генерирует уникальный ключ для заявки.
     * Так как у заявки нет уникальности полей, имени и описание. Для идентификации нам нужен уникальный ключ.
     *
     * @return Уникальный ключ.
     */
    private String generateId() {
        Random rm = new Random(); // Реализовать метод генерации.
        return String.valueOf(rm.nextLong() + System.currentTimeMillis());
    }

    /**
     * Метод редактирования заявок, изменение ячейки в массиве
     *
     * @param id, item
     * @return если успешно, то вернуть true
     */
    public boolean replace(String id, Item item) {
        item.setId(id);
        for (int i  = 0; i < items.size(); i++) {
            if (id.equals(items.get(i).getId())) {
                items.set(i, item);
                return true;
            }
        }
        return false;
    }

    /**
     * Метод удаление заявок
     *
     * @return если успешно, то вернуть true
     */
    public boolean delete(String id) {
        for (int i = 0; i < items.size(); i++) {
            if (id.equals(this.items.get(i).getId())) {
                items.remove(i);
                return true;
            }
        }
        return false;
    }

    /**
     * Метод возврата копии массива без null элементов
     *
     * @return копию массива без null элементов
     */
    public List<Item> findAll() {
       //  List<Item> items1 = new ArrayList<>();
         List<Item> items = new ArrayList<>();
         items.addAll(0, items);
        return this.items;
    }


    /**
     * Метод сравнения заявки по имени
     *
     * @param key имя заявки
     * @return массив имен заявок
     */
    public List<Item> findByName(String key) {
        List<Item> res = new ArrayList<>(); //заполняем массив указанными элементами
        for (Item item : items) { // перебираем по указателю
            if (Objects.equals(key, item.getName())) { //сравниваем все элементы массива с key
                res.add(item); //складываем совпавшие элементы
            }
        }
        return res;
    }

    /**
     * Метод сравнения заявки по ключу
     *
     * @param id ключ
     * @return item, если не найдена null
     */
    public Item findById(String id) {
        Item result = null;
        for (Item item : items) { //проверяем каждую
            if (Objects.equals(id, item.getId())) { //сверяем одинаковые номера
                result = item; //выводим совпавшие
                break;
            }
        }
        return result;
    }
}
