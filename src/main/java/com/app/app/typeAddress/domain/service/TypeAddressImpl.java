package com.app.app.typeAddress.domain.service;

import com.app.app.exceptions.ResourceNotFoundException;
import com.app.app.typeAddress.domain.repository.TypeAddressRepository;
import com.app.app.typeAddress.persistence.TypeAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeAddressImpl implements ITypeAddress {
     @Autowired
    private TypeAddressRepository repository;

    @Override
    public List<TypeAddress> findAll() {
        return repository.findAll();
    }

    @Override
    public TypeAddress findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(TypeAddress.class.getName(), id));
    }

    @Override
    public TypeAddress save(TypeAddress typeAddress) {
        return repository.save(typeAddress);
    }

    @Override
    public TypeAddress update(Long id, TypeAddress typeAddress) {
        return repository.findById(id).map(existElement -> {
            existElement.setName(typeAddress.getName());
            return repository.save(existElement);
        }).orElseThrow(() -> new ResourceNotFoundException(TypeAddress.class.getName(), id));
    }

    @Override
    public void delete(Long id) {
        repository.delete(findById(id));
    }
}
