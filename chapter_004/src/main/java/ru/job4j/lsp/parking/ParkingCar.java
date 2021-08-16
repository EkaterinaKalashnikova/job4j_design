package ru.job4j.lsp.parking;

import java.util.List;

public class ParkingCar implements Parking {

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
