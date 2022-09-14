package com.costin.employeeproject.employeeproject.rest;

import com.costin.employeeproject.employeeproject.dao.EmployeeDAO;
import com.costin.employeeproject.employeeproject.entity.Employee;
import com.costin.employeeproject.employeeproject.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees")
    public List<Employee> listEmployees() {
        return employeeService.findAll();
    }

    @GetMapping("/employees/{theId}")
    public Employee findById(@PathVariable int theId) {
        Employee employee = employeeService.findById(theId);
        return employee;
    }

    @PostMapping("/employees")
    public Employee saveEmployee(@RequestBody Employee theEmployee) {
        theEmployee.setId(0);

        employeeService.save(theEmployee);

        return theEmployee;
    }

    @DeleteMapping("/employees/{theId}")
    public void deleteEmployeeById(@PathVariable int theId) {
        employeeService.deleteById(theId);
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee theEmployee) {
        employeeService.save(theEmployee);

        return theEmployee;
    }

}
