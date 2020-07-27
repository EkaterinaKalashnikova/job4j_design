package ru.job4j.collection;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SimpleSetTest {

    @Test
    public void whenAddElementDuble() {
        SimpleSet<Integer> set = new SimpleSet<>();
        set.add(5);
        set.add(4);
        set.add(5);
        assertThat(set.size(), is(2));
    }
}