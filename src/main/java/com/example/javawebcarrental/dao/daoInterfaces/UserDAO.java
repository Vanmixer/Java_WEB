package com.example.javawebcarrental.dao.daoInterfaces;

import com.example.javawebcarrental.entity.User;

import java.util.List;

public interface UserDAO {
    User findById(int id);
    void save(User user);
    void update(User user);
    void delete(int id);
    List<User> findAll();
    void blockUser(int id);
}
