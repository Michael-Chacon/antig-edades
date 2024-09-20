package com.app.app.antiquity.domain.service;

import com.app.app.antiquity.persistence.Antiquity;

import java.util.List;

public interface IAntiquity {
    List<Antiquity> findAll();
    Antiquity findById(Long id);
    Antiquity save(Antiquity antiquity);
    Antiquity update(Long id, Antiquity antiquity);
    void delete(Long id);
}
