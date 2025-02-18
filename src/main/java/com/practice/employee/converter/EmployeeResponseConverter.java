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

        List<AddressResponseDto> addressResponseDtoList = emp.getAddress().stream().map(address ->
                AddressResponseDto.builder().addressId(address.getAddressId()).street(address.getStreet())
                        .state(address.getState()).city(address.getCity()).zipcode(address.getZipcode())
                        .build()).toList();
        return EmployeeResponseDto.builder().empId(emp.getEmployeeId())
                .name(emp.getName()).department(emp.getDepartment()).salary(emp.getSalary())
                .address(addressResponseDtoList).build();
    }

        public List<EmployeeResponseDto> convertList(List<Employee> employees) {
            return employees.stream().map(this::convert).toList();
        }
    }