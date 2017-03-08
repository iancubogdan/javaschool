package com.db.javaschool.springdata.repository;

import com.db.javaschool.springdata.config.AppConfig;
import com.db.javaschool.springdata.domain.Company;
import com.db.javaschool.springdata.domain.Employee;
import com.db.javaschool.springdata.jdbc.dao.JdbcEmployeeDao;
import com.db.javaschool.springdata.jdbc.domain.EmployeeJdbc;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
public class EmployeeRepositoryTest {

    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private JdbcEmployeeDao jdbcEmployeeDao;
    @Autowired
    private CompanyRepository companyRepository;

    @Test
    public void test() {
        List<Employee> employees = employeeRepository.findAll();
        System.out.println(employees);
    }


    @Test
    public void test2() {
        EmployeeJdbc employeeJdbc = jdbcEmployeeDao.findByFirstName("Gigel");
        System.out.println(employeeJdbc);

        EmployeeJdbc newEmployee = new EmployeeJdbc();

        employeeJdbc.setFirstName("Alin");
        employeeJdbc.setLastName("Costache");

        jdbcEmployeeDao.insert(employeeJdbc);

        EmployeeJdbc employeeJdbc2 = jdbcEmployeeDao.findByFirstName("Alin");
        System.out.println(employeeJdbc2);

    }

    @Test
    public void test3() {
        List<Company> companies = companyRepository.findAll();
        System.out.println(companies);
    }

}