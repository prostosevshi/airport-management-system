package com.solvd.airportmanagement.menu;

import com.solvd.airportmanagement.menu.food.Product;

import java.util.List;

public class LunchMenu {

    private long id;
    private List<Product> products;

    public LunchMenu(List<Product> products) {
        this.products = products;
    }

    //getters & setters
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
