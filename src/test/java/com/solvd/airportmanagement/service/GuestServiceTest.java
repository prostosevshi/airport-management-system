package com.solvd.airportmanagement.service;

import com.solvd.airportmanagement.entity.Guest;
import com.solvd.airportmanagement.repository.FakeGuestRepository;
import com.solvd.airportmanagement.service.impl.GuestServiceImpl;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GuestServiceTest {

    private GuestServiceImpl service;

    @BeforeMethod
    public void setUp() {
        service = new GuestServiceImpl(new FakeGuestRepository());
    }

    @Test
    public void shouldCreateGuest() {
        Guest g = new Guest();
        g.setId(1L);

        service.createGuest(g);

        Assert.assertNotNull(
                service.getGuestById(1L),
                "Guest should be found after creation"
        );
    }

    @Test
    public void shouldUpdateGuest() {
        Guest g = new Guest();
        g.setId(1L);
        g.setName("Old");

        service.createGuest(g);

        g.setName("New");
        service.updateGuest(g);

        Assert.assertEquals(
                service.getGuestById(1L).getName(),
                "New",
                "Guest name should be updated"
        );
    }

    @Test
    public void shouldDeleteGuest() {
        Guest g = new Guest();
        g.setId(1L);

        service.createGuest(g);
        service.deleteGuest(1L);

        Assert.assertNull(
                service.getGuestById(1L),
                "Guest should be deleted"
        );
    }

    @Test
    public void shouldReturnAllGuests() {
        Guest g1 = new Guest();
        g1.setId(1L);

        Guest g2 = new Guest();
        g2.setId(2L);

        service.createGuest(g1);
        service.createGuest(g2);

        Assert.assertEquals(
                service.getAllGuests().size(),
                2,
                "Service should return 2 guests"
        );
    }

    @Test
    public void shouldFindGuestById() {
        Guest g = new Guest();
        g.setId(1L);

        service.createGuest(g);

        Assert.assertNotNull(
                service.getGuestById(1L),
                "Guest should be found by id"
        );
    }
}