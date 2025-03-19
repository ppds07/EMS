package com.ppds07.EMS.service;

import com.ppds07.EMS.model.Employee;
import com.ppds07.EMS.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    //  Get all the Employee Details
    public List<Employee> getAllEmployees()
    {
        return employeeRepository.findAll();
    }

    // Add an Employee
    public Employee addEmployee(Employee employee)
    {
        return employeeRepository.save(employee);
    }

    // To update an existing employee
    public Employee updateEmployee(Long id, Employee employee)
    {
        Employee existingEmployee = employeeRepository.findById(id).orElseThrow(()-> new RuntimeException("Employee not found!"));

        existingEmployee.setName(employee.getName());
        existingEmployee.setEmail(employee.getEmail());
        existingEmployee.setDepartment(employee.getDepartment());

        return employeeRepository.save(existingEmployee);

    }


    //To fetch employee by ID
    public Employee getEmployeeById(Long id)
    {
        return employeeRepository.findById(id).orElseThrow(()-> new RuntimeException("Employee not found!!"));
    }

    // To delete an employee
    public void deleteEmployee(Long id)
    {
        employeeRepository.deleteById(id);
    }

    // Save employee to the database
    public void saveEmployee(Employee employee) {
        employeeRepository.save(employee);
    }
}
