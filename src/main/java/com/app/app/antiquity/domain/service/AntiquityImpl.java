package com.app.app.antiquity.domain.service;

import com.app.app.antiquity.DTO.AvailableDTO;
import com.app.app.antiquity.domain.repository.AntiquityRepository;
import com.app.app.antiquity.persistence.Antiquity;
import com.app.app.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Service
public class AntiquityImpl implements IAntiquity {
     @Autowired
    private AntiquityRepository repository;

    @Transactional(readOnly = true)
     @Override
    public List<Antiquity> findAll() {
        return repository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Antiquity findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(Antiquity.class.getName(), id));
    }

    @Transactional
    @Override
    public Antiquity save(Antiquity antiquity) {
        return repository.save(antiquity);
    }

    @Transactional
    @Override
    public Antiquity update(Long id, Antiquity antiquity) {
        return repository.findById(id).map(existElement -> {
            existElement.setName(antiquity.getName());
            existElement.setCategory(antiquity.getCategory());
            existElement.setPeriod(antiquity.getPeriod());
            existElement.setConservationStatus(antiquity.getConservationStatus());
            existElement.setAvailability(antiquity.getAvailability());
            existElement.setBranch(antiquity.getBranch());
            existElement.setOwner(antiquity.getOwner());
            return repository.save(existElement);
        }).orElseThrow(() -> new ResourceNotFoundException(Antiquity.class.getName(), id));
    }

    @Transactional
    @Override
    public void delete(Long id) {
        repository.delete(findById(id));
    }

    @Transactional(readOnly = true)
    @Override
    public List<AvailableDTO> availableForSold() {
        return repository.findAntiquityByAvailableStatus();
    }

    @Override
    public Set<AvailableDTO> antiquityByRangeOfPrice() {
        return repository.findAntiquitiesForRangePrice(new BigDecimal("1000"), new BigDecimal("3000"));
    }
}
