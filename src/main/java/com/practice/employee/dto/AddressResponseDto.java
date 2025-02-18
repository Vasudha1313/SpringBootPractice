package com.practice.employee.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Component
public class AddressResponseDto {

    private Long addressId;

    private String street;

    private String city;

    private String state;

    private String zipcode;

    private long empId;
}
