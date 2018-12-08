package com.rremi.rest_app.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private String name;
    private String description;//an item might not have a description
    @NotNull
    private double price;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonBackReference
    @NotNull
    private User itemOwner;

    @OneToMany(mappedBy = "orderedItem",cascade = {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.REMOVE})
    private List<Order> itemOrders = new ArrayList<Order>();

    //constructor for JPA
    protected Item(){}

    public Item(String name, String description, double price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public User getItemOwner() {
        return itemOwner;
    }

    public void setItemOwner(User itemOwner) {
        this.itemOwner = itemOwner;
    }

    public List<Order> getItemOrders() {
        return itemOrders;
    }

    public void addOrder(Order o) {
        this.itemOrders.add(o);
    }

    @Override
    public String toString() {
        return "Item id : "+id+",Item name :"+name+",Item description "+description+" Item owner id :"+itemOwner.getId();
    }
}
