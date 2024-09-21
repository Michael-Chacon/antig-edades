package com.app.app.country.domain.service;

import com.app.app.country.domain.repository.CountryRepository;
import com.app.app.country.persistence.Country;
import com.app.app.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CountryImpl implements ICountry {
     @Autowired
    private CountryRepository repository;

    @Transactional(readOnly = true)
     @Override
    public List<Country> findAll() {
        return repository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Country findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(Country.class.getName(), id));
    }

    @Transactional
    @Override
    public Country save(Country country) {
        return repository.save(country);
    }

    @Transactional
    @Override
    public Country update(Long id, Country country) {
        return repository.findById(id).map(existElement -> {
            existElement.setName(country.getName());
            return repository.save(existElement);
        }).orElseThrow(() -> new ResourceNotFoundException(Country.class.getName(), id));
    }

    @Transactional(readOnly = true)
    @Override
    public void delete(Long id) {
        repository.delete(findById(id));
    }
}
