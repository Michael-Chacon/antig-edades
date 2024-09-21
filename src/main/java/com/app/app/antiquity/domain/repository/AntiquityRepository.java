package com.app.app.antiquity.domain.repository;

import com.app.app.antiquity.DTO.AvailableDTO;
import com.app.app.antiquity.persistence.Antiquity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

public interface AntiquityRepository extends JpaRepository<Antiquity, Long> {
    @Query("SELECT new com.app.app.antiquity.DTO.AvailableDTO(a.codeAntiquity, a.name, a.price, c.name, cs.name) FROM Antiquity a " +
            "JOIN a.category c " +
            "JOIN a.conservationStatus cs " +
            "JOIN a.availability av " +
            "WHERE av.codeAvailability = 1")
    List<AvailableDTO> findAntiquityByAvailableStatus();

    @Query("SELECT new com.app.app.antiquity.DTO.AvailableDTO(a.codeAntiquity, a.name, a.price, c.name, cs.name) FROM Antiquity a " +
            "INNER JOIN a.category c " +
            "INNER JOIN a.conservationStatus cs " +
            "WHERE a.price between :minPrice and :maxPrice and c.codeCategory = 1")
    Set<AvailableDTO> findAntiquitiesForRangePrice(@Param("minPrice") BigDecimal min, @Param("maxPrice") BigDecimal max);
}
