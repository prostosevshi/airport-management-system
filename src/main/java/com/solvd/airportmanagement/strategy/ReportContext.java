package com.solvd.airportmanagement.strategy;

public class ReportContext {

    private ReportStrategy strategy;

    public void setStrategy(ReportStrategy strategy) {
        this.strategy = strategy;
    }

    public void generate() {
        strategy.generate();
    }
}
