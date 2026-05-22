package com.solvd.airportmanagement.service.mybatis;

import com.solvd.airportmanagement.entity.Airport;
import com.solvd.airportmanagement.dao.mybatis.AirportMapper;
import com.solvd.airportmanagement.service.AirportService;
import com.solvd.airportmanagement.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class AirportMyBatisServiceImpl implements AirportService {

    @Override
    public void createAirport(Airport airport) {

        try (SqlSession session = MyBatisUtil.openSession()) {

            AirportMapper mapper =
                    session.getMapper(AirportMapper.class);

            mapper.insert(airport);
        }
    }

    @Override
    public List<Airport> getAll() {

        try (SqlSession session = MyBatisUtil.openSession()) {

            AirportMapper mapper =
                    session.getMapper(AirportMapper.class);

            return mapper.findAll();
        }
    }
}