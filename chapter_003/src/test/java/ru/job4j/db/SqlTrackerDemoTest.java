package ru.job4j.db;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class SqlTrackerDemoTest {
  private SqlTracker sqlTracker = new SqlTracker();
    @Before
    public void before() {
        sqlTracker.init();
    }

    @Ignore
    public void add() {
        Item item = new Item("рихтовка", "0");
        Item item1 = sqlTracker.add(item);
        List<Item> itemList = sqlTracker.findAll();
        assertTrue(itemList.contains(item1));
    }

    @Ignore
    public void replace() {
        Item item = new Item("замена масла", "0");
        boolean b = sqlTracker.replace("6", item);
        List<Item> itemList = sqlTracker.findAll();
        assertEquals(itemList.contains(b), itemList.contains(6));
    }

    @Ignore
    public void delete() {
        boolean b = sqlTracker.delete("7");
        List<Item> itemList = sqlTracker.findAll();
        assertFalse(itemList.contains(b));
    }

    @Ignore
    public void findAll() {
        List<Item> all = sqlTracker.findAll();
        all.forEach(System.out::println);
    }

    @Ignore
    public void findByName() {
        List<Item> byName = sqlTracker.findByName("рихтовка");
        byName.forEach(System.out::println);
    }

    @Ignore
    public void findById() {
        Item byId =  sqlTracker.findById("1");
        System.out.println(byId);
    }
}