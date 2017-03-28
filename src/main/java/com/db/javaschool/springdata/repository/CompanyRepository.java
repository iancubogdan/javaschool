package com.db.javaschool.springdata.repository;


import com.db.javaschool.springdata.domain.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, Long> {

}
