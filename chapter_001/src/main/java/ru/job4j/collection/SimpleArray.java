package ru.job4j.collection;

import java.util.*;

public class SimpleArray<T> implements Iterable<T>  {

    /**
     * Поле массива для хранения объектов.
     * Поле для значения текущей ячейки массива.
     * Поле для подсчета количества элементов в коллекции.
     * Поле размера массива.
     */
    private Object[] container;
    private  int index = 0;
    private int modCount = 0;
    private int size = 0;

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
        if (index == container.length) {
            container = Arrays.copyOf(container, container.length * 2);
        }
        container[ this.index++ ] = model;
        modCount++;
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
           private int cursor;

            /**
             * Значение счетчика на момент создания.
             */
            private int expectedModCount = modCount;

            @Override
            public boolean hasNext() {
               if (expectedModCount != modCount) {
                   throw new ConcurrentModificationException();
               }
                return cursor < index;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return (T) container[cursor++];
            }
        };
    }

    public int size() {
        return index;
    }
}
