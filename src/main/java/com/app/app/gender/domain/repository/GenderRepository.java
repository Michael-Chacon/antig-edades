package com.app.app.gender.domain.repository;

import com.app.app.gender.persistence.Gender;
import org.springframework.data.jpa.repository.JpaRepository;
public interface GenderRepository extends JpaRepository<Gender, Long> {
}
