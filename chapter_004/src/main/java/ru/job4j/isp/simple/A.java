package ru.job4j.isp.simple;

public class A {
    private I i;

    public A(I i) {
        this.i = i;
    }

    public void callGetName() {
        System.out.println(i.getName());
    }
}
