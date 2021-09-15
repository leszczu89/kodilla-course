package com.kodilla.hibernate.manytomany.facade;

public class SearchingException extends Exception{
    public static String ERR_COMPANY_NOT_FOUND = "The Company, with given string in name, wasn't found";
    public static String ERR_EMPLOYEE_NOT_FOUND = "The Employee, with given string in last name, wasn't found";

    public SearchingException(String message) {
        super(message);
    }
}
