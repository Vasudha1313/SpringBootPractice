package com.practice.employee.service;

import com.practice.employee.converter.EmployeeConverter;
import com.practice.employee.dto.EmployeeRequestDto;
import com.practice.employee.entity.Employee;
import com.practice.employee.repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final EmployeeConverter employeeConverter;

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public void setAllEmployees(List<EmployeeRequestDto> employees){
        List<Employee> employeeList = employeeConverter.convertList(employees);
        employeeRepository.saveAll(employeeList);
    }

    public List<Employee> findByDepartment(String department) {
        // return employeeRepository.findByDepartment(department);
        return employeeRepository.findAll().stream().
                filter(employee->department.equalsIgnoreCase(employee.getDepartment())).toList();
    }

    public void deleteEmployeeById(Long id) {
        if (employeeRepository.existsById(id)) {
            employeeRepository.deleteById(id);
        } else {
            throw new RuntimeException("Employee not found with ID: " + id);
        }
    }

}
