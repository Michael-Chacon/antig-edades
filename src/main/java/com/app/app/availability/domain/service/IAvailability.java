package com.app.app.availability.domain.service;

import com.app.app.availability.persistence.Availability;

import java.util.List;

public interface IAvailability {
    List<Availability> findAll();
    Availability findById(Long id);
    Availability save(Availability availability);
    Availability update(Long id, Availability availability);
    void delete(Long id);
}
