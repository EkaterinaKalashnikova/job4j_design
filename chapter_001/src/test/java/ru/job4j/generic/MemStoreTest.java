package ru.job4j.generic;

import org.junit.Ignore;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;


@Ignore
public class MemStoreTest {

    /**
     * Проверка дабавленного объекта, что найденный id в хранилище будет равен
     */
    @Test
    public void addUserThenFindUserWithIdd() {
        List<User> mem = new ArrayList<>(10);
        User users = null;
        UserStore store = new UserStore(users);
        store.add(new User("9"));
        assertThat(store.findById("9").getId(), is("9"));
    }

    /**
     * Проверка, что замена призведена
     */
    @Test
    public void replace() {
        List<User> mem = new ArrayList<>(10);
        User users = null;
        UserStore store = new UserStore(users);
        store.add(new User("9"));
        assertThat(store.replace("9", new User("7")), is(true));
    }

    /**
     * Проверка, что объект удален
     */
    @Test
    public void delete() {
        List<User> mem = new ArrayList<>(10);
        User users = null;
        UserStore store = new UserStore(users);
        store.add(new User("9"));
        store.add(new User("8"));
        store.add(new User("7"));
        store.add(new User("6"));
        assertThat(store.delete("6"), is(true));
    }

    /**
     * Проверяем что замена объекта вернет true
     */
    @Test
    public void whenUpdateRoleThenNewRoleId() {
        SimpleArray<Role> roles = new SimpleArray<>(4);
        RoleStore store = new RoleStore(roles);
        store.add(new Role("123"));
        assertThat(store.replace("123", new Role("456")), is(true));
    }
}