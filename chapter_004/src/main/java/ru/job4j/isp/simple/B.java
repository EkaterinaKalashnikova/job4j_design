package ru.job4j.isp.simple;

public class B {
    private I i;

    public B(I i) {
        this.i = i;
    }

    public void callGetDate() {
        i.getDate();
    }
}
