package ru.job4j.generic;

import java.util.Objects;

public class UserStore implements Store<User> {

    private final Store<User> store = new MemStore<>();

    public UserStore(User users) {
    }

    @Override
    public void add(User model) {
        this.store.add(model);
    }

    @Override
    public boolean replace(String id, User model) {
        return store.replace(id, model);
    }

    @Override
    public boolean delete(String id) {
        return store.delete(id);
    }

    @Override
    public User findById(String id) {
        return store.findById(id);
    }
}