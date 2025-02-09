package com.practice.employee.converter;

import com.practice.employee.dto.EmployeeRequestDto;
import com.practice.employee.entity.Address;
import com.practice.employee.entity.Employee;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EmployeeConverter implements Converter<EmployeeRequestDto, Employee> {

    @Override
    public Employee convert(EmployeeRequestDto employeeDto) {

        Employee employee = Employee.builder()
                .name(employeeDto.getName())
                .department(employeeDto.getDepartment())
                .salary(employeeDto.getSalary())
                .build();
        List<Address> addresses = employeeDto.getAddress().stream()
                .map(addressDto -> {
                    Address address = Address.builder()
                            .street(addressDto.getStreet())
                            .city(addressDto.getCity())
                            .state(addressDto.getState())
                            .zipcode(addressDto.getZipcode())
                            .build();
                    address.setEmployee(employee); // ✅ Set Employee reference
                    return address;
                })
                .toList();

        employee.setAddress(addresses); // ✅ Set Address list in Employee
        return employee;
    }

    public List<Employee> convertList(List<EmployeeRequestDto> employees) {
        return employees.stream().map(this::convert).toList();
    }
}
