package com.example.javawebcarrental.controller;

import com.example.javawebcarrental.entity.Rent;
import com.example.javawebcarrental.service.serviceImpl.CarServiceImpl;
import com.example.javawebcarrental.service.serviceImpl.RentServiceImpl;
import com.example.javawebcarrental.service.serviceImpl.UserServiceImpl;
import com.example.javawebcarrental.service.serviceInterfaces.CarService;
import com.example.javawebcarrental.service.serviceInterfaces.RentService;
import com.example.javawebcarrental.service.serviceInterfaces.UserService;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class RentController{

    RentService rentService = new RentServiceImpl();
    CarService carService = new CarServiceImpl();
    UserService userService = new UserServiceImpl();

    public void testRentController(){
        Rent rent = new Rent();
        rent.setCar(carService.findCar(2));
        rent.setUser(userService.findUser(2));
        rent.setWithDriver(true);
        rent.setActive(true);
        rent.setStartDate(LocalDateTime.now());
        rent.setDeadline(LocalDateTime.now().plusDays(3L));
        rent.setPrise(BigDecimal.valueOf(24_000.00));
        rentService.saveRent(rent);

        System.out.println(rentService.findRent(1));

        System.out.println(rentService.findAllRents());
    }


}
