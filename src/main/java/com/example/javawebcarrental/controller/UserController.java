package com.example.javawebcarrental.controller;

import com.example.javawebcarrental.entity.User;
import com.example.javawebcarrental.service.serviceImpl.UserServiceImpl;
import com.example.javawebcarrental.service.serviceInterfaces.UserService;

import java.math.BigDecimal;

public class UserController {

    private UserService userService = new UserServiceImpl();

    public void testUserService(){
        User user = new User();
        user.setFirstName("Test1");
        user.setLastName("Test1");
        user.setUserRole("USER");
        user.setMoneyCount(BigDecimal.ZERO);
        user.setActive(true);
        userService.saveUser(user);

        userService.findUser(1).toString();

        User user2 = new User();
        user2.setFirstName("Test2");
        user2.setLastName("Test2");
        user2.setUserRole("USER");
        user2.setMoneyCount(BigDecimal.ZERO);
        user2.setActive(true);
        userService.saveUser(user2);

        System.out.println(userService.findAllUsers());

        userService.setUserStatus(2);

        System.out.println(userService.findAllUsers());

        userService.deleteUser(1);

        System.out.println(userService.findAllUsers());
    }
}
