package ru.job4j.generic;

import java.util.ArrayList;
import java.util.List;

public class MemExample {
    private final List<Integer> mem = new ArrayList<>();
    public int findById(String id) {
        Integer rsl = null;
        for (int index = 0; index < this.mem.size(); index++) {
            if (index  == mem.indexOf(id)) { //проверяем
                rsl = Integer.valueOf(id); //выводим полученное значение
            } else {
                rsl = -1; // или нет элемента
            }
        }
        return rsl;
    }
}


        /** for (Integer index : this.mem) { //перебираем список
            id = String.valueOf(mem.get(index)); //присваиваем id полученное найденное значение
            if (mem.indexOf(id) != -1) { //проверяем возвращает что-либо кроме -1, то список содержит элемент
               rsl = Integer.valueOf(id); //выводим полученное значение
            } else {
                rsl = -1; // или нет элемента
            }
        }*/


