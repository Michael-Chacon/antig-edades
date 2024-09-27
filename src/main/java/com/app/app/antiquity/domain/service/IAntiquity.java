package com.app.app.antiquity.domain.service;

import com.app.app.antiquity.DTO.AntiquityDTO;
import com.app.app.antiquity.DTO.AvailableDTO;
import com.app.app.antiquity.persistence.Antiquity;

import java.util.List;
import java.util.Objects;
import java.util.Set;

public interface IAntiquity {
    List<Antiquity> findAll();
    Antiquity findById(Long id);
    Antiquity saveOrUpdate(Long id, AntiquityDTO antiquity);
    void delete(Long id);
    List<AvailableDTO> availableForSold();
    Set<AvailableDTO> antiquityByRangeOfPrice();
}
