package com.app.app.city.domain.service;

import com.app.app.city.domain.repository.CityRepository;
import com.app.app.city.persistence.City;
import com.app.app.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CityImpl implements ICity {
     @Autowired
    private CityRepository repository;

    @Transactional(readOnly = true)
     @Override
    public List<City> findAll() {
        return repository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public City findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(City.class.getName(), id));
    }

    @Transactional
    @Override
    public City save(City city) {
        return repository.save(city);
    }

    @Transactional
    @Override
    public City update(Long id, City city) {
        return repository.findById(id).map(existElement -> {
            existElement.setName(city.getName());
            existElement.setRegion(city.getRegion());
            return repository.save(existElement);
        }).orElseThrow(() -> new ResourceNotFoundException(City.class.getName(), id));
    }

    @Transactional
    @Override
    public void delete(Long id) {
        repository.delete(findById(id));
    }
}
