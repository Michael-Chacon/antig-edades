package com.app.app.gallery.domain.service;

import com.app.app.exceptions.ResourceNotFoundException;
import com.app.app.gallery.domain.repository.GalleryRepository;
import com.app.app.gallery.persistence.Gallery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GalleryImpl implements IGallery {
     @Autowired
    private GalleryRepository repository;

    @Transactional(readOnly = true)
     @Override
    public List<Gallery> findAll() {
        return repository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Gallery findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(Gallery.class.getName(), id));
    }

    @Transactional
    @Override
    public Gallery save(Gallery gallery) {
        return repository.save(gallery);
    }

    @Transactional
    @Override
    public Gallery update(Long id, Gallery gallery) {
        return repository.findById(id).map(existElement -> {
            existElement.setUrlPhoto(gallery.getUrlPhoto());
            existElement.setAntiquity(gallery.getAntiquity());
            return repository.save(existElement);
        }).orElseThrow(() -> new ResourceNotFoundException(Gallery.class.getName(), id));
    }

    @Transactional
    @Override
    public void delete(Long id) {
        repository.delete(findById(id));
    }
}
