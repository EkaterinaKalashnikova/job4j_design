package ru.job4j.collection;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

import org.junit.Test;

import java.util.Iterator;

public class ForwardLinkedRevTest {
    @Test
    public void whenAddThenIter() {
        ForwardLinkedRev<Integer> linked = new ForwardLinkedRev<>();
        linked.add(1);
        linked.add(2);
        Iterator<Integer> it = linked.iterator();
        assertThat(it.next(), is(1));
        assertThat(it.next(), is(2));
    }

    @Test
    public void whenAddAndRevertThenIter() {
        ForwardLinkedRev<Integer> linked = new ForwardLinkedRev<>();
        linked.add(1);
        linked.add(2);
        linked.revert();
        Iterator<Integer> it = linked.iterator();
        assertThat(it.next(), is(2));
        assertThat(it.next(), is(1));
    }
}