package com.app.app.conservationStatus.domain.service;

import com.app.app.conservationStatus.persistence.ConservationStatus;

import java.util.List;

public interface IConservationStatus {
    List<ConservationStatus> findAll();
    ConservationStatus findById(Long id);
    ConservationStatus save(ConservationStatus conservationStatus);
    ConservationStatus update(Long id, ConservationStatus conservationStatus);
    void delete(Long id);
}
