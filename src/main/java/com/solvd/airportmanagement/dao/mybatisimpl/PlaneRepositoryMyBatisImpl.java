package com.solvd.airportmanagement.dao.mybatisimpl;

import com.solvd.airportmanagement.dao.PlaneRepository;
import com.solvd.airportmanagement.entity.Plane;
import com.solvd.airportmanagement.mapper.PlaneMapper;
import com.solvd.airportmanagement.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class PlaneRepositoryMyBatisImpl implements PlaneRepository {

    @Override
    public void create(Plane plane) {
        try (SqlSession session = MyBatisUtil.openSession()) {
            session.getMapper(PlaneMapper.class).insert(plane);
        }
    }

    @Override
    public void update(Plane plane) {
        try (SqlSession session = MyBatisUtil.openSession()) {
            session.getMapper(PlaneMapper.class).update(plane);
        }
    }

    @Override
    public void delete(Long id) {
        try (SqlSession session = MyBatisUtil.openSession()) {
            session.getMapper(PlaneMapper.class).delete(id);
        }
    }

    @Override
    public Plane findById(Long id) {
        try (SqlSession session = MyBatisUtil.openSession()) {
            return session.getMapper(PlaneMapper.class).findById(id);
        }
    }

    @Override
    public List<Plane> findAll() {
        try (SqlSession session = MyBatisUtil.openSession()) {
            return session.getMapper(PlaneMapper.class).findAll();
        }
    }
}