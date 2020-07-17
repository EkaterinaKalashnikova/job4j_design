package ru.job4j.collection;

import java.util.Iterator;
import java.util.Objects;

public class SimpleArray<T> implements Iterable<T>  {

    /**
     * Поле массива для хранения  объектов
     * Поле для значения текущей ячейки массива
     */
    private Object[] container;
    private  int index;

    /**
     * Метод возвращает элемент списка по индексу.
     * @param index полученное значение текущей ячейки
     * @return элемент из нее
     */
    public T get(int index) {
        Objects.checkIndex(index, this.index);
        return (T) container[index];
    }

    /**
     * Метод добавляет новый элемент в список.
     */
    public void add(T model) {
        if (index == container.length - 1) {

            container[ index++ ] = model;
        }
    }

    @Override
    public Iterator <T> iterator() {
        return null;
    }
}
