package com.solvd.airportmanagement.dao.mybatisimpl;

import com.solvd.airportmanagement.dao.GuestRepository;
import com.solvd.airportmanagement.entity.Guest;
import com.solvd.airportmanagement.mapper.GuestMapper;
import com.solvd.airportmanagement.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class GuestRepositoryMyBatisImpl implements GuestRepository {

    @Override
    public void create(Guest guest) {
        try (SqlSession session = MyBatisUtil.openSession()) {
            session.getMapper(GuestMapper.class).insert(guest);
        }
    }

    @Override
    public void update(Guest guest) {
        try (SqlSession session = MyBatisUtil.openSession()) {
            session.getMapper(GuestMapper.class).update(guest);
        }
    }

    @Override
    public void delete(Long id) {
        try (SqlSession session = MyBatisUtil.openSession()) {
            session.getMapper(GuestMapper.class).delete(id);
        }
    }

    @Override
    public Guest findById(Long id) {
        try (SqlSession session = MyBatisUtil.openSession()) {
            return session.getMapper(GuestMapper.class).findById(id);
        }
    }

    @Override
    public List<Guest> findAll() {
        try (SqlSession session = MyBatisUtil.openSession()) {
            return session.getMapper(GuestMapper.class).findAll();
        }
    }
}