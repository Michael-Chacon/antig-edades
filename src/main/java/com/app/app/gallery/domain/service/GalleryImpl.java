package com.app.app.gallery.domain.service;

import com.app.app.antiquity.domain.service.IAntiquity;
import com.app.app.antiquity.persistence.Antiquity;
import com.app.app.exceptions.ResourceNotFoundException;
import com.app.app.gallery.DTO.GalleryDTO;
import com.app.app.gallery.domain.repository.GalleryRepository;
import com.app.app.gallery.persistence.Gallery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class GalleryImpl implements IGallery {
    @Autowired
    private GalleryRepository repository;

    @Autowired
    private IAntiquity antiquityService;

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

    @Override
    public Gallery saveOrUpdate(Long id, GalleryDTO galleryDTO) {
        Gallery gallery;

        if (id != null) {
            gallery = findById(id);
        } else {
            gallery = new Gallery();
        }

        Antiquity antiquity = antiquityService.findById(galleryDTO.getAntiquityId());
        gallery.setAntiquity(antiquity);
        gallery.setUrlPhoto(galleryDTO.getUrl());
        return repository.save(gallery);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
