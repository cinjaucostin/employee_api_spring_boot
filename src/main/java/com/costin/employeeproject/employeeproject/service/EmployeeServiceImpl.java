package com.costin.employeeproject.employeeproject.service;

import com.costin.employeeproject.employeeproject.dao.EmployeeDAO;
import com.costin.employeeproject.employeeproject.dao.EmployeeRepository;
import com.costin.employeeproject.employeeproject.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

//    @Autowired
//    @Qualifier(value = "employeeDAOJpaImpl")
//    private EmployeeDAO employeeDAO;


    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(int theId) {
        Optional<Employee> optionalEmployee = employeeRepository.findById(theId);

        if(optionalEmployee.isPresent()) {
            return optionalEmployee.get();
        } else {
            throw new RuntimeException("Employee with id - " + theId + " not found.");
        }
    }

    @Override
    public void save(Employee theEmployee) {
        employeeRepository.save(theEmployee);
    }

    @Override
    public void deleteById(int theId) {
        employeeRepository.deleteById(theId);
    }
}
