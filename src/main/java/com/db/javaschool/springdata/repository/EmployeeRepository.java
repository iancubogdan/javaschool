package com.db.javaschool.springdata.repository;

import com.db.javaschool.springdata.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
