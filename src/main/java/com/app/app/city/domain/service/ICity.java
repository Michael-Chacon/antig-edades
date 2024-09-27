package com.app.app.city.domain.service;

import com.app.app.city.DTO.CityDTO;
import com.app.app.city.persistence.City;

import java.util.List;

public interface ICity {
    List<City> findAll();
    City findById(Long id);
    City save(CityDTO city);
    City update(Long id, CityDTO city);
    void delete(Long id);
}
