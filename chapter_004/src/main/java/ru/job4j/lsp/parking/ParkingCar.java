package ru.job4j.lsp.parking;

import java.util.*;

public class ParkingCar implements Parking {
    private Car[] placesPassengerCars;
    private Car[] placesTruckCars;
    private int countFreePlace;
    private int countTruckPlace;
    private List<Car> cars = new ArrayList<>();
    private List<Car> trucks = new ArrayList<>();

//    public ParkingCar(Car[] placesCars) {
//        this.placesCars = placesCars;
//    }

    /**
     * @param a количество легковых парковочных мест
     * @param b количество грузовых парковочных мест
     */
    public ParkingCar(int a, int b) {
        placesPassengerCars = new Car[a];
        countFreePlace = placesPassengerCars.length;
        placesTruckCars = new Car[b];
        countTruckPlace = placesTruckCars.length;
    }

    @Override
    public boolean addPark(Car car) {
        if (car.getSizeCar() == 1 && (countFreePlace - car.getSizeCar()) > 0) {
            cars.add(car);
            countFreePlace = countFreePlace - 1;
        } else if (car.getSizeCar() > 1 && (countTruckPlace - 1) > 0) {
            trucks.add(car);
            countTruckPlace = countTruckPlace - 1;
        } else if (car.getSizeCar() > 1 && (countFreePlace - car.getSizeCar()) > 0) {
            trucks.add(car);
            countFreePlace = countFreePlace - car.getSizeCar();
        } else {
            return false;
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
