package com.costin.employeeproject.employeeproject.dao;

import com.costin.employeeproject.employeeproject.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    List<Employee> findAll();

    Employee findById(int theId);

    void save(Employee theEmployee);

    void deleteById(int theId);

}
