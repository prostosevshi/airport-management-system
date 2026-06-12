package com.solvd.airportmanagement.dao.mybatisimpl;

import com.solvd.airportmanagement.dao.ProductRepository;
import com.solvd.airportmanagement.entity.Product;
import com.solvd.airportmanagement.mapper.ProductMapper;
import com.solvd.airportmanagement.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class ProductRepositoryMyBatisImpl implements ProductRepository {

    @Override
    public void create(Product product) {
        try (SqlSession session = MyBatisUtil.openSession()) {
            session.getMapper(ProductMapper.class).insert(product);
        }
    }

    @Override
    public void update(Product product) {
        try (SqlSession session = MyBatisUtil.openSession()) {
            session.getMapper(ProductMapper.class).update(product);
        }
    }

    @Override
    public void delete(Long id) {
        try (SqlSession session = MyBatisUtil.openSession()) {
            session.getMapper(ProductMapper.class).delete(id);
        }
    }

    @Override
    public Product findById(Long id) {
        try (SqlSession session = MyBatisUtil.openSession()) {
            return session.getMapper(ProductMapper.class).findById(id);
        }
    }

    @Override
    public List<Product> findAll() {
        try (SqlSession session = MyBatisUtil.openSession()) {
            return session.getMapper(ProductMapper.class).findAll();
        }
    }
}