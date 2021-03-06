package ru.job4j.db;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class SqlTrackerDemoTest {
    private SqlTracker sqlTracker = new SqlTracker();
    @Before
    public void before() {
        sqlTracker.init();
    }

    @Test
    public void add() {
        Item item = new Item("рихтовка", "0");
        Item item1 = sqlTracker.add(item);
        List<Item> itemList = sqlTracker.findAll();
        assertTrue(itemList.contains(item1));
    }

    @Test
    public void replace() {
        Item item = new Item("замена масла", "0");
        boolean b = sqlTracker.replace("6", item);
        List<Item> itemList = sqlTracker.findAll();
        assertEquals(itemList.contains(b), itemList.contains(6));
    }

    @Test
    public void delete() {
        boolean b = sqlTracker.delete("7");
        List<Item> itemList = sqlTracker.findAll();
        assertFalse(itemList.contains(b));
    }

    @Test
    public void findAll() {
        List<Item> all = sqlTracker.findAll();
        all.forEach(System.out::println);
    }

    @Test
    public void findByName() {
        List<Item> byName = sqlTracker.findByName("рихтовка");
        byName.forEach(System.out::println);
    }

    @Test
    public void findById() {
        Item byId =  sqlTracker.findById("1");
        System.out.println(byId);
    }
}