package com.practice.employee.repository;

import com.practice.employee.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    //List<Employee> findByDepartment(String department);
}
