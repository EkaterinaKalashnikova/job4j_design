package ru.job4j.collection;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class ContainerLinkedList<E> implements Iterable<E> {

    /**
     * Поле для подсчета количества элементов в коллекции.
     * Поле для размера списка.
     * Поле первого элемента  в списке.
     * Поле последнего элемента  в списке.
     * Поле значения текущего указателя.
     */
    private int modCount = 0;
    private int size;
    private Node head;
    private Node tail;
    public int point;

    /**
     * Метод, возвращающий размер контейнера
     */
    public int size() {
        return this.size;
    }

    /**
     *  Внутренний класс, который представляет одну ссылку в связанном списке,
     *  который содержит один элемент (универсального типа) и
     *  ссылку на следующую ссылку.
     */
    private class Node {
        private E node;
        private Node next;

        public Node(E node, Node next) {
            this.node = node;
            this.next = next;
        }

        public Node(E value, int point) {
        }

        public E getNode() {
            return node;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }

    /**
     * Метод добавляет новый элемент в конец списка:
     * проверяем, есои список пустой, то первому элементу присваиваем
     * при добавлении значение элемента по указателю, а последнему текущее
     * и вставленному элементу присваиваем адрес нового элемента,
     * и ссылку на null
     *
     */
    public void add(E value) {
        if (head == null) {
            head = new Node(value, point);
            size++;
            modCount++;
            return;
        }
        while (tail.next != null) {
            tail = tail.next;
        }
        tail.next = new Node(value, null);
        size++;
        modCount++;
    }

    /**
     * Метод возвращает элемент списка по индексу.
     * @param index полученное значение текущей ячейки
     * @return элемент из нее по индексу
     */
    public E get(int index) {
        Objects.checkIndex(index, size);
        Node next = head;
        while (point != index) {
            next = next.next;
            point++;
        }
        return (E) next.node;
    }

    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {

            /**
             * Значение счетчика на момент создания.
             * Значение элемента на момент создания.
             */
            private int expectedModCount = modCount;
            private Node next = head;

            @Override
            public boolean hasNext() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                return point < size;
            }

            @Override
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                E node = next.node;
                next = next.next;
                point++;
                return node;
            }
        };
    }
}
