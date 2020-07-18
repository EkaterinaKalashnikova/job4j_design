package ru.job4j.generic;

import java.util.ArrayList;
import java.util.List;

public final class MemStore<T extends Base> implements Store<T> {

    /**
     * Контейнер для хранения типизированных данных
     */
    private final List<T> mem = new ArrayList<>();

    /**
     * Метод добавления объекта в хранилище
     * @param model объект типа Т
     */
    @Override
    public void add(T model) {
        this.mem.add(model);
    }

    /**
     * Метод замены объекта на другой объект в хранилище
     * @param id
     * @param model новый объект для замены старого объекта
     * @return если замена произошла, то вернуть true
     */
    @Override
    public boolean replace(String id, T model) {
       int index = indexOf(id);
        if (index == -1) {
           return false;
        }
        mem.set(index, model);
        return true;
    }

    /**
     * Метод удаления объекта из хранилища
     * @param id
     * @return если объект удален, то вернуть true
     */
    @Override
    public boolean delete(String id) {
        int index = indexOf(id);
        if (index == -1) {
            return false;
        }
        mem.remove(index);
        return true;
    }

    /**
     * Метод поиска объекта в хранилище по ID объекта
     * @param id
     * @return если элемент встречается, вернуть полученные данные указателя из хранилища
     */
    @Override
    public T findById(String id) {
        int index = indexOf(id);
        if (index == -1) {
            return null;
         }
      return mem.get(index);
    }

    /**
     * Метод поиска объекта в хранилище по index (указателю)
     * @param id
     * @return вернуть указатель, если элемент найден
     */
    private int indexOf(String id) {
        int index = -1;
        for (int i = 0; i < mem.size(); i++) {
            if (mem.get(i).getId().equals(id)) {
                index = i;
                break;
            }
        }
        return index;
    }
}
