package ru.job4j.collection;

import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Objects;

public class SimpleArray<T> implements Iterable<T>  {

    /**
     * Поле массива для хранения десяти объектов.
     * Поле для значения текущей ячейки массива.
     */
    private Object[] container;
    private  int index = 0;

    /**
     * Конструктор по умолчанию создает контейнер для хранения 10 элементов.
     */
    public SimpleArray() {
        this.container = new Object[10];
    }

    /**
     * Метод добавляет новый элемент в список.
     */
    public void add(T model) {
        if (index == container.length  + 1) {
            resize((container.length * 3) / 2 + 1);
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
     * Вспомогательный метод для адаптации размера массива к новому размеру
     * @param newLength новая длина нового контейнера
     */
    private void resize(int newLength) {
        Object[] newContainer = new Object[ newLength ];
        Arrays.copyOf(container, newLength);
       // System.arraycopy(container, 0, newContainer, 0, index);
        container = newContainer;
    }

    /**
     * Метод возвращает элемент списка по индексу.
     * @param index полученное значение текущей ячейки
     * @return элемент из нее по индексу
     */
    public T get(int index) {
        Objects.checkIndex(index, this.index);
        return (T) container[index];
    }

    /**
     * Итератор возвращает проход по элементам контейнера
     * @return возвращает итератор по элементам контейнера
     */
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {

            /**
             * Указатель для перебора элементов в контейненре.
             */
            private int modCount = 0;

            /**
             * Значение счетчика на момент создания.
             */
            int expectedModCount = modCount;

            @Override
            public boolean hasNext() {
                return this.modCount > expectedModCount;
            }

            @Override
            public T next() {
                if (this.modCount != expectedModCount) {
                    throw new ConcurrentModificationException();
                }
                return (T) container[modCount++];
            }
        };
    }
}
