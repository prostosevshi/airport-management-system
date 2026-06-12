package com.solvd.airportmanagement.dao.mybatisimpl;

import com.solvd.airportmanagement.dao.AirportRepository;
import com.solvd.airportmanagement.entity.Airport;
import com.solvd.airportmanagement.mapper.AirportMapper;
import com.solvd.airportmanagement.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class AirportRepositoryMyBatisImpl implements AirportRepository {

    @Override
    public void create(Airport airport) {

        try (SqlSession session = MyBatisUtil.openSession()) {

            AirportMapper mapper =
                    session.getMapper(AirportMapper.class);

            mapper.insert(airport);
        }
    }

    @Override
    public void update(Airport airport) {

        try (SqlSession session = MyBatisUtil.openSession()) {

            AirportMapper mapper =
                    session.getMapper(AirportMapper.class);

            mapper.update(airport);
        }
    }

    @Override
    public void delete(Long id) {

        try (SqlSession session = MyBatisUtil.openSession()) {

            AirportMapper mapper =
                    session.getMapper(AirportMapper.class);

            mapper.delete(id);
        }
    }

    @Override
    public Airport findById(Long id) {

        try (SqlSession session = MyBatisUtil.openSession()) {

            AirportMapper mapper =
                    session.getMapper(AirportMapper.class);

            return mapper.findById(id);
        }
    }

    @Override
    public List<Airport> findAll() {

        try (SqlSession session = MyBatisUtil.openSession()) {

            AirportMapper mapper =
                    session.getMapper(AirportMapper.class);

            return mapper.findAll();
        }
    }
}