package ru.job4j.collection;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ForwardLinkedRev<T> implements Iterable<T> {
    private Node<T> head;

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
     * Метод разворачивания связанного списка,
     * где устанавливаем ссылку текущей, чтобы указывать на предыдущую,
     * запоминаем элемент, чтобы с него продолжить,
     * затем изменяем предыдущий элемент, его ссылку, и он становиться текущим,
     * изменяем первый элемент на тот, который запомнили и так с каждым элементом
     * до тех пор пока не достигнем последнего элемента
     * которого вернем как новый головной элемент.
     */
    public void revert() {
         Node<T> previous = head;
         Node<T> current = head.next;

         while (current != null) {
             Node<T> tmp = current.next;
             current.next = previous;
             previous = current;
             current = tmp;
         }
         head = previous;
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
