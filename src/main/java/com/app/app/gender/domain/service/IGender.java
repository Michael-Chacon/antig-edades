package com.app.app.gender.domain.service;

import com.app.app.gender.persistence.Gender;

import java.util.List;

public interface IGender {
    List<Gender> findAll();
    Gender findById(Long id);
    Gender save(Gender gender);
    Gender update(Long id, Gender gender);
    void delete(Long id);
}
