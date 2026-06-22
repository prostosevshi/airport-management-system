package com.solvd.airportmanagement.service;

import com.solvd.airportmanagement.entity.Employee;
import com.solvd.airportmanagement.repository.FakeEmployeeRepository;
import com.solvd.airportmanagement.service.impl.EmployeeServiceImpl;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

public class EmployeeServiceTest {

    private EmployeeServiceImpl service;

    @BeforeSuite
    public void beforeSuite() {
        System.out.println("Before Suite");
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("After Suite");
    }

    @BeforeTest
    public void beforeTest() {
        System.out.println("Before Test");
    }

    @AfterTest
    public void afterTest() {
        System.out.println("After Test");
    }

    @BeforeClass
    public void beforeClass() {
        System.out.println("Before Class");
    }

    @AfterClass
    public void afterClass() {
        System.out.println("After Class");
    }

    @BeforeMethod
    public void beforeMethod() {
        service = new EmployeeServiceImpl(
                new FakeEmployeeRepository());
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("After Method");
    }

    @Test
    public void shouldCreateEmployee() {

        Employee employee = new Employee();

        employee.setId(1L);
        employee.setName("John");
        employee.setAge(30);
        employee.setSalary(1000);

        service.createEmployee(employee);

        Employee result =
                service.getEmployeeById(1L);

        org.testng.Assert.assertNotNull(result);
    }

    @Test
    public void shouldFindEmployeeById() {

        Employee employee = new Employee();

        employee.setId(2L);
        employee.setName("Mike");
        employee.setAge(40);
        employee.setSalary(1500);

        service.createEmployee(employee);

        Employee result =
                service.getEmployeeById(2L);

        org.testng.Assert.assertEquals(
                result.getName(),
                "Mike");
    }

    @Test
    public void shouldReturnAllEmployees() {

        Employee employee1 = new Employee();
        employee1.setId(1L);

        Employee employee2 = new Employee();
        employee2.setId(2L);

        service.createEmployee(employee1);
        service.createEmployee(employee2);

        org.testng.Assert.assertEquals(
                service.getAllEmployees().size(),
                2);
    }

    @Test
    public void shouldDeleteEmployee() {

        Employee employee = new Employee();

        employee.setId(1L);

        service.createEmployee(employee);

        service.deleteEmployee(1L);

        org.testng.Assert.assertNull(
                service.getEmployeeById(1L));
    }

    @Test
    public void shouldValidateEmployeeFields() {

        Employee employee = new Employee();

        employee.setId(1L);
        employee.setName("John");
        employee.setAge(30);
        employee.setSalary(1000);

        service.createEmployee(employee);

        Employee result =
                service.getEmployeeById(1L);

        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(
                result.getName(),
                "John");

        softAssert.assertEquals(
                result.getAge(),
                30);

        softAssert.assertEquals(
                result.getSalary(),
                1000);

        softAssert.assertNotNull(result);

        softAssert.assertAll();
    }
}