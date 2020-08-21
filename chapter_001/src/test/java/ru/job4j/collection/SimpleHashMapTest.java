package ru.job4j.collection;

import org.junit.Test;

import java.util.ConcurrentModificationException;
import java.util.GregorianCalendar;
import java.util.Iterator;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


public class SimpleHashMapTest {

    private User one = new User("Amura", 2, new GregorianCalendar(2006, 1, 23));
    private User two = new User("Ganna", 1, new GregorianCalendar(2010, 3, 8));
    private User three = new User("Lusi", 2, new GregorianCalendar(2018, 1, 1));

    @Test
    public void whenAddElementToContainer() {
        SimpleHashMap<User, Integer> map = new SimpleHashMap<>();
        map.insert(one, 1);
        map.insert(three, 2);
        assertThat(map.size(), is(2));
    }

    @Test
    public void whenSearchElementByValue() {
        SimpleHashMap<User, Integer> map = new SimpleHashMap<>();
        map.insert(one, 1);
        map.insert(two, 3);
        assertThat(map.get(this.one), is(1));
        assertThat(map.get(this.two), is(3));
    }

    @Test
    public void whenElementRemoveContainer() {
        SimpleHashMap<User, Integer> map = new SimpleHashMap<>();
        map.insert(one, 1);
        map.insert(two, 2);
        assertThat(map.delete(this.one), is(true));
        assertThat(map.size(), is(1));
        assertThat(map.delete(this.three), is(false));
    }

    @Test(expected = ConcurrentModificationException.class)
    public void iterator() {
        SimpleHashMap<User, Integer> map = new SimpleHashMap<>();
        map.insert(this.one, 1);
        map.insert(this.two, 2);
        map.insert(this.three, 1);
        Iterator<SimpleHashMap.Entry> it = map.iterator();
        assertThat(it.next().getKey(), is(1));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next().getKey(), is(2));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next().getKey(), is(1));
        assertThat(it.hasNext(), is(false));
    }

    @Test
    public void whenTableSizeExpands() {
    SimpleHashMap<String, Integer> map = new SimpleHashMap<>();
        for (int i = 1; i <= 25; i++) {
        map.insert(String.valueOf(i), i);
        }
    assertThat(map.size(), is(25));
    }
}