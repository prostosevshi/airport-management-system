package com.solvd.airportmanagement.entity;

import java.math.BigDecimal;

public class Product {

    private Long id;
    private Long LunchMenuId;
    private String name;
    private Integer calories;
    private BigDecimal price;
    private boolean fresh;

    //getters & setters
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

    public Integer getCalories() {
        return calories;
    }

    public void setCalories(Integer calories) {
        this.calories = calories;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public boolean isFresh() {
        return fresh;
    }

    public void setFresh(boolean fresh) {
        this.fresh = fresh;
    }


    public Long getLunchMenuId() {
        return LunchMenuId;
    }

    public void setLunchMenuId(Long lunchMenuId) {
        LunchMenuId = lunchMenuId;
    }
}