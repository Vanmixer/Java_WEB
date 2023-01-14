package com.example.javawebcarrental.service.serviceImpl;

import com.example.javawebcarrental.dao.daoImpl.CarDAOImpl;
import com.example.javawebcarrental.dao.daoInterfaces.CarDAO;
import com.example.javawebcarrental.entity.Car;
import com.example.javawebcarrental.service.serviceInterfaces.CarService;

import java.util.List;

public class CarServiceImpl implements CarService {

    private CarDAO carDAO = new CarDAOImpl();

    public CarServiceImpl() {
    }

    public Car findCar(int id) {
        return carDAO.findById(id);
    }

    public void saveCar(Car car) {
        carDAO.save(car);
    }

    public void deleteCar(int id) {
        carDAO.delete(id);
    }

    public void updateCar(Car car) {
        carDAO.update(car);
    }

    public List<Car> findAllCars() {
        return carDAO.findAll();
    }

    public List<Car> findAllCarsByMark(String mark){
        return carDAO.findAllByMark(mark);
    }

    public List<Car> findAllByClass(String carClass){
        return carDAO.findAllByClass(carClass);
    }

    public List<Car> sortedByPrise(String sorted){
        return carDAO.sortedByPrise(sorted);
    }

    public List<Car> sortedByName(String sorted){
        return carDAO.sortedByName(sorted);
    }
}
