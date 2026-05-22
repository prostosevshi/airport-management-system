package com.solvd.airportmanagement.dao.mybatis;

import com.solvd.airportmanagement.entity.Product;
import java.util.List;

public interface ProductMapper {

    void insert(Product product);

    void update(Product product);

    void delete(Long id);

    Product findById(Long id);

    List<Product> findAll();

    List<Product> findByLunchMenuId(Long lunchMenuId);
}