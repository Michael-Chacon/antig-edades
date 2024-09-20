package com.app.app.city.domain.service;

import com.app.app.city.persistence.City;

import java.util.List;

public interface ICity {
    List<City> findAll();
    City findById(Long id);
    City save(City city);
    City update(Long id, City city);
    void delete(Long id);
}
