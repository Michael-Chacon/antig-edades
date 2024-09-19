package com.app.app.categoria.domain.repository;

import com.app.app.categoria.persistence.Category;
import org.springframework.data.jpa.repository.JpaRepository;
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
