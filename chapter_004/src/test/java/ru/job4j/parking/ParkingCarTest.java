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
        Car car1 = new TruckCar();
        Car car2 = new PassengerCar();
        Car car3 = new PassengerCar();
        Car car4 = new PassengerCar();
        Parking parking = new ParkingCar();
        parking.addPark(car1);
        parking.addPark(car2);
        parking.addPark(car3);
        parking.addPark(car4);
        List<Car> allCar = parking.parkAllCars();
        List<Car> expected = List.of(car1, car2, car3, car4);
        assertThat(expected, is(allCar));
    }

    @Test
    public void whenParkAddCarOnRegistr() {
        Parking parking = new ParkingCar();
        Car car = new PassengerCar("Suzuki", "458");
        Assert.assertTrue(parking.addPark(car));
    }

    @Test
    public void whenParkNotCars() {
        Parking parking = new ParkingCar();
        Car car = new TruckCar("Scania", "356");
        Assert.assertFalse(parking.addPark(car));
    }

    @Test
    public void parkOnlyTruckCarsPlace() {
        Parking parking = new ParkingCar();
        Car car1 = new PassengerCar("Hyundai", "123");
        Car car2 = new TruckCar("Mercedes-Benz", "897");
        parking.addPark(car1);
        parking.addPark(car2);
        Car expected = parking.parkCar(car2);
        Assert.assertEquals(expected, car2);

    }

    @Test
    public void parkOnlyPassengerCarsPlace() {
        Parking parking = new ParkingCar();
        Car car1 = new PassengerCar("Mazda", "607");
        Car car2 = new TruckCar("MAN", "393");
        Car car3 = new PassengerCar("Kia", "770");
        parking.addPark(car1);
        parking.addPark(car2);
        parking.addPark(car3);
        Car expected = parking.parkCar(car1);
        Car expected1 = parking.parkCar(car1);
        Assert.assertEquals(expected, car1);
        Assert.assertEquals(expected1, car3);
    }

    @Test
    public void whenRegisterByNumber() {
        Parking parking = new ParkingCar();
        Car car = new PassengerCar("Toyota", "843");
        parking.addPark(car);
        Car expected = parking.register(car.toString());
        Assert.assertThat(expected, is(car));
    }
}