package com.costin.employeeproject.employeeproject.dao;

import com.costin.employeeproject.employeeproject.entity.Employee;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class EmployeeDAOHibernateImpl implements  EmployeeDAO{

    @Autowired
    private EntityManager entityManager;

    @Override
    @Transactional
    public List<Employee> findAll() {
        Session session = entityManager.unwrap(Session.class);

        Query<Employee> query = session
                .createQuery(
                        "from Employee",
                        Employee.class
                );

        List<Employee> employees = query
                .getResultList();

        return employees;
    }

    @Override
    public Employee findById(int theId) {
        Session session = entityManager.unwrap(Session.class);

        Employee employee =
                session.get(Employee.class, theId);

        return employee;
    }

    @Override
    public void save(Employee theEmployee) {
        Session session = entityManager.unwrap(Session.class);

        session.saveOrUpdate(theEmployee);
    }

    @Override
    public void deleteById(int theId) {
        Session session = entityManager.unwrap(Session.class);

        Query query = session
                .createQuery("delete from Employee"
                + " where id=:theId");
        query.setParameter("theId", theId);
        query.executeUpdate();
    }
}
