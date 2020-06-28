package ru.job4j.it;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Итератор четных чисел
 *
 * @author Калашникова Екатерина
 * @science 28.06.2020
 */
public class EventIt implements Iterator<Integer> {
    /**
     * Массив чисел
     */
    final int[] numbers;

    /**
     * Указатель массива
     */
    private int index;

    /**
     * Конструктор инициализации массива
     * @param numbers
     */
    public EventIt(final int[] numbers) {
        this.numbers = numbers;
    }

    /**
     *Метод проверяет есть ли следующий элемент в массиве
     * @return возвращает позицию
     */
    @Override
    public boolean hasNext() {
        return index < numbers.length && numbers[ index ] != 0;
    }

    /**
     * Метод возвращает четное значение или если его нет: сообщает
     * @return четные значения
     * @throws NoSuchElementException
     */
    @Override
    public Integer next() throws NoSuchElementException {
        if (!this.hasNext()) {
            throw new NoSuchElementException("Четные элементы закончились)");
        } else {
            return this.numbers[ this.index++ ];
        }
    }

    /**
     * Метод вывода четных значений в массиве
     */
    public void printEvenNumbers() {
        int result = -1;
        for (int i = this.index; i < this.numbers.length; i++) {
            if (this.numbers[ i ] % 2 == 0) {
                this.index = i;
                result++;
            }
        }
    }
}
