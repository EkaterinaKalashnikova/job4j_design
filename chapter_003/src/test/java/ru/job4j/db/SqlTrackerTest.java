package ru.job4j.db;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.sql.PreparedStatement;
import java.util.List;

import static org.junit.Assert.*;

public class SqlTrackerTest {
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
        Assertions.assertTrue(itemList.contains(item1));
    }

    @Test
    public void replace() {
        Item item = new Item("замена масла", "0");
        boolean b = sqlTracker.replace("6", item);
        List<Item> itemList = sqlTracker.findAll();
        Assertions.assertEquals(itemList.contains(b), itemList.contains(6));
    }

    @Test
    public void delete() {
        boolean b = sqlTracker.delete("7");
        boolean b1 = sqlTracker.delete("8");
        List<Item> itemList = sqlTracker.findAll();
        Assertions.assertFalse(itemList.contains(b));
        Assertions.assertFalse(itemList.contains(b1));
    }

    @Test
    public void findAll() {
        List<Item> all = sqlTracker.findAll();
        all.forEach(System.out::println);
    }

    @Test
    public void findByName() {
        List<Item> byName = sqlTracker.findByName("key");
         byName.forEach(System.out::println);
    }

    @Test
    public void findById() {
        List<Item> itemList = sqlTracker.findAll();
        Item byId = sqlTracker.findById("id");
        System.out.println(itemList.add(byId));
    }
}