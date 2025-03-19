package com.ppds07.EMS.controller;

import com.ppds07.EMS.model.Employee;
import com.ppds07.EMS.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    // Constructor Service Injection instead of @Autowired
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService)
    {
        this.employeeService = employeeService;
    }

    // To display all the employees
    @GetMapping
    public List<Employee> getAllEmployees()
    {
        return employeeService.getAllEmployees();
    }

    // To add an employee
    @PostMapping
    public Employee createEmployee(@RequestBody Employee employee)
    {
        return employeeService.addEmployee(employee);

    }

    // To update an employee
    @PutMapping("/{id}")
    public Employee updateEmployee(@PathVariable Long id, @RequestBody Employee employee)
    {
        return employeeService.updateEmployee(id, employee);
    }

    // To delete an employee
    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable Long id)
    {
        employeeService.deleteEmployee(id);
    }

    @GetMapping("/list")
    public String getAllEmployees(Model model) {
        List<Employee> employees = employeeService.getAllEmployees();
        model.addAttribute("employees", employees);
        return "employee-list"; // Ensure this matches the Thymeleaf template name
    }

    @PostMapping("/add")
    public String addEmployee(@ModelAttribute Employee employee) {
        employeeService.saveEmployee(employee);
        return "redirect:/employees/list";
    }
}
