package ru.job4j.collection;

public class SimpleStack<T> {
    private ForwardLinked<T> linked = new ForwardLinked<T>();
    private int size;

    public int size() {
        return this.size;
    }

    public T pop() {
        T value;
        value = linked.deleteLast();
        size--;
        return value;
    }

    public void push(T value) {
      this.linked.add(value);
      size++;
    }
}