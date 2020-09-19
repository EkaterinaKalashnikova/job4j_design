package ru.job4j.collection;

import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ContainerLinkedListTest {

    @Test
    public void whenLastElementAddToList() {
        ContainerLinkedList<Integer> list = new ContainerLinkedList<>();
        list.add(3);
        Iterator<Integer> iterator = list.iterator();
        assertThat(iterator.next(), is(3));
    }
}