package ru.job4j.tree;

import org.junit.Ignore;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;


@Ignore
public class TreeTest {
    @Test
    public void when6ElFindLastThen6() {
        Tree<Integer> tree = new Tree<>(1);
        tree.add(1, 2);
        tree.add(1, 3);
        tree.add(1, 4);
        tree.add(4, 5);
        tree.add(5, 6);
        assertThat(
                tree.findBy(6).isPresent(),
                is(true)
        );
    }

    @Test
    public void when6ElFindNotExitThenOptionEmpty() {
        Tree<Integer> tree = new Tree<>(1);
        tree.add(1, 2);
        assertThat(tree.findBy(7).isPresent(), is(false));
    }

    @Test
    public void whenIsBinary() {
        Tree<Integer> tree = new Tree<>(2);
        tree.add(1, 2);
        tree.add(1, 4);
        assertTrue(tree.isBinary());
    }

    @Test
    public void whenNotIsBinary() {
        Tree<Integer> tree = new Tree<>(2);
        tree.add(2, 1);
        tree.add(2, 8);
        tree.add(2, 4);
       assertFalse(tree.isBinary());
    }
}
