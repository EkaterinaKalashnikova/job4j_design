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
     */
    private final int[][] data;

    /**
     * Указатель строки текущего элемента
     */
    private int row = 0;

    /**
     * Указатель столбца текущего элемента
     */
    private int column = 0;

    /**
     * Конструктор
     * @param data
     */
    public MatrixIt(int[][] data) {
        this.data = data;
    }

    /**
     * Метод проверяет строки в массиве
     * @return строки в массиве
     */
    @Override
    public boolean hasNext() {
        if (row + 1 == data.length) {
            return column < data[ row ].length;
        }
        return row < data.length;
    }

    /**
     * Метод выодит значения массива поочередно
     * @return значения двумерного массива с текущими элементами
     */
    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        } else if (column < data[ row ].length) {
            column = 0;
            row++;
            //return data[ row ][ column++ ];
        }
       // return data[ row++ ][ column ];
        return data[ row ][ column++ ];
    }
}

