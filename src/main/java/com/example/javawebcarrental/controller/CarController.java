package com.example.javawebcarrental.controller;

import com.example.javawebcarrental.entity.Car;
import com.example.javawebcarrental.service.serviceImpl.CarServiceImpl;
import com.example.javawebcarrental.service.serviceInterfaces.CarService;

import java.math.BigDecimal;

public class CarController {

    private CarService carService = new CarServiceImpl();

    public void testCarService(){
        Car car = new Car();
        car.setCarName("C-Class 200 EQ Boost 9G-Tronic");
        car.setCarClass("A");
        car.setMark("Mercedes-Benz");
        car.setCarPrise(BigDecimal.valueOf(10_000.00));
        carService.saveCar(car);

        System.out.println(carService.findCar(1));

        Car car2 = new Car();
        car2.setCarName("X5");
        car2.setCarClass("A");
        car2.setMark("BMV");
        car2.setCarPrise(BigDecimal.valueOf(8_000.00));
        carService.saveCar(car2);

        System.out.println(carService.findCar(2));

        System.out.println(carService.findAllCarsByMark("Mercedes-Benz"));

        carService.deleteCar(1);

        System.out.println(carService.findAllCars());
    }
}
