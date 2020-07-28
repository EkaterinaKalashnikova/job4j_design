package ru.job4j.collection;

import java.util.Iterator;
import java.util.Objects;

public class SimpleSet<E> implements Iterable<E> {

    /**
     * Массив для хранения элементов в контейнере
     */
    private SimpleArray<E> array = new SimpleArray<E>();

    /**
     * Метод добавления элементов в контейнер
     * @param value добавляемый элемент
     * @return false, если такой элемент есть
     * или true, если такого нет в коллекции и добавляем
     */
    public boolean add(E value) {
        boolean flag = false;
        for (E el : array) {
            if (Objects.equals(el, value)) {
                array.add(value);
                return true;
            }
        }
        return flag;
    }

    /**
     * Метод возвращает размер контейнера
     * @return
     */
    public int size() {
        return this.array.size();
    }

    @Override
    public Iterator<E> iterator() {
        return array.iterator();
    }
}
