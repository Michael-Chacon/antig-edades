package com.app.app.availability.domain.service;

import com.app.app.availability.domain.repository.AvailabilityRepository;
import com.app.app.availability.persistence.Availability;
import com.app.app.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AvailabilityImpl implements IAvailability {
     @Autowired
    private AvailabilityRepository repository;

    @Override
    public List<Availability> findAll() {
        return repository.findAll();
    }

    @Override
    public Availability findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(Availability.class.getName(), id));
    }

    @Override
    public Availability save(Availability availability) {
        return repository.save(availability);
    }

    @Override
    public Availability update(Long id, Availability availability) {
        return repository.findById(id).map(existElemetn -> {
            existElemetn.setName(availability.getName());
            return repository.save(existElemetn);
        }).orElseThrow(() -> new ResourceNotFoundException(Availability.class.getName(), id));
    }

    @Override
    public void delete(Long id) {
        repository.delete(findById(id));
    }
}
