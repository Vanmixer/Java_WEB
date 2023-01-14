package com.example.javawebcarrental.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "car")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "mark")
    private String mark;
    @Column(name = "name")
    private String carName;
    @Column(name = "car_class")
    private String carClass;
    @Column(name ="car_prise")
    private BigDecimal carPrise;
    @OneToMany(mappedBy = "car",fetch = FetchType.LAZY)
    private List<Rent> rentList;

    public Car() {
    }

    public Car(int id, String mark, String carName, String carClass, BigDecimal carPrise, List<Rent> rentList) {
        this.id = id;
        this.mark = mark;
        this.carName = carName;
        this.carClass = carClass;
        this.carPrise = carPrise;
        this.rentList = rentList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public String getCarClass() {
        return carClass;
    }

    public void setCarClass(String carClass) {
        this.carClass = carClass;
    }

    public BigDecimal getCarPrise() {
        return carPrise;
    }

    public void setCarPrise(BigDecimal carPrise) {
        this.carPrise = carPrise;
    }

    public List<Rent> getRentList() {
        return rentList;
    }

    public void setRentList(List<Rent> rentList) {
        this.rentList = rentList;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", mark='" + mark + '\'' +
                ", carName='" + carName + '\'' +
                ", carClass='" + carClass + '\'' +
                ", carPrise=" + carPrise +
                '}';
    }
}
