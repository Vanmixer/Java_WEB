package com.example.javawebcarrental.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name ="first_name")
    private String firstName;
    @Column(name ="last_name")
    private String lastName;
    @Column(name ="user_role")
    private String userRole;
    @Column(name ="user_count_of_money")
    private BigDecimal moneyCount;
    @Column(name ="is_active")
    private boolean active;
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Rent> rentList;

    public User() {
    }

    public User(int id, String firstName, String lastName, String userRole, BigDecimal moneyCount, boolean active, List<Rent> rentList) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.userRole = userRole;
        this.moneyCount = moneyCount;
        this.active = active;
        this.rentList = rentList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    public BigDecimal getMoneyCount() {
        return moneyCount;
    }

    public void setMoneyCount(BigDecimal moneyCount) {
        this.moneyCount = moneyCount;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public List<Rent> getRentList() {
        return rentList;
    }

    public void setRentList(List<Rent> rentList) {
        this.rentList = rentList;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", userRole='" + userRole + '\'' +
                ", moneyCount=" + moneyCount +
                ", active=" + active +
                '}';
    }
}
