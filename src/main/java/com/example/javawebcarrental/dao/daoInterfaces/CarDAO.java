package com.example.javawebcarrental.dao.daoInterfaces;

import com.example.javawebcarrental.entity.Car;
import com.example.javawebcarrental.entity.Rent;

import java.util.List;

public interface CarDAO {
    Car findById(int id);
    void save(Car car);
    void update(Car car);
    void delete(int id);
    List<Car> findAllByMark(String mark);
    List<Car> findAllByClass(String carClass);
    List<Car> sortedByPrise(String sorted);
    List<Car> sortedByName(String sorted);
    List<Car> findAll();
}
