package com.practice.employee.converter;

import com.practice.employee.dto.AddressResponseDto;
import com.practice.employee.dto.EmployeeResponseDto;
import org.springframework.core.convert.converter.Converter;
import com.practice.employee.entity.Employee;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EmployeeResponseConverter implements Converter<Employee,EmployeeResponseDto> {


    @Override
    public EmployeeResponseDto convert(Employee emp) {
        EmployeeResponseDto empResponse = EmployeeResponseDto.builder().empId(emp.getEmployeeId())
                .name(emp.getName()).department(emp.getDepartment()).salary(emp.getSalary()).build();

        List<AddressResponseDto> addresses = emp.getAddress().stream().map(address -> {
            AddressResponseDto add = AddressResponseDto.builder()
                    .addressId(address.getAddressId()).street(address.getStreet())
                    .city(address.getCity()).state(address.getState()).zipcode(address.getZipcode()).build();
            add.setEmpId(empResponse.getEmpId());
            return add;
        }).toList();
        empResponse.setAddress(addresses);
        return empResponse;
    }

    public List<EmployeeResponseDto> convertList(List<Employee> employees) {
        return employees.stream().map(this::convert).toList();
    }
}