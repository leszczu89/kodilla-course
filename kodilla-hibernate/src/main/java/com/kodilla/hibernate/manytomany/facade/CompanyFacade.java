package com.kodilla.hibernate.manytomany.facade;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import com.kodilla.hibernate.manytomany.dao.CompanyDao;
import com.kodilla.hibernate.manytomany.dao.EmployeeDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyFacade {
    private static final Logger LOGGER = LoggerFactory.getLogger(CompanyFacade.class);
    private final CompanyDao companyDao;
    private final EmployeeDao employeeDao;

    @Autowired
    public CompanyFacade(CompanyDao companyDao, EmployeeDao employeeDao) {
        this.companyDao = companyDao;
        this.employeeDao = employeeDao;
    }

    public List<Company> searchCompanyWithGivenStr(String string) throws SearchingException{
        LOGGER.info("Searching for Company with: "+ string + " in name");

        List<Company> retrievedList = companyDao.retrieveCompanyWithNameIncluding(string);
        if(!retrievedList.isEmpty()){
            LOGGER.info("Found Company/ies:");
            retrievedList.stream().map(Company::getName).forEach(System.out::println);
        } else {
            throw new SearchingException(SearchingException.ERR_COMPANY_NOT_FOUND);
        }
        return retrievedList;
    }

    public List<Employee> searchEmployeeWithGivenStr(String string) throws SearchingException{
        LOGGER.info("Searching for Employee with: "+ string + " in name");

        List<Employee> retrievedList = employeeDao.retrieveEmployeeWithNameLike(string);
        if(!retrievedList.isEmpty()){
            LOGGER.info("Found Employee/s:");
            retrievedList.stream().map(Employee::getLastname).forEach(System.out::println);
        } else {
            throw new SearchingException(SearchingException.ERR_EMPLOYEE_NOT_FOUND);
        }
        return retrievedList;
    }
}
