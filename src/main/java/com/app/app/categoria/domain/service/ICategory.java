package com.app.app.categoria.domain.service;

import com.app.app.categoria.persistence.Category;

import java.util.List;
import java.util.Optional;

public interface ICategory {
    List<Category> findAll();
    Category findById(Long id);
    Category save(Category category);
    Category update(Long id, Category category);
    void delete(Long id);
}
