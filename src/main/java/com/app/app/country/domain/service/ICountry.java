package com.app.app.country.domain.service;

import com.app.app.country.persistence.Country;

import java.util.List;

public interface ICountry {
    List<Country> findAll();
    Country findById(Long id);
    Country save(Country country);
    Country update(Long id, Country country);
    void delete(Long id);
}
