package com.app.app.period.domain.repository;

import com.app.app.categoria.persistence.Category;
import com.app.app.period.persistence.Period;
import org.springframework.data.jpa.repository.JpaRepository;
public interface PeriodRepository extends JpaRepository<Period, Long> {
}
