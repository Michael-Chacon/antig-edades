package com.app.app.company.domain.repository;

import com.app.app.company.persistence.Company;
import org.springframework.data.jpa.repository.JpaRepository;
public interface CompanyRepository extends JpaRepository<Company, Long> {
}
