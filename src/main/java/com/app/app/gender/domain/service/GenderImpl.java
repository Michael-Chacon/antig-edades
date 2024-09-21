package com.app.app.gender.domain.service;

import com.app.app.exceptions.ResourceNotFoundException;
import com.app.app.gender.domain.repository.GenderRepository;
import com.app.app.gender.persistence.Gender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GenderImpl implements IGender {
     @Autowired
    private GenderRepository repository;

    @Transactional(readOnly = true)
     @Override
    public List<Gender> findAll() {
        return repository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Gender findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(Gender.class.getName(), id));
    }

    @Transactional
    @Override
    public Gender save(Gender gender) {
        return repository.save(gender);
    }

    @Transactional
    @Override
    public Gender update(Long id, Gender gender) {
        return repository.findById(id).map(existElement -> {
            existElement.setName(gender.getName());
            return repository.save(existElement);
        }).orElseThrow(() -> new ResourceNotFoundException(Gender.class.getName(), id));
    }

    @Transactional
    @Override
    public void delete(Long id) {
        repository.delete(findById(id));
    }
}
