package ru.job4j.parking;

import org.junit.Assert;
import org.junit.Test;
import ru.job4j.lsp.parking.*;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class ParkingCarTest {

    @Test
    public void whenParkAllCars() {
        Parking parking = new ParkingCar(10, 4);
        Car car1 = new PassengerCar("Hyundai", 123);
        Car car2 = new TruckCar("Mercedes-Benz", 897, 2);
        Assert.assertTrue(parking.addPark(car1));
        Assert.assertTrue(parking.addPark(car2));
        List<Car> allCars = parking.parkAllCars();
        Assert.assertTrue(allCars.contains(car1));
        Assert.assertTrue(allCars.contains(car2));
    }

    @Test
    public void whenParkNotCars() {
        Parking parking = new ParkingCar(0, 0);
        Car car1 = new PassengerCar("Toyota", 843);
        Car car2 = new TruckCar("Scania", 356, 3);
        Assert.assertFalse(parking.addPark(car1));
        Assert.assertFalse(parking.addPark(car2));
    }

    @Test
    public void whenTruckCarParkEnPlacePassengerCar() {
        Parking parking = new ParkingCar(8, 0);
        Car car1 = new PassengerCar("Mazda", 607);
        Car car2 = new TruckCar("MAN", 393, 2);
        parking.addPark(car1);
        parking.addPark(car2);
        List<Car> allCars = parking.parkAllCars();
        Assert.assertTrue(allCars.contains(car2));
    }

    @Test
    public void whenTruckCarParkNotParking() {
        Parking parking = new ParkingCar( 3, 0);
        Car car1 = new PassengerCar("Mazda", 607);
        Car car2 = new TruckCar("MAN", 393, 10);
        parking.addPark(car1);
        parking.addPark(car2);
        List<Car> allCars = parking.parkAllCars();
        Assert.assertFalse(allCars.contains(car2));
    }
}