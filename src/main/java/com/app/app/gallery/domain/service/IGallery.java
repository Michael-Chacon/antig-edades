package com.app.app.gallery.domain.service;

import com.app.app.gallery.persistence.Gallery;

import java.util.List;

public interface IGallery {
    List<Gallery> findAll();
    Gallery findById(Long id);
    Gallery save(Gallery gallery);
    Gallery update(Long id, Gallery gallery);
    void delete(Long id);
}
