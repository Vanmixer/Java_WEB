package com.example.javawebcarrental.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "rent")
public class Rent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "start_date")
    private LocalDateTime startDate;
    @Column(name = "end_date")
    private LocalDateTime deadline;
    @Column(name = "with_driver")
    private boolean withDriver;
    @Column(name = "prise")
    private BigDecimal prise;
    @Column(name = "massage")
    private String massage;
    @Column(name = "is_active")
    private boolean isActive;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "car_id")
    private Car car;

    public Rent() {
    }

    public Rent(int id, LocalDateTime startDate, LocalDateTime deadline, boolean withDriver, BigDecimal prise, String massage, boolean isActive, User user, Car car) {
        this.id = id;
        this.startDate = startDate;
        this.deadline = deadline;
        this.withDriver = withDriver;
        this.prise = prise;
        this.massage = massage;
        this.isActive = isActive;
        this.user = user;
        this.car = car;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalDateTime deadline) {
        this.deadline = deadline;
    }

    public boolean isWithDriver() {
        return withDriver;
    }

    public void setWithDriver(boolean withDriver) {
        this.withDriver = withDriver;
    }

    public BigDecimal getPrise() {
        return prise;
    }

    public void setPrise(BigDecimal prise) {
        this.prise = prise;
    }

    public String getMassage() {
        return massage;
    }

    public void setMassage(String massage) {
        this.massage = massage;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    @Override
    public String toString() {
        return "Rent{" +
                "id=" + id +
                ", startDate=" + startDate +
                ", deadline=" + deadline +
                ", withDriver=" + withDriver +
                ", prise=" + prise +
                ", massage='" + massage + '\'' +
                ", isActive=" + isActive +
                ", user=" + user +
                ", car=" + car +
                '}';
    }
}
