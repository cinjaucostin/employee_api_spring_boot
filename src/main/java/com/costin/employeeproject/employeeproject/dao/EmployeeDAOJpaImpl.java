package com.costin.employeeproject.employeeproject.dao;

import com.costin.employeeproject.employeeproject.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO {

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Employee> findAll() {
        TypedQuery<Employee> query = entityManager.createQuery(
                "from Employee",
                Employee.class
        );

        List<Employee> employees = query.getResultList();

        return employees;
    }

    @Override
    public Employee findById(int theId) {
        Employee employee = entityManager.find(Employee.class, theId);

        return employee;
    }

    @Override
    public void save(Employee theEmployee) {
        Employee employee = entityManager.merge(theEmployee);

        theEmployee.setId(employee.getId());
    }

    @Override
    public void deleteById(int theId) {

        Query query = entityManager.createQuery(
                "delete from Employee where id=:theId"
        );
        query.setParameter("theId", theId);
        query.executeUpdate();
    }

}
