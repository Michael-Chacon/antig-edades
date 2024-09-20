package com.app.app.antiquity.domain.repository;

import com.app.app.antiquity.persistence.Antiquity;
import org.springframework.data.jpa.repository.JpaRepository;
public interface AntiquityRepository extends JpaRepository<Antiquity, Long> {
}
