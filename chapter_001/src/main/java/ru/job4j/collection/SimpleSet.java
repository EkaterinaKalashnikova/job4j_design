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
     */
    public void add(E value) {
        if (!contains(value)) {
            array.add(value);
        }
    }

    /**
     * Метод, проверяющий содержится ли данное значение в контейнере
     * с другими элементами
     * @param value добавляемый элемент
     * @return
     */
    private boolean contains(E value) {
            boolean flag = false;
            for (E el : array) {
                if (Objects.equals(el, value)) {
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
