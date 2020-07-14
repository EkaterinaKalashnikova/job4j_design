package ru.job4j.generic;

import java.util.Objects;

public class UserStore implements Store<User> {

    private final Store<User> store = new MemStore<>();

    @Override
    public void add(User model) {
        this.store.add(model);
    }

    @Override
    public boolean replace(String id, User model) {
        User base = this.findById(id);
        if (base != null) {
            this.store.replace(id, model);
        }
        return false;
    }

    @Override
    public boolean delete(String id) {
        User base = this.findById(id);
        if (base != null) {
            this.store.delete(id);
        }
        return false;
    }

    @Override
    public User findById(String id) {
        User result = null;
       for (User base : this.store) {
            if (base != null && base.getId().equals(id)) {
                result = base;
                break;
            }
        }
        return result;
    }
}