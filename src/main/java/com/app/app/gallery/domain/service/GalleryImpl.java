package com.app.app.gallery.domain.service;

import com.app.app.categoria.persistence.Category;
import com.app.app.exceptions.ResourceNotFoundException;
import com.app.app.gallery.domain.repository.GalleryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GalleryImpl implements IGallery {
     @Autowired
    private GalleryRepository repository;

    @Override
    public List<Category> findAll() {
        return repository.findAll();
    }

    @Override
    public Category findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(Category.class.getName(), id));
    }

    @Override
    public Category save(Category category) {
        return repository.save(category);
    }

    @Override
    public Category update(Long id, Category category) {
        return repository.findById(id).map(existCategory -> {
            existCategory.setName(category.getName());
            return repository.save(existCategory);
        }).orElseThrow(() -> new ResourceNotFoundException(Category.class.getName(), id));
    }

    @Override
    public void delete(Long id) {
        repository.delete(findById(id));
    }
}
