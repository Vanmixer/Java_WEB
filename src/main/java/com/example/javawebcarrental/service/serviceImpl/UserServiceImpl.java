package com.example.javawebcarrental.service.serviceImpl;

import com.example.javawebcarrental.dao.daoImpl.UserDAOImpl;
import com.example.javawebcarrental.dao.daoInterfaces.UserDAO;
import com.example.javawebcarrental.entity.User;
import com.example.javawebcarrental.service.serviceInterfaces.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {

    private UserDAO usersDao = new UserDAOImpl();

    public UserServiceImpl() {
    }

    public User findUser(int id) {
        return usersDao.findById(id);
    }

    public void saveUser(User user) {
        usersDao.save(user);
    }

    public void deleteUser(int id) {
        usersDao.delete(id);
    }

    public void updateUser(User user) {
        usersDao.update(user);
    }

    public List<User> findAllUsers() {
        return usersDao.findAll();
    }

    public void setUserStatus(int id){
        usersDao.blockUser(id);
    }
}
