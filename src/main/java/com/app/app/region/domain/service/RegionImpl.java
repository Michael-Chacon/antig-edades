package com.app.app.region.domain.service;

import com.app.app.country.domain.repository.CountryRepository;
import com.app.app.country.domain.service.CountryImpl;
import com.app.app.country.domain.service.ICountry;
import com.app.app.country.persistence.Country;
import com.app.app.exceptions.ResourceNotFoundException;
import com.app.app.region.DTO.RegionDTO;
import com.app.app.region.domain.repository.RegionRepository;
import com.app.app.region.persistence.Region;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class RegionImpl implements IRegion {
    @Autowired
    private RegionRepository repository;

    @Autowired
    private ICountry countrySevice;

    @Transactional(readOnly = true)
    @Override
    public List<Region> findAll() {
        return repository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Region findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(Region.class.getName(), id));
    }

    @Override
    public Region save(RegionDTO regionDTO) {
        Country country = countrySevice.findById(regionDTO.getCountryId());
        Region region = new Region();
        region.setName(regionDTO.getName());
        region.setCountry(country);
        return repository.save(region);
    }

    @Override
    public Region update(Long id, RegionDTO regionDTO) {
        Region region = findById(id);
        Country country = countrySevice.findById(regionDTO.getCountryId());
        region.setName(regionDTO.getName());
        region.setCountry(country);
        return repository.save(region);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
