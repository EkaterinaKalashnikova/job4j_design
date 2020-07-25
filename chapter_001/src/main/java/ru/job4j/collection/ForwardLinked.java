package ru.job4j.collection;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ForwardLinked<T> implements Iterable<T> {
    private Node<T> head;
    private Node<T> tail;

    public void add(T value) {
        Node<T> node = new Node<T>(value, null);
        if (head == null) {
            head = node;
            return;
        }
        Node<T> tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }
        tail.next = node;
    }

    /**
     * Метод удаления элемента из списка, когда проверяем
     * что список состоит только из одного элемента,
     * из двух: головы и хвоста, если тот который нам нужен это голова,
     * перключаемся на второй, следующий.
     * @return value - значение оставшегося элемента
     */
    public T deleteFirst() {
        if (head == null) {
            throw new NoSuchElementException();
        }
        if (head == tail) {
            head = null;
            tail = null;
            return null;
        }
        T value = (T) head.value;
         head = head.next;
         return value;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            Node<T> node = head;

            @Override
            public boolean hasNext() {
                return node != null;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                T value = node.value;
                node = node.next;
                return value;
            }
        };
    }

    private static class Node<T> {
        T value;
        Node<T> next;

        public Node(T value, Node<T> next) {
            this.value = value;
            this.next = next;
        }
    }
}