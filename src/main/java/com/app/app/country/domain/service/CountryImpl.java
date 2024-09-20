package com.app.app.country.domain.service;

import com.app.app.country.domain.repository.CountryRepository;
import com.app.app.country.persistence.Country;
import com.app.app.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryImpl implements ICountry {
     @Autowired
    private CountryRepository repository;

    @Override
    public List<Country> findAll() {
        return repository.findAll();
    }

    @Override
    public Country findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(Country.class.getName(), id));
    }

    @Override
    public Country save(Country country) {
        return repository.save(country);
    }

    @Override
    public Country update(Long id, Country country) {
        return repository.findById(id).map(existPeriod -> {
            existPeriod.setName(country.getName());
            return repository.save(existPeriod);
        }).orElseThrow(() -> new ResourceNotFoundException(Country.class.getName(), id));
    }

    @Override
    public void delete(Long id) {
        repository.delete(findById(id));
    }
}
