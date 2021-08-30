package ru.job4j.isp.simplesolution;

public class B {
    private I2 i2;


    public B(I2 i2) {
        this.i2 = i2;
    }

    public void callGetDate() {
        i2.getDate();
    }
}
