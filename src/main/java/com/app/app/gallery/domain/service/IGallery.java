package com.app.app.gallery.domain.service;

import com.app.app.categoria.persistence.Category;

import java.util.List;

public interface IGallery {
    List<Category> findAll();
    Category findById(Long id);
    Category save(Category category);
    Category update(Long id, Category category);
    void delete(Long id);
}
