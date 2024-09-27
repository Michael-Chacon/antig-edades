package com.app.app.region.domain.service;

import com.app.app.region.DTO.RegionDTO;
import com.app.app.region.persistence.Region;

import java.util.List;

public interface IRegion {
    List<Region> findAll();
    Region findById(Long id);
    Region save(RegionDTO region);
    Region update(Long id, RegionDTO region);
    void delete(Long id);
}
