package com.practice.employee.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Employee {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name = "employee_id")
    private Long employeeId;

    private String name;

    private String department;

    private Double salary;

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Address> address;

}
