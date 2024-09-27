package com.app.app.gallery.domain.service;

import com.app.app.gallery.DTO.GalleryDTO;
import com.app.app.gallery.persistence.Gallery;

import java.util.List;

public interface IGallery {
    List<Gallery> findAll();
    Gallery findById(Long id);
    Gallery saveOrUpdate(Long id, GalleryDTO gallery);
    void delete(Long id);
}
