package com.app.app.region.domain.repository;

import com.app.app.region.persistence.Region;
import org.springframework.data.jpa.repository.JpaRepository;
public interface RegionRepository extends JpaRepository<Region, Long> {
}
