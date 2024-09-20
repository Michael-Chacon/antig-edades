package com.app.app.city.domain.repository;

import com.app.app.city.persistence.City;
import org.springframework.data.jpa.repository.JpaRepository;
public interface CityRepository extends JpaRepository<City, Long> {
}
