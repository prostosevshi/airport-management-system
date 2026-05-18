package com.solvd.airportmanagement.dao;

import java.util.List;
import java.util.Map;

public interface ReportRepository {

    List<Map<String, Object>> getFullAirportReport();
}