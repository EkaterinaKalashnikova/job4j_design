package ru.job4j.generic;

import java.util.ArrayList;
import java.util.List;

public final class MemStore<T extends Base> implements Store<T> {

    private final List<T> mem = new ArrayList<>();

    @Override
    public void add(T model) {
        this.mem.add(model);
    }

    @Override
    public boolean replace(String id, T model) {
        T base = this.findById(id);
        if (base != null) {
           replace(id, model);
        }
        return false;
    }

    @Override
    public boolean delete(String id) {
        T base = this.findById(id);
        if (base != null) {
            delete(id);
        }
        return false;
    }

    @Override
    public T findById(String id) {
        T rsl = null;
        for (T base : this.mem) {
            if (base != null && base.getId().equals(id)) {
                rsl = base;
                break;
            }
        }
        return rsl;
    }
}
