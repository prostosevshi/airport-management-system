package com.solvd.airportmanagement.service;

import com.solvd.airportmanagement.entity.CardPayment;
import com.solvd.airportmanagement.repository.FakeCardPaymentRepository;
import com.solvd.airportmanagement.service.impl.CardPaymentServiceImpl;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.math.BigDecimal;
import java.util.List;

public class CardPaymentServiceTest {

    private CardPaymentServiceImpl service;

    @BeforeMethod
    public void setUp() {
        service = new CardPaymentServiceImpl(new FakeCardPaymentRepository());
    }

    @Test
    public void shouldCreatePayment() {
        CardPayment p = new CardPayment();
        p.setId(1L);

        service.createPayment(p);

        Assert.assertNotNull(service.getPaymentById(1L));
    }

    @Test
    public void shouldUpdatePayment() {
        CardPayment p = new CardPayment();
        p.setId(1L);
        p.setPaymentAmount(100);

        service.createPayment(p);

        p.setPaymentAmount(200);
        service.updatePayment(p);

        Assert.assertEquals(service.getPaymentById(1L).getPaymentAmount(), 200);
    }

    @Test
    public void shouldDeletePayment() {
        CardPayment p = new CardPayment();
        p.setId(1L);

        service.createPayment(p);
        service.deletePayment(1L);

        Assert.assertNull(service.getPaymentById(1L));
    }

    @Test
    public void shouldReturnAllPayments() {
        CardPayment p1 = new CardPayment();
        p1.setId(1L);

        CardPayment p2 = new CardPayment();
        p2.setId(2L);

        service.createPayment(p1);
        service.createPayment(p2);

        Assert.assertEquals(service.getAllPayments().size(), 2);
    }

    @Test
    public void shouldFindPaymentById() {
        CardPayment p = new CardPayment();
        p.setId(1L);

        service.createPayment(p);

        Assert.assertEquals(service.getPaymentById(1L).getId(), Long.valueOf(1));
    }
}