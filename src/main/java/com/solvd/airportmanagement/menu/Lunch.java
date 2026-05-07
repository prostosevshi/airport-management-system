package com.solvd.airportmanagement.menu;

import com.solvd.airportmanagement.menu.food.Product;

import java.util.List;

public class Lunch {

    private List<Product> products;

    public Lunch(List<Product> products) {
        this.products = products;
    }

    //getters & setters
    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
