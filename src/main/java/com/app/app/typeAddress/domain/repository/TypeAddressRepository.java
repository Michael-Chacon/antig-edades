package com.app.app.typeAddress.domain.repository;

import com.app.app.typeAddress.persistence.TypeAddress;
import org.springframework.data.jpa.repository.JpaRepository;
public interface TypeAddressRepository extends JpaRepository<TypeAddress, Long> {
}
