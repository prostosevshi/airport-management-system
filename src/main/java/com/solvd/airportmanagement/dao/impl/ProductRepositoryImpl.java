package com.solvd.airportmanagement.dao.impl;

import com.solvd.airportmanagement.dao.ProductRepository;
import com.solvd.airportmanagement.entity.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductRepositoryImpl implements ProductRepository {

    private final Connection connection;

    public ProductRepositoryImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void create(Product product) {
        String sql = "INSERT INTO products (name, calories, price, fresh) VALUES (?, ?, ?, ?)";

        try (PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setString(1, product.getName());
            ps.setInt(2, product.getCalories());
            ps.setBigDecimal(3, product.getPrice());
            ps.setBoolean(4, product.isFresh());

            ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(Product product) {
        String sql = "UPDATE products SET name=?, calories=?, price=?, fresh=? WHERE id=?";

        try (PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setString(1, product.getName());
            ps.setInt(2, product.getCalories());
            ps.setBigDecimal(3, product.getPrice());
            ps.setBoolean(4, product.isFresh());
            ps.setLong(5, product.getId());

            ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(Long id) {
        String sql = "DELETE FROM products WHERE id=?";

        try (PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setLong(1, id);

            ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Product findById(Long id) {
        String sql = "SELECT * FROM products WHERE id=?";

        try (PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setLong(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                Product product = new Product();

                product.setId(rs.getLong("id"));
                product.setName(rs.getString("name"));
                product.setCalories(rs.getInt("calories"));
                product.setPrice(rs.getBigDecimal("price"));
                product.setFresh(rs.getBoolean("fresh"));

                return product;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return null;
    }

    @Override
    public List<Product> findAll() {
        String sql = "SELECT * FROM products";

        List<Product> list = new ArrayList<>();

        try (PreparedStatement ps = connection.prepareStatement(sql)) {

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Product product = new Product();

                product.setId(rs.getLong("id"));
                product.setName(rs.getString("name"));
                product.setCalories(rs.getInt("calories"));
                product.setPrice(rs.getBigDecimal("price"));
                product.setFresh(rs.getBoolean("fresh"));

                list.add(product);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return list;
    }
}