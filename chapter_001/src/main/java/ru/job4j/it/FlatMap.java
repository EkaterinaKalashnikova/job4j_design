package ru.job4j.it;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class FlatMap<T> implements Iterator<T> {

    /**
     * итератор, пробегающий по итератору Iterator<T>
     */
    private final Iterator<Iterator<T>> data;

    /**
     * итератор, пробегающий по элементам коллекции <T>
     */
    private Iterator<T> cursor;

    /**
     *  Конструктор инициализации итератора итераторов
     * @param data
     */
    public FlatMap(Iterator<Iterator<T>> data) {
        this.data = data;
    }

    /**
     * Метод проверяет есть ли следующий элемент в выбранном итераторе элементе
     * @return если он существует
     */
    @Override
    public boolean hasNext() {
        selectCursor();
        return (cursor != null && cursor.hasNext());
    }

    /**
     *Метод выводит значения итератора<T>
     * @return и возвращает их
     * @throws NoSuchElementException
     */
    @Override
    public T next() {
        if (!hasNext()) {
                throw new NoSuchElementException();
            }
        return cursor.next();
    }

    /**
     * Дополнительный метод, проверящий пустые коллекции и выводящий существующие
     */
    private void selectCursor() {
        if (cursor != null && cursor.hasNext()) {
            return;
        }
        cursor = null;
        while (data.hasNext()) {
            Iterator<T> nextIterator = data.next();
            if (nextIterator.hasNext()) {
                cursor = nextIterator;
                break;
            }
        }
    }

    /**
     * Метод выводящий список со всех итераторов
     * @param args
     */
    public static void main(String[] args) {
        Iterator<Iterator<Integer>> data = List.of(
                List.of(1, 2, 3).iterator(),
                List.of(4, 5, 6).iterator(),
                List.of(7, 8, 9).iterator()
        ).iterator();
        FlatMap<Integer> flat = new FlatMap<>(data);
        while (flat.hasNext()) {
            System.out.println(flat.next());
        }
    }
}
