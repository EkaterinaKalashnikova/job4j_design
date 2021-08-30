package ru.job4j.isp.simplesolution;

public class A {
    private I1 i1;

    public A(I1 i1) {
        this.i1 = i1;
    }

    public void callGetName() {
        System.out.println(i1.getName());
    }
}
