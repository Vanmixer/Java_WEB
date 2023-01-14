package com.example.javawebcarrental.service.serviceInterfaces;

import com.example.javawebcarrental.entity.Car;

import java.util.List;

public interface CarService {
    Car findCar(int id);

    void saveCar(Car car);

    void deleteCar(int id);

    void updateCar(Car car);

    List<Car> findAllCars();

    List<Car> findAllCarsByMark(String mark);

    List<Car> findAllByClass(String carClass);

    List<Car> sortedByPrise(String sorted);

    List<Car> sortedByName(String sorted);
}
