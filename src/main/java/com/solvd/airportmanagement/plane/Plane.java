package com.solvd.airportmanagement.plane;

import com.solvd.airportmanagement.menu.LunchMenu;
import com.solvd.airportmanagement.person.Guest;

import java.util.ArrayList;

public abstract class Plane {

    protected String model;
    protected int numberOfEngines;
    protected int numberOfSeats;
    protected LunchMenu lunchMenu;
    protected ArrayList<Guest> guests = new ArrayList<>();

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getNumberOfEngines() {
        return numberOfEngines;
    }

    public void setNumberOfEngines(int numberOfEngines) {
        this.numberOfEngines = numberOfEngines;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public LunchMenu getLunchMenu() {
        return lunchMenu;
    }

    public void setLunchMenu(LunchMenu lunchMenu) {
        this.lunchMenu = lunchMenu;
    }

    public ArrayList<Guest> getGuests() {
        return guests;
    }

    public void setGuests(ArrayList<Guest> guests) {
        this.guests = guests;
    }
}
