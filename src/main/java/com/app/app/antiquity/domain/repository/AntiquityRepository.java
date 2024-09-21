package com.app.app.antiquity.domain.repository;

import com.app.app.antiquity.DTO.AvailableDTO;
import com.app.app.antiquity.persistence.Antiquity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface AntiquityRepository extends JpaRepository<Antiquity, Long> {
    @Query("SELECT new com.app.app.antiquity.DTO.AvailableDTO(a.name, a.price, c.name, cs.name) FROM Antiquity a " +
            "JOIN a.category c " +
            "JOIN a.conservationStatus cs " +
            "JOIN a.availability av " +
            "WHERE av.codeAvailability = 1")
    List<AvailableDTO> findAntiquityByAvailableStatus();
}
