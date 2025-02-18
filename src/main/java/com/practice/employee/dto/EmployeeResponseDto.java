package com.practice.employee.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
@Builder
@Data
@NoArgsConstructor
public class EmployeeResponseDto {

    private long empId;

    private String name;

    private String department;

    private Double salary;

    private List<AddressResponseDto> address;
}
