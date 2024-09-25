package com.app.app.antiquityValuation.domain.service;

import com.app.app.antiquityValuation.DTO.SaveValuationDTO;
import com.app.app.antiquityValuation.DTO.AntiquityMoreViewDTO;
import com.app.app.antiquityValuation.persistence.Valuation;

import java.util.List;

public interface IValuation {
    List<Valuation> findAll();
    Valuation findById(Long id);
    Valuation save(SaveValuationDTO valuation);
    Valuation update(Long id, SaveValuationDTO valuation);
    void delete(Long id);

    List<AntiquityMoreViewDTO> moreViews();
}
