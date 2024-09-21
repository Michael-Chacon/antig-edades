package com.app.app.collectionist.domain.repository;

import com.app.app.collectionist.persistence.entity.Collectionist;
import org.springframework.data.jpa.repository.JpaRepository;
public interface CollectionistRepository extends JpaRepository<Collectionist, Long> {
}
