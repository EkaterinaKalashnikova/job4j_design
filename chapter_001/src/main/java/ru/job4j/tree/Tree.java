package ru.job4j.tree;

import java.util.*;

public class Tree<E> implements SimpleTree<E> {
    private final Node<E> root;

    Tree(final E root) {
        this.root = new Node<>(root);
    }

    @Override
    public boolean add(E parent, E child) {
        boolean rsl = false;
        Optional<Node<E>> parentNod = this.findBy(parent);
        if (parentNod.isPresent()) {
            Node<E> el = parentNod.get();
            if (findBy(child).isEmpty()) {
                el.children.add(new Node<>(child));
                rsl = true;
            }
        }
        return rsl;
    }

    @Override
    public Optional<Node<E>> findBy(E value) {
        Optional<Node<E>> rsl = Optional.empty();
        Queue<Node<E>> data = new LinkedList<>();
        data.offer(this.root);
        while (!data.isEmpty()) {
            Node<E> el = data.poll();
            if (el.value.equals(value)) {
                rsl = Optional.of(el);
                break;
            }
            data.addAll(el.children);
        }
        return rsl;
    }

    public boolean isBinary() {
        boolean flag = true;
        Queue<Node<E>> nodes = new LinkedList<>();
        nodes.add(root);
        Node<E> current = null;
        while (!nodes.isEmpty()) {
            current = nodes.poll();
            if (current.children.size() > 2) {
                flag = false;
                break;
              // for (Node<E> el : current.children) {
               //    nodes.offer(el);
              //  }
          //  } else {
              //  flag = false;
            }
        }
        return flag;
    }
}
