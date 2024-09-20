package com.app.app.region.domain.service;

import com.app.app.region.persistence.Region;

import java.util.List;

public interface IRegion {
    List<Region> findAll();
    Region findById(Long id);
    Region save(Region region);
    Region update(Long id, Region region);
    void delete(Long id);
}
