package com.db.javaschool.springdata.jdbc.dao;


import com.db.javaschool.springdata.jdbc.domain.EmployeeJdbc;
import com.db.javaschool.springdata.domain.Employee;

public interface EmployeeDAO {

    void insert(EmployeeJdbc employee);
    EmployeeJdbc findByFirstName(String firstName);

}
