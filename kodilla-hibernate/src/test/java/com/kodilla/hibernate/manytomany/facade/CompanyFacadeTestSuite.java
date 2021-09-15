package com.kodilla.hibernate.manytomany.facade;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import com.kodilla.hibernate.manytomany.dao.CompanyDao;
import com.kodilla.hibernate.manytomany.dao.EmployeeDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CompanyFacadeTestSuite {

    @Autowired
    private CompanyFacade companyFacade;
    @Autowired
    private CompanyDao companyDao;
    @Autowired
    private EmployeeDao employeeDao;


    @Test
    void searchCompanyWithGivenStrTest() {
        //Given
        Company company = new Company("Super Company");
        Company company1 = new Company("Super Fantastic Company");
        Company company2 = new Company("Bad Company");
        //When
        companyDao.save(company);
        companyDao.save(company1);
        companyDao.save(company2);

        //Then
        List<Company> companies = new ArrayList<>();
        try {
            companies = companyFacade.searchCompanyWithGivenStr("ant");
        } catch (SearchingException e) {

        }
        assertEquals(1, companies.size());
        //Clean Up
        try {
            companyDao.deleteAll();
        } catch (Exception e){

        }
    }
    @Test
    void searchEmployeeWithLastnameLike() {
        //Given, When
        employeeDao.save(new Employee("Jan", "Kowalski"));
        employeeDao.save(new Employee("Marek", "Niekowalski"));
        employeeDao.save(new Employee("Joanna", "Nowak"));
        //Then
        List<Employee> employees = new ArrayList<>();
        try {
            employees = companyFacade.searchEmployeeWithGivenStr("Kow");
        } catch (SearchingException e){

        }
        assertEquals(2, employees.size());
        //Clean Up
        try {
            employeeDao.deleteAll();
        }catch (Exception e){

        }
    }
}