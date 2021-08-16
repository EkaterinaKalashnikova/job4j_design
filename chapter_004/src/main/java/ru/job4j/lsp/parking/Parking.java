package ru.job4j.lsp.parking;

import java.util.List;

public interface Parking {
    //зарегистрировать и записать номер
    Car register(String number);

    //добавить в список парковочных мест
    boolean addPark(Car car);

    //припарковать с выбором места на парковке согласно габариту машины
    Car parkCar(Car car);

    //показать все машины на парковке
    List<Car> parkAllCars();
}
