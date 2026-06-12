package com.solvd.airportmanagement.dao.jdbcimpl;

import com.solvd.airportmanagement.dao.ProductRepository;
import com.solvd.airportmanagement.entity.Product;
import com.solvd.airportmanagement.util.ConnectionPool;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductRepositoryImpl implements ProductRepository {

    private final ConnectionPool connectionPool =
            ConnectionPool.getInstance();

    @Override
    public void create(Product product) {

        Connection connection = connectionPool.getConnection();

        String sql = "INSERT INTO products (name, calories, price, fresh, lunch_menu_id) VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setString(1, product.getName());
            ps.setInt(2, product.getCalories());
            ps.setBigDecimal(3, product.getPrice());
            ps.setBoolean(4, product.isFresh());
            ps.setLong(5, product.getLunchMenuId());

            ps.executeUpdate();

        } catch (SQLException e) {

            throw new RuntimeException(e);

        } finally {

            connectionPool.releaseConnection(connection);
        }
    }

    @Override
    public void update(Product product) {

        Connection connection = connectionPool.getConnection();

        String sql = "UPDATE products SET name=?, calories=?, price=?, fresh=?, lunch_menu_id=? WHERE id=?";

        try (PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setString(1, product.getName());
            ps.setInt(2, product.getCalories());
            ps.setBigDecimal(3, product.getPrice());
            ps.setBoolean(4, product.isFresh());
            ps.setLong(5, product.getLunchMenuId());
            ps.setLong(6, product.getId());

            ps.executeUpdate();

        } catch (SQLException e) {

            throw new RuntimeException(e);

        } finally {

            connectionPool.releaseConnection(connection);
        }
    }

    @Override
    public void delete(Long id) {

        Connection connection = connectionPool.getConnection();

        String sql = "DELETE FROM products WHERE id=?";

        try (PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setLong(1, id);

            ps.executeUpdate();

        } catch (SQLException e) {

            throw new RuntimeException(e);

        } finally {

            connectionPool.releaseConnection(connection);
        }
    }

    @Override
    public Product findById(Long id) {

        Connection connection = connectionPool.getConnection();

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
                product.setLunchMenuId(rs.getLong("lunch_menu_id"));

                return product;
            }

            return null;

        } catch (SQLException e) {

            throw new RuntimeException(e);

        } finally {

            connectionPool.releaseConnection(connection);
        }
    }

    @Override
    public List<Product> findAll() {

        Connection connection = connectionPool.getConnection();

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
                product.setLunchMenuId(rs.getLong("lunch_menu_id"));

                list.add(product);
            }

            return list;

        } catch (SQLException e) {

            throw new RuntimeException(e);

        } finally {

            connectionPool.releaseConnection(connection);
        }
    }
}