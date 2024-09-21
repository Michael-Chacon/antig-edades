package com.app.app.period.domain.service;

import com.app.app.period.persistence.Period;
import com.app.app.exceptions.ResourceNotFoundException;
import com.app.app.period.domain.repository.PeriodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PeriodImpl implements IPeriod {
     @Autowired
    private PeriodRepository repository;

    @Transactional(readOnly = true)
     @Override
    public List<Period> findAll() {
        return repository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Period findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(Period.class.getName(), id));
    }

    @Transactional
    @Override
    public Period save(Period period) {
        return repository.save(period);
    }

    @Transactional
    @Override
    public Period update(Long id, Period period) {
        return repository.findById(id).map(existElement -> {
            existElement.setName(period.getName());
            return repository.save(existElement);
        }).orElseThrow(() -> new ResourceNotFoundException(Period.class.getName(), id));
    }

    @Transactional(readOnly = true)
    @Override
    public void delete(Long id) {
        repository.delete(findById(id));
    }
}
