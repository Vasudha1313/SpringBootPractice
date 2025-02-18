package com.practice.employee.controller;

import com.practice.employee.dto.EmployeeRequestDto;
import com.practice.employee.dto.EmployeeResponseDto;
import com.practice.employee.entity.Employee;
import com.practice.employee.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @GetMapping("/test")
    public void test(){
        System.out.println("This service is working fine");

    }
    @GetMapping("/getAllEmployees")
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @PostMapping("/setAllEmployees")
    public List<EmployeeResponseDto> setAllEmployees(@RequestBody List<EmployeeRequestDto> employees) {
        return employeeService.setAllEmployees(employees);
    }

    @GetMapping("/findByDepartment")
        public List<Employee> findByDepartment(@RequestParam String department) {
            return employeeService.findByDepartment(department);
        }
    @DeleteMapping("deleteEmployeeById/{id}")
    public ResponseEntity<String> deleteEmployeeById(@PathVariable Long id) {
        try {
            employeeService.deleteEmployeeById(id);
            return ResponseEntity.ok("Employee with ID " + id + " deleted successfully.");
        } catch (RuntimeException e) {
            return ResponseEntity.status(404).body(e.getMessage());
        }
    }


    }
