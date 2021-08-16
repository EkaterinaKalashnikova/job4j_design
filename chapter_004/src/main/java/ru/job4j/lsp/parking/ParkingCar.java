package ru.job4j.lsp.parking;

import java.util.List;

public class ParkingCar implements Parking {
    //Car[] placeCar = new Car[20];
    private Car[] placePassengerCar;
    private Car[] placeTruckCar;

    public ParkingCar(int a, int b) {
        placePassengerCar = new Car[a];
        placeTruckCar = new Car[b];
    }

    @Override
    public Car register(String number) {
        return null;
    }

    @Override
    public boolean addPark(Car car) {
        return false;
    }

    @Override
    public Car parkCar(Car car) {
        return car;
    }

    @Override
    public List<Car> parkAllCars() {
        return null;
    }
}
