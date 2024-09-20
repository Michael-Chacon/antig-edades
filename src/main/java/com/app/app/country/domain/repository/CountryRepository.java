package com.app.app.country.domain.repository;

import com.app.app.country.persistence.Country;
import org.springframework.data.jpa.repository.JpaRepository;
public interface CountryRepository extends JpaRepository<Country, Long> {
}
