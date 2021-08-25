package ru.job4j.lsp.products;

import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


class ControllQualityTest {

    @Test
    public void whenAddInWarehouse() {
        Calendar expireDate = Calendar.getInstance();
        expireDate.set(2022, Calendar.NOVEMBER, 1);
        Calendar createDate = Calendar.getInstance();
        createDate.set(2021, Calendar.AUGUST, 1);
        Food food = new Food("Bread", expireDate, createDate, 27.0);
        Storage warehouse = new Warehouse();
        Storage shop = new Shop();
        Storage trash = new Trash();
        ControllQuality controllQuality = new ControllQuality(List.of(warehouse, shop, trash));
        controllQuality.distribution(food);
        Assert.assertThat(warehouse.getFoods().get(0).getName(), Is.is("Bread"));
        Assert.assertTrue(shop.getFoods().isEmpty());
        Assert.assertTrue(trash.getFoods().isEmpty());
    }

    @Test
    public void whenAddInTrash() {
        Calendar expireDate = Calendar.getInstance();
        expireDate.set(2021, Calendar.AUGUST, 1);
        Calendar createDate = Calendar.getInstance();
        createDate.set(2021, Calendar.JUNE, 1);
        Food food = new Food("Bread", expireDate, createDate, 27.0);
        Storage warehouse = new Warehouse();
        Storage shop = new Shop();
        Storage trash = new Trash();
        ControllQuality controllQuality = new ControllQuality(List.of(warehouse, shop, trash));
        controllQuality.distribution(food);
        Assert.assertTrue(warehouse.getFoods().isEmpty());
        Assert.assertTrue(shop.getFoods().isEmpty());
        Assert.assertThat(trash.getFoods().get(0).getName(), Is.is("Bread"));
    }

    @Test
    public void whenAddInShopWithoutDiscount() {
        Calendar expireDate = Calendar.getInstance();
        expireDate.set(2021, Calendar.DECEMBER, 1);
        Calendar createDate = Calendar.getInstance();
        createDate.set(2021, Calendar.FEBRUARY, 1);
        Food food = new Food("Bread", expireDate, createDate, 27.0);
        Storage warehouse = new Warehouse();
        Storage shop = new Shop();
        Storage trash = new Trash();
        ControllQuality controllQuality = new ControllQuality(List.of(warehouse, shop, trash));
        controllQuality.distribution(food);
        Assert.assertTrue(warehouse.getFoods().isEmpty());
        Assert.assertTrue(trash.getFoods().isEmpty());
        Assert.assertThat(shop.getFoods().get(0).getDiscount(), Is.is(0.0));
    }

    @Test
    public void whenAddInShopWithDiscount() {
        Calendar expireDate = Calendar.getInstance();
        expireDate.set(2021, Calendar.OCTOBER, 1);
        Calendar createDate = Calendar.getInstance();
        createDate.set(2021, Calendar.FEBRUARY, 1);
        Food food = new Food("Bread", expireDate, createDate, 27.0);
        Storage warehouse = new Warehouse();
        Storage shop = new Shop();
        Storage trash = new Trash();
        ControllQuality controllQuality = new ControllQuality(List.of(warehouse, shop, trash));
        controllQuality.distribution(food);
        Assert.assertTrue(warehouse.getFoods().isEmpty());
        Assert.assertTrue(trash.getFoods().isEmpty());
        Assert.assertThat(shop.getFoods().get(0).getDiscount(), Is.is(25.0));

    }
}