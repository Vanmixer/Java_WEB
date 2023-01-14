package com.example.javawebcarrental.service.serviceImpl;

import com.example.javawebcarrental.dao.daoImpl.RentDAOImpl;
import com.example.javawebcarrental.dao.daoInterfaces.RentDAO;
import com.example.javawebcarrental.entity.Rent;
import com.example.javawebcarrental.service.serviceInterfaces.RentService;

import java.util.List;

public class RentServiceImpl implements RentService {

    private RentDAO rentDAO = new RentDAOImpl();

    public RentServiceImpl() {
    }

    public Rent findRent(int id) {
        return rentDAO.findById(id);
    }

    public void saveRent(Rent rent) {
        rentDAO.save(rent);
    }

    public void deleteRent(int id) {
        rentDAO.delete(id);
    }

    public void updateRent(Rent rent) {
        rentDAO.update(rent);
    }

    public List<Rent> findAllRents() {
        return rentDAO.findAll();
    }

    public List<Rent> findAllUserRents(int id) {
        return rentDAO.findAllUsersRent(id);
    }
}
