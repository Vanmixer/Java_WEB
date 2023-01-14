package com.example.javawebcarrental.service.serviceInterfaces;

import com.example.javawebcarrental.entity.User;

import java.util.List;

public interface UserService {

    User findUser(int id);

    void saveUser(User user);

    void deleteUser(int id);

    void updateUser(User user);

    List<User> findAllUsers();

    void setUserStatus(int id);
}
