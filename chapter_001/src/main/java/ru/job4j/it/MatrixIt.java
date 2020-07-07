package ru.job4j.it;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Итератор двумерного массива
 *
 * @author Калашникова Екатерина
 * @science 28.06.2020
 */


public class MatrixIt implements Iterator<Integer> {
    /**
     * Двумерный массив
     * Указатель строки текущего элемента
     * Указатель столбца текущего элемента
     */
    private final int[][] data;
    private int row = 0;
    private int column = 0;

    /**
     * Конструктор,инициализирующий массив
     *
     * @param data
     */
    public MatrixIt(int[][] data) {
        this.data = data;
    }

    /**
     * Метод проверяет строки в массиве,
     * чтобы шаг итератора не вышел за пределы солбцов
     *
     * @return строки в массиве
     */

    @Override
    public boolean hasNext() {
        while (row < data.length && column < data[row].length) {
            column = 0;
            row++;
        }
        return true;
    }

    /**
     * Метод выодит значения массива поочередно
     *
     * @return значения двумерного массива с текущими элементами
     * @throw NoSuchElementException();
     */

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return data[row][column++];
    }
}



