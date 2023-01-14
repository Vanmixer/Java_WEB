package com.example.javawebcarrental;

import com.example.javawebcarrental.controller.CarController;
import com.example.javawebcarrental.controller.RentController;
import com.example.javawebcarrental.controller.UserController;

public class Main {
    public static void main(String[] args) {
        UserController userController = new UserController();
        CarController carController = new CarController();
        RentController rentController = new RentController();

        userController.testUserService();
        carController.testCarService();
        rentController.testRentController();
    }
}
