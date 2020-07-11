package ru.job4j.generic;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class SimpleArray<T> implements Iterable<T> {

    /**
     * Поле массива для хранения  объектов
     * Поле для значения текущей ячейки массива
     */
    private Object[] array;
    private  int index;

    /**
     * Конструктор инициализации массива по размеру
     * @param size размер массива
     */
    public SimpleArray(int size) {
        this.array = new Object[size];
    }

    /**
     * Метод добавления указанного элемента (model) в первую свободную ячейку;
     * @param model указанный элемент
     */
    public void add(T model) {
        this.array[index++] = model;
    }

    /**
     * Метод заменяет указанный элемент по индексу
     * @param index указанный элемент
     * @param model новое значение после изменения
     */
    public void set(int index, T model) {
        Objects.checkIndex(index, this.index);
        this.array[index] = model;
    }

    /**
     * Метод, удаляющий элемент по указанному индексу
     * смещение влево всех элементов осуществляется за счет копирования
     * массива со смещением на 1
     * @param index текущая ячейка для удаления
     */
    public void remove(int index) {
       Objects.checkIndex(index, this.index);
       System.arraycopy(array, index + 1, array, index, array.length - index - 1);
       array[--this.index] = null;
    }

    /**
     * Метод, возвращающий элемент, расположенный по указанному адресу
     * @param index текущая ячейка
     * @return значение в текущей ячейке
     */
    public T get(int index) {
        Objects.checkIndex(index, this.index);
        return (T) this.array[index];
    }

    /**
     * Метод, реализующий итератор для обхода данной структуры
     * проходим указателем по контейнеру по всей длине массива
     * @return итератор, пробегающий по элементам коллекции, содержащий Т
     */
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int cursor = 0;

            @Override
            public boolean hasNext() {
                return cursor < index;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return (T) array[cursor++];
            }
        };
    }
}
