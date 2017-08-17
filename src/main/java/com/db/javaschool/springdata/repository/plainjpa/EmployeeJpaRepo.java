package com.db.javaschool.springdata.repository.plainjpa;

import com.db.javaschool.springdata.domain.Employee;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class EmployeeJpaRepo {

    @PersistenceContext
    private EntityManager entityManager;

    private static final String QUERY = "from Employee e where e.lastName =:parameter";

    @Transactional
    public Employee getEmployeeByLastName(String lastName) {
        Query query = entityManager.createQuery(QUERY);
        query.setParameter("parameter", lastName);
        List<Employee> response = query.getResultList();
        if (response == null || response.isEmpty()) {
            return null;
        }
        return response.get(0);
    }
}
