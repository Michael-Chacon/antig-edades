package com.app.app.region.domain.service;

import com.app.app.exceptions.ResourceNotFoundException;
import com.app.app.region.domain.repository.RegionRepository;
import com.app.app.region.persistence.Region;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RegionImpl implements IRegion {
     @Autowired
    private RegionRepository repository;

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

    @Transactional
    @Override
    public Region save(Region region) {
        return repository.save(region);
    }

    @Transactional
    @Override
    public Region update(Long id, Region region) {
        return repository.findById(id).map(existElement -> {
            existElement.setName(region.getName());
            existElement.setCountry(region.getCountry());
            return repository.save(existElement);
        }).orElseThrow(() -> new ResourceNotFoundException(Region.class.getName(), id));
    }

    @Transactional
    @Override
    public void delete(Long id) {
        repository.delete(findById(id));
    }
}
