package com.example.javawebcarrental.service.serviceInterfaces;

import com.example.javawebcarrental.entity.Rent;

import java.util.List;

public interface RentService {
    Rent findRent(int id);

    void saveRent(Rent rent);

    void deleteRent(int id);

    void updateRent(Rent rent);

    List<Rent> findAllRents();

    List<Rent> findAllUserRents(int id);
}
