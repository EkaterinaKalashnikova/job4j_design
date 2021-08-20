package ru.job4j.lsp.parking;

import java.util.*;

import static java.util.Objects.requireNonNull;

public class ParkingCar implements Parking {
    private Car[] placesCars;
    private int countFreePlace;
    private List<Car> cars = new ArrayList<>();
    private List<Car> trucks = new ArrayList<>();

    public ParkingCar(Car[] placesCars) {
        this.placesCars = placesCars;
    }

    public ParkingCar(int a) {
        placesCars = new Car[a];
        countFreePlace = placesCars.length;
    }

    @Override
    public boolean addPark(Car car) {
        if (car.getSizeCar() == 1 && (countFreePlace - car.getSizeCar()) > 0) {
            cars.add(car);
            countFreePlace = countFreePlace - 1;
        } else {
            if (car.getSizeCar() > 1 && (countFreePlace - car.getSizeCar()) > 0) {
                trucks.add(car);
                countFreePlace = countFreePlace - car.getSizeCar();
            } else {
                return false;
            }
        }
        return true;
    }


    public List<Car> parkAllCars() {
        List<Car> allCars = new ArrayList<>();
        allCars.addAll(cars);
        allCars.addAll(trucks);
        return allCars;
    }
}
