package com.ppds07.EMS.repository;


import com.ppds07.EMS.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    //CRUD operations
}
