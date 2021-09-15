package ru.job4j.productsrefactoring;

import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;

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
        ControlQuality controlQuality = new ControlQuality(List.of(warehouse, shop, trash));
        controlQuality.distribution(food);
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
        ControlQuality controlQuality = new ControlQuality(List.of(warehouse, shop, trash));
        controlQuality.distribution(food);
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
        ControlQuality controlQuality = new ControlQuality(List.of(warehouse, shop, trash));
        controlQuality.distribution(food);
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
        ControlQuality controlQuality = new ControlQuality(List.of(warehouse, shop, trash));
        controlQuality.distribution(food);
        Assert.assertTrue(warehouse.getFoods().isEmpty());
        Assert.assertTrue(trash.getFoods().isEmpty());
        Assert.assertThat(shop.getFoods().get(0).getDiscount(), Is.is(25.0));
    }

    @Test
    public void whenAddFromWarehouse1() {
        Calendar expireDate = Calendar.getInstance();
        Calendar expireDate1 = Calendar.getInstance();
        Calendar expireDate2 = Calendar.getInstance();
        expireDate.set(2021, Calendar.OCTOBER, 1);
        expireDate1.set(2021, Calendar.SEPTEMBER, 12);
        expireDate2.set(2022, Calendar.FEBRUARY, 10);
        Calendar createDate = Calendar.getInstance();
        createDate.set(2021, Calendar.AUGUST, 1);
        Food food = new Food("Bread", expireDate, createDate, 27.0);
        Food food1 = new Food("Milk", expireDate1, createDate, 54.0);
        Food food2 = new Food("Cheese", expireDate2, createDate, 560.0);
        Storage warehouse = new Warehouse();
        Storage shop = new Shop();
        Storage trash = new Trash();
        ControlQuality controlQuality = new ControlQuality(List.of(warehouse, shop, trash));
        controlQuality.distribution(food);
        controlQuality.distribution(food1);
        controlQuality.distribution(food2);
        Assert.assertEquals(warehouse.getFoods().get(0).getName(), "Cheese");
        Assert.assertEquals(trash.getFoods().get(0).getName(), "Milk");
        Assert.assertEquals(shop.getFoods().get(0).getName(), "Bread");
        food.setExpiryDate(expireDate1);
        food1.setExpiryDate(expireDate2);
        food2.setExpiryDate(expireDate);
        controlQuality.resort();
        Assert.assertEquals(trash.getFoods().get(0).getName(), "Bread");
        Assert.assertTrue(warehouse.getFoods().contains(food1));
        Assert.assertTrue(shop.getFoods().contains(food2));
    }

    @Test
    public void whenAddFromWarehouse2() {
        Calendar expireDate = Calendar.getInstance();
        Calendar expireDate1 = Calendar.getInstance();
        Calendar expireDate2 = Calendar.getInstance();
        expireDate.add(Calendar.DAY_OF_MONTH, 15);
        expireDate1.add(Calendar.DAY_OF_MONTH, 0);
        expireDate2.add(Calendar.DAY_OF_YEAR, 90);
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Calendar createDate = Calendar.getInstance();
        dateFormat.format(createDate.getTime());
        createDate.add(Calendar.DATE, -10);
        Food food = new Food("Bread", expireDate, createDate, 27.0);
        Food food1 = new Food("Milk", expireDate1, createDate, 54.0);
        Food food2 = new Food("Cheese", expireDate2, createDate, 560.0);
        Storage warehouse = new Warehouse();
        Storage shop = new Shop();
        Storage trash = new Trash();
        ControlQuality controlQuality = new ControlQuality(List.of(warehouse, shop, trash));
        controlQuality.distribution(food);
        controlQuality.distribution(food1);
        controlQuality.distribution(food2);
        Assert.assertEquals(warehouse.getFoods().get(0).getName(), "Cheese");
        Assert.assertEquals(trash.getFoods().get(0).getName(), "Milk");
        Assert.assertEquals(shop.getFoods().get(0).getName(), "Bread");
        food.setExpiryDate(expireDate1);
        food1.setExpiryDate(expireDate2);
        food2.setExpiryDate(expireDate);
        controlQuality.resort();
        Assert.assertTrue(trash.getFoods().contains(food));
        Assert.assertTrue(warehouse.getFoods().contains(food1));
        Assert.assertTrue(shop.getFoods().contains(food2));
    }
}