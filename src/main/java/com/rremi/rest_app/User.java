package com.rremi.rest_app;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity //the user represents the customer
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private String name;
    @NotNull
    private String email;

    private String password;
    private double balance;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "bidder", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    private List<Order> customerOrders = new ArrayList<>(); //a list of user's orders

    @OneToMany(mappedBy = "itemOwner", fetch = FetchType.LAZY,
            cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    @JsonManagedReference
    private List<Item> customerItems = new ArrayList<>(); //a list of user's items

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public List<Order> getCustomerOrders() {
        return customerOrders;
    }

    public void setCustomerOrders(Order o) {
        this.customerOrders.add(o);
    }

    public List<Item> getCustomerItems() {
        return customerItems;
    }

    public void setCustomerItems(Item i) {
        this.customerItems.add(i);
    }

    @Override
    public String toString() {
        return "Item id"+getId();
    }
}