package com.app.app.conservationStatus.domain.repository;

import com.app.app.conservationStatus.persistence.ConservationStatus;
import org.springframework.data.jpa.repository.JpaRepository;
public interface ConservationStatusRepository extends JpaRepository<ConservationStatus, Long> {
}
