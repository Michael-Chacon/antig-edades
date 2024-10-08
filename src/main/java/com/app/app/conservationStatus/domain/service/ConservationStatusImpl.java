package com.app.app.conservationStatus.domain.service;

import com.app.app.conservationStatus.domain.repository.ConservationStatusRepository;
import com.app.app.conservationStatus.persistence.ConservationStatus;
import com.app.app.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ConservationStatusImpl implements IConservationStatus {
     @Autowired
    private ConservationStatusRepository repository;

    @Transactional(readOnly = true)
     @Override
    public List<ConservationStatus> findAll() {
        return repository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public ConservationStatus findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(ConservationStatus.class.getName(), id));
    }

    @Transactional
    @Override
    public ConservationStatus save(ConservationStatus conservationStatus) {
        return repository.save(conservationStatus);
    }

    @Transactional
    @Override
    public ConservationStatus update(Long id, ConservationStatus conservationStatus) {
        return repository.findById(id).map(existElement -> {
            existElement.setName(conservationStatus.getName());
            return repository.save(existElement);
        }).orElseThrow(() -> new ResourceNotFoundException(ConservationStatus.class.getName(), id));
    }

    @Transactional
    @Override
    public void delete(Long id) {
        repository.delete(findById(id));
    }
}
