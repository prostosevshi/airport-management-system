package com.solvd.airportmanagement.dao;

import com.solvd.airportmanagement.entity.Product;

import java.util.List;

public interface ProductRepository {

    void create(Product product);

    void update(Product product);

    void delete(Long id);

    Product findById(Long id);

    List<Product> findAll();
}
