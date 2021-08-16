package ru.job4j.lsp.parking;

public class TruckCar extends Car {
    public TruckCar(String model, String number, int sizeCar) {
        super(model, number, sizeCar);
    }

    public TruckCar() {
        super();
    }

    public TruckCar(String model, String number) {
        super(model, number);
    }
}
