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
        map.insert(this.one, 1);
        map.insert(this.three, 2);
        assertThat(map.size(), is(1));
    }

    @Test
    public void whenSearchElementByValue() {
        SimpleHashMap<User, Integer> map = new SimpleHashMap<>();
        map.insert(one, 1);
        map.insert(three, 3);
        map.insert(two, 2);
        assertThat(map.get(this.one), is(1));
        assertThat(this.three, is(3));
        assertThat(map.get(this.two), is(2));
    }

    @Test
    public void whenElementRemoveContainer() {
        SimpleHashMap<User, Integer> map = new SimpleHashMap<>();
        map.insert(one, 1);
        map.insert(two, 2);
        assertThat(map.delete(this.two), is(2));
        assertThat(map.delete(this.three), is(false));
    }

    @Test(expected = ConcurrentModificationException.class)
    public void iterator() {
        SimpleHashMap<User, Integer> map = new SimpleHashMap<>();
        map.insert(one, 1);
        map.insert(two, 1);
        map.insert(three, 3);
        Iterator<User> it = map.iterator();
        assertThat(it.hasNext(), is(true));
        it.next();
        assertThat(it.hasNext(), is(false));
        it.next();
        assertThat(it.hasNext(), is(true));
        it.next();

    }
}