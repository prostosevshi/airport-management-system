package com.solvd.airportmanagement.strategy;

public class JdbcReportStrategy implements ReportStrategy {
    public void generate() {
        System.out.println("Generating JDBC report");
    }
}
