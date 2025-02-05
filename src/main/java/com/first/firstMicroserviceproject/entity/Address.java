
package com.first.firstMicroserviceproject.entity;

import jakarta.persistence.*;
import lombok.Data;
@Entity
@Data
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String street;

    private String city;

    private String state;

    private String zipcode;

    @ManyToOne
    private Employee employee;

    public Address(String street, String city, String state, String zipcode) {
        this.street = street;
        this.city = city;
        this.state = state;
        this.zipcode = zipcode;

    }

    public Address() {
    }
}
