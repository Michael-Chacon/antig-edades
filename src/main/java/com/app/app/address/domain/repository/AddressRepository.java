package com.app.app.address.domain.repository;

import com.app.app.address.persistence.Address;
import org.springframework.data.jpa.repository.JpaRepository;
public interface AddressRepository extends JpaRepository<Address, Long> {
}
