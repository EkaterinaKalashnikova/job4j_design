package ru.job4j.collection;

import java.util.Iterator;
import java.util.Objects;

import static com.sun.org.apache.xerces.internal.impl.xs.XSAttributeGroupDecl.resize;

public class SimpleArray<T> implements Iterable<T>  {

    /**
     * Поле массива для хранения  объектов
     * Поле для значения текущей ячейки массива
     */
    private Object[] container;
    private  int index = 0;

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
            resize(container.length * 2);
            container[ index++ ] = model;
        }
    }

    /*
    * Возвращает количество элементов в списке
    */
    public int size() {
        return index;
    }

    /**
     * Вспомогательный метод для масштабирования
     */
    private void resize(int newLength) {
        Object[] newContainer = new Object[newLength];
        System.arraycopy(container, 0, newContainer, 0, index);
        container = newContainer;
    }

    @Override
    public Iterator <T> iterator() {
        return null;
    }
}
