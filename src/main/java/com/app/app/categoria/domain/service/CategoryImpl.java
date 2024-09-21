package com.app.app.categoria.domain.service;

import com.app.app.categoria.domain.repository.CategoryRepository;
import com.app.app.categoria.persistence.Category;
import com.app.app.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryImpl implements ICategory{
     @Autowired
    private CategoryRepository repository;

    @Transactional(readOnly = true)
     @Override
    public List<Category> findAll() {
        return repository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Category findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(Category.class.getName(), id));
    }

    @Transactional
    @Override
    public Category save(Category category) {
        return repository.save(category);
    }

    @Transactional
    @Override
    public Category update(Long id, Category category) {
        return repository.findById(id).map(existElemetn -> {
            existElemetn.setName(category.getName());
            return repository.save(existElemetn);
        }).orElseThrow(() -> new ResourceNotFoundException(Category.class.getName(), id));
    }

    @Transactional
    @Override
    public void delete(Long id) {
        repository.delete(findById(id));
    }
}
