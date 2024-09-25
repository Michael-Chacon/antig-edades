package com.app.app.antiquityValuation.domain.repository;

import com.app.app.antiquityValuation.DTO.AntiquityMoreViewDTO;
import com.app.app.antiquityValuation.persistence.Valuation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ValuationRepository extends JpaRepository<Valuation, Long> {
     @Query("SELECT new com.app.app.antiquityValuation.DTO.AntiquityMoreViewDTO(a.name, COUNT(v) AS views) FROM Valuation v " +
             "INNER JOIN v.antiquity a " +
             "GROUP BY a.codeAntiquity " +
             "ORDER BY views DESC")
    List<AntiquityMoreViewDTO>  moreVisitors();
}
