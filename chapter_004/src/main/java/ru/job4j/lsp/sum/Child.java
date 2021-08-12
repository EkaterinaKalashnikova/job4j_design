package ru.job4j.lsp.sum;

public class Child extends Parent {

    @Override
    public void doSmth() {
       throw new RuntimeException();
    }
}
