package com.ppds07.EMS.controller;

import com.ppds07.EMS.model.Employee;
import com.ppds07.EMS.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class EmployeeWebController {

    // Constructor Service injection instead of @Autowired
    private final EmployeeService employeeService;

    public EmployeeWebController(EmployeeService employeeService)
    {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public String showEmployeePage(Model model)
    {
        model.addAttribute("employees", employeeService.getAllEmployee());
        return "index";
    }

    @PostMapping("/employees/add")
    public String addEmployee(@RequestParam String name, @RequestParam String email, @RequestParam String department)
    {
        Employee employee = new Employee();
        employee.setName(name);
        employee.setEmail(email);
        employee.setDepartment(department);
        employeeService.addEmployee(employee);
        return "redirect:/employees";
    }

    @GetMapping("/employees/edit/{id}")
    public String editEmployee(@PathVariable Long id, Model model)
    {
        Employee employee = employeeService.getEmployeeById(id);
        model.addAttribute("employee", employee);
        return "edit";
    }

    @PostMapping("/employees/update/{id}")
    public String updateEmployee(@PathVariable Long id,@RequestParam String name, @RequestParam String email, @RequestParam String department)
    {
        Employee employee = new Employee();
        employee.setId(id);
        employee.setName(name);
        employee.setEmail(email);
        employee.setDepartment(department);
        employeeService.updateEmployee(id, employee);
        return "redirect:/employees";
    }

    @GetMapping("/employees/delete/{id}")
    public String deleteEmployee(@PathVariable Long id)
    {
        employeeService.deleteEmployee(id);
        return "redirect:/employees";
    }

    @GetMapping("/dashboard")
    public String showDashboard(Model model)
    {
        List<Employee> employees = employeeService.getAllEmployee();

        int totalEmployees = employees.size();
        int totalDepartments = (int) employees.stream().map(Employee::getDepartment).distinct().count();

        model.addAttribute("totalEmployees", totalEmployees);
        model.addAttribute("totalDepartments", totalDepartments);
        return "dashboard";
    }


}
