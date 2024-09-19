package com.app.app.availability.domain.repository;

import com.app.app.availability.persistence.Availability;
import org.springframework.data.jpa.repository.JpaRepository;
public interface AvailabilityRepository extends JpaRepository<Availability, Long> {
}
