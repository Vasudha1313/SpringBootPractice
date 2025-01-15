package com.first.firstMicroserviceproject.controller;

import com.first.firstMicroserviceproject.entity.Employee;
import com.first.firstMicroserviceproject.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/test")
    public void test(){
        System.out.println("This service is working fine");

    }
    @GetMapping("/getAllEmployees")
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @PostMapping("/setAllEmployees")
    public void setAllEmployees(@RequestBody List<Employee> employees) {
        employeeService.setAllEmployees(employees);
    }

    @GetMapping("/findByDepartment")
        public List<Employee> findByDepartment(@RequestParam String department) {
            return employeeService.findByDepartment(department);
        }
    }
