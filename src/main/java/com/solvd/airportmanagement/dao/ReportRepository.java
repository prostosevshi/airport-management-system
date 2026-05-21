package com.solvd.airportmanagement.dao;

import com.solvd.airportmanagement.entity.Airport;

public interface ReportRepository {

    Airport getFullAirportReport(Long airportId);
}