package com.app.app.city.domain.service;

import com.app.app.city.DTO.CityDTO;
import com.app.app.city.domain.repository.CityRepository;
import com.app.app.city.persistence.City;
import com.app.app.exceptions.ResourceNotFoundException;
import com.app.app.region.domain.service.RegionImpl;
import com.app.app.region.persistence.Region;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CityImpl implements ICity {
    @Autowired
    private CityRepository repository;

    @Autowired
    private RegionImpl regionImpl;

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
    public City save(CityDTO cityDTO) {
        // Validar que la region existe
        Region region = regionImpl.findById(cityDTO.getRegionId());
        City city = new City();
        city.setName(cityDTO.getName());
        city.setRegion(region);
        return repository.save(city);
    }

    @Transactional
    @Override
    public City update(Long id, CityDTO cityDTO) {
        return repository.findById(id).map(existElement -> {
            // Validar que la region existe
            Region region = regionImpl.findById(cityDTO.getRegionId());
            existElement.setName(cityDTO.getName());
            existElement.setRegion(region);
            return repository.save(existElement);
        }).orElseThrow(() -> new ResourceNotFoundException(City.class.getName(), id));
    }

    @Transactional
    @Override
    public void delete(Long id) {
        repository.delete(findById(id));
    }
}
