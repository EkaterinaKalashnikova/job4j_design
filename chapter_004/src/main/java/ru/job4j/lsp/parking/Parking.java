package ru.job4j.lsp.parking;

import java.util.List;

public interface Parking {
    //зарегистрировать и записать номер
    Car register(String number);

    //добавить в список парковочных мест согласно габариту машины
    boolean addPark(Car car);

    //показать все машины на парковке
    List<Car> parkAllCars();
}
