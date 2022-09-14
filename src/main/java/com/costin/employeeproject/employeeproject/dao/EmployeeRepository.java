package com.costin.employeeproject.employeeproject.dao;

import com.costin.employeeproject.employeeproject.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
