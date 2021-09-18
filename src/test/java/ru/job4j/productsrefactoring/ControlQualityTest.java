package ru.job4j.productsrefactoring;

import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

class ControlQualityTest {
    @Test
    public void whenAddInWarehouse() {
        Calendar expireDate = Calendar.getInstance();
        expireDate.add(Calendar.DAY_OF_MONTH, 20);
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Calendar createDate = Calendar.getInstance();
        dateFormat.format(createDate.getTime());
        createDate.add(Calendar.DATE, -5);
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
        expireDate.add(Calendar.DAY_OF_MONTH, -1);
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Calendar createDate = Calendar.getInstance();
        dateFormat.format(createDate.getTime());
        createDate.add(Calendar.DATE, -10);
        Food food1 = new Food("Bread", expireDate, createDate, 27.0);
        Storage warehouse1 = new Warehouse();
        Storage shop1 = new Shop();
        Storage trash1 = new Trash();
        ControlQuality controlQuality1 = new ControlQuality(List.of(warehouse1, shop1, trash1));
        controlQuality1.distribution(food1);
        Assert.assertTrue(warehouse1.getFoods().isEmpty());
        Assert.assertTrue(shop1.getFoods().isEmpty());
        Assert.assertThat(trash1.getFoods().get(0).getName(), Is.is("Bread"));
    }

    @Test
    public void whenAddInShopWithoutDiscount() {
        Calendar expireDate = Calendar.getInstance();
        expireDate.add(Calendar.DAY_OF_MONTH, 20);
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Calendar createDate = Calendar.getInstance();
        dateFormat.format(createDate.getTime());
        createDate.add(Calendar.DATE, -10);
        Food food2 = new Food("Bread", expireDate, createDate, 27.0);
        Storage warehouse2 = new Warehouse();
        Storage shop2 = new Shop();
        Storage trash2 = new Trash();
        ControlQuality controlQuality2 = new ControlQuality(List.of(warehouse2, shop2, trash2));
        controlQuality2.distribution(food2);
        Assert.assertTrue(warehouse2.getFoods().isEmpty());
        Assert.assertTrue(trash2.getFoods().isEmpty());
        Assert.assertThat(shop2.getFoods().get(0).getDiscount(), Is.is(0.0));
    }

    @Test
    public void whenAddInShopWithDiscount() {
        Calendar expireDate = Calendar.getInstance();
        expireDate.add(Calendar.DAY_OF_MONTH, 3);
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Calendar createDate = Calendar.getInstance();
        dateFormat.format(createDate.getTime());
        createDate.add(Calendar.DATE, -10);
        Food food3 = new Food("Bread", expireDate, createDate, 27.0);
        Storage warehouse3 = new Warehouse();
        Storage shop3 = new Shop();
        Storage trash3 = new Trash();
        ControlQuality controlQuality3 = new ControlQuality(List.of(warehouse3, shop3, trash3));
        controlQuality3.distribution(food3);
        Assert.assertTrue(warehouse3.getFoods().isEmpty());
        Assert.assertTrue(trash3.getFoods().isEmpty());
        Assert.assertThat(shop3.getFoods().get(0).getDiscount(), Is.is(25.0));
    }

    @Test
    public void whenAddFromWarehouse1() {
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
        Food food4 = new Food("Bread", expireDate, createDate, 27.0);
        Food food5 = new Food("Milk", expireDate1, createDate, 54.0);
        Food food6 = new Food("Cheese", expireDate2, createDate, 560.0);
        Storage warehouse4 = new Warehouse();
        Storage shop4 = new Shop();
        Storage trash4 = new Trash();
        ControlQuality controlQuality4 = new ControlQuality(List.of(warehouse4, shop4, trash4));
        controlQuality4.distribution(food4);
        controlQuality4.distribution(food5);
        controlQuality4.distribution(food6);
        Assert.assertEquals(warehouse4.getFoods().get(0).getName(), "Cheese");
        Assert.assertEquals(trash4.getFoods().get(0).getName(), "Milk");
        Assert.assertEquals(shop4.getFoods().get(0).getName(), "Bread");
        food4.setExpiryDate(expireDate1);
        food5.setExpiryDate(expireDate2);
        food6.setExpiryDate(expireDate);
        controlQuality4.resort();
        Assert.assertTrue(trash4.getFoods().contains(food4));
        Assert.assertTrue(warehouse4.getFoods().contains(food5));
        Assert.assertTrue(shop4.getFoods().contains(food6));
    }

    @Test
    public void whenAddFromWarehouse2() {
        Calendar expireDate = Calendar.getInstance();
        Calendar expireDate1 = Calendar.getInstance();
        Calendar expireDate2 = Calendar.getInstance();
        expireDate.add(Calendar.DAY_OF_MONTH, 15);
        expireDate1.add(Calendar.DAY_OF_MONTH, -1);
        expireDate2.add(Calendar.DAY_OF_YEAR, 90);
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Calendar createDate = Calendar.getInstance();
        dateFormat.format(createDate.getTime());
        createDate.add(Calendar.DATE, -10);
        Food food7 = new Food("Bread", expireDate, createDate, 27.0);
        Food food8 = new Food("Milk", expireDate1, createDate, 54.0);
        Food food9 = new Food("Cheese", expireDate2, createDate, 560.0);
        Storage warehouse5 = new Warehouse();
        Storage shop5 = new Shop();
        Storage trash5 = new Trash();
        ControlQuality controlQuality5 = new ControlQuality(List.of(warehouse5, shop5, trash5));
        controlQuality5.distribution(food7);
        controlQuality5.distribution(food8);
        controlQuality5.distribution(food9);
        Assert.assertEquals(warehouse5.getFoods().get(0).getName(), "Cheese");
        Assert.assertEquals(trash5.getFoods().get(0).getName(), "Milk");
        Assert.assertEquals(shop5.getFoods().get(0).getName(), "Bread");
        food7.setExpiryDate(expireDate1);
        food8.setExpiryDate(expireDate2);
        food9.setExpiryDate(expireDate);
        controlQuality5.resort();
        Assert.assertTrue(trash5.getFoods().contains(food7));
        Assert.assertTrue(warehouse5.getFoods().contains(food8));
        Assert.assertTrue(shop5.getFoods().contains(food9));
    }
}