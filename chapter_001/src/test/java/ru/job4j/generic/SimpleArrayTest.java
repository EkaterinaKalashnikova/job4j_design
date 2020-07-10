package ru.job4j.generic;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import org.junit.Test;

import java.util.Objects;

public class SimpleArrayTest {

    @Test
    public void whenAddOneElementTheArrayString() {
        SimpleArray<String> array = new SimpleArray<>(5);
        array.add("test");
        String result = array.get(0);
        assertThat(result, is("test"));
    }
    @Test
    public void whenAddOneElementTheArrayInteger() {
        SimpleArray<Integer> array = new SimpleArray<>(10);
        array.add(3);
        Objects.checkIndex(1, 10);
    }

    @Test
    public void whenRemoveElementCheckModelIsNull() {
        SimpleArray<Integer> array = new SimpleArray<>(10);
         array.add(2);
         array.remove(4);
         Objects.checkIndex(4, 10);
         assertNull(array.get(2));
    }

    @Test
    public void whenChangesElementAndReturnNewModel() {
        SimpleArray<Integer> array = new SimpleArray<>(10);
        array.add(5);
        array.set(5, 2);
        assertThat(array.get(5), is(2));
    }
}