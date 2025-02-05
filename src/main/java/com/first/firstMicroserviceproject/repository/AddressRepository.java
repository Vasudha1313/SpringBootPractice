
package com.first.firstMicroserviceproject.repository;

import com.first.firstMicroserviceproject.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address,Long> {
}
