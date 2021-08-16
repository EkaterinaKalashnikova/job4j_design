package ru.job4j.lsp.parking;

public abstract class Car {
    private String model; // марка машины
    private String number; //номер машины
    private int sizeCar = 1; // габариты машины

    public Car(String model, String number, int sizeCar) {
        this.model = model;
        this.number = number;
        this.sizeCar = sizeCar;
    }

    public Car(String model, String number) {
        this.model = model;
        this.number = number;
    }

    public String getModel() {
        return model;
    }

    public String getNumber() {
        return number;
    }

    public int getSizeCar() {
        return sizeCar;
    }
}
