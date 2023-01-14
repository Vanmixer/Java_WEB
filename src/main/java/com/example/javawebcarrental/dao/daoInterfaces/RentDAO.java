package com.example.javawebcarrental.dao.daoInterfaces;

import com.example.javawebcarrental.entity.Rent;

import java.util.List;

public interface RentDAO {
    Rent findById(int id);
    void save(Rent rent);
    void update(Rent rent);
    void delete(int id);
    List<Rent> findAll();
    List<Rent> findAllUsersRent(int id);
}
