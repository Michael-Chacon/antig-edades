package com.app.app.typeContact.domain.service;

import com.app.app.exceptions.ResourceNotFoundException;
import com.app.app.typeContact.domain.repository.TypeContactRepository;
import com.app.app.typeContact.persistence.TypeContact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeContactImpl implements ITypeContact {
     @Autowired
    private TypeContactRepository repository;

    @Override
    public List<TypeContact> findAll() {
        return repository.findAll();
    }

    @Override
    public TypeContact findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(TypeContact.class.getName(), id));
    }

    @Override
    public TypeContact save(TypeContact typeContact) {
        return repository.save(typeContact);
    }

    @Override
    public TypeContact update(Long id, TypeContact typeContact) {
        return repository.findById(id).map(existElement -> {
            existElement.setName(typeContact.getName());
            return repository.save(existElement);
        }).orElseThrow(() -> new ResourceNotFoundException(TypeContact.class.getName(), id));
    }

    @Override
    public void delete(Long id) {
        repository.delete(findById(id));
    }
}
