package com.solvd.airportmanagement.menu.food;

import java.math.BigDecimal;

public class Product {

    private int id;
    private String name;
    private Integer calories;
    private BigDecimal price;
    private boolean fresh;

    //getters & setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    protected String getName() {
        return name;
    }

    protected void setName(String name) {
        this.name = name;
    }

    protected Integer getCalories() {
        return calories;
    }

    protected void setCalories(Integer calories) {
        this.calories = calories;
    }

    protected BigDecimal getPrice() {
        return price;
    }

    protected void setPrice(BigDecimal price) {
        this.price = price;
    }

    public boolean isFresh() {
        return fresh;
    }

    public void setFresh(boolean fresh) {
        this.fresh = fresh;
    }
}