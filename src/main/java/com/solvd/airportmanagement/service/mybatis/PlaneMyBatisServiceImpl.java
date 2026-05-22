package com.solvd.airportmanagement.service.mybatis;

import com.solvd.airportmanagement.entity.Plane;
import com.solvd.airportmanagement.dao.mybatis.PlaneMapper;
import com.solvd.airportmanagement.service.PlaneService;
import com.solvd.airportmanagement.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class PlaneMyBatisServiceImpl implements PlaneService {

    @Override
    public void createPlane(Plane plane) {

        try (SqlSession session = MyBatisUtil.openSession()) {

            PlaneMapper mapper =
                    session.getMapper(PlaneMapper.class);

            mapper.insert(plane);
        }
    }

    @Override
    public void updatePlane(Plane plane) {

        try (SqlSession session = MyBatisUtil.openSession()) {

            PlaneMapper mapper =
                    session.getMapper(PlaneMapper.class);

            mapper.update(plane);
        }
    }

    @Override
    public void deletePlane(Long id) {

        try (SqlSession session = MyBatisUtil.openSession()) {

            PlaneMapper mapper =
                    session.getMapper(PlaneMapper.class);

            mapper.delete(id);
        }
    }

    @Override
    public Plane getPlaneById(Long id) {

        try (SqlSession session = MyBatisUtil.openSession()) {

            PlaneMapper mapper =
                    session.getMapper(PlaneMapper.class);

            return mapper.findById(id);
        }
    }

    @Override
    public List<Plane> getAllPlanes() {

        try (SqlSession session = MyBatisUtil.openSession()) {

            PlaneMapper mapper =
                    session.getMapper(PlaneMapper.class);

            return mapper.findAll();
        }
    }
}