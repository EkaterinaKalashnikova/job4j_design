package ru.job4j.lsp.parking;

import java.util.Objects;

public abstract class Car {
    private String model; // марка машины
    private int number; //номер машины
    private int sizeCar = 1; // габариты машины

    public Car(String model, int number, int sizeCar) {
        this.model = model;
        this.number = number;
        this.sizeCar = sizeCar;
    }

    public Car(String model, int number) {
        this.model = model;
        this.number = number;
    }

    public String getModel() {
        return model;
    }

    public int getNumber() {
        return number;
    }

    public int getSizeCar() {
        return sizeCar;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Car)) {
            return false;
        }
        Car car = (Car) o;
        return getSizeCar() == car.getSizeCar() && Objects.equals(getModel(), car.getModel()) && Objects.equals(getNumber(), car.getNumber());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getModel(), getNumber(), getSizeCar());
    }

    @Override
    public String toString() {
        return "Car{"
                + "model='"
                + model
                + '\''
                + ", number='" + number + '\''
                + ", sizeCar=" + sizeCar
                + '}';
    }
}
