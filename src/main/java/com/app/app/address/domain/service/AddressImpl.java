package com.app.app.address.domain.service;

import com.app.app.address.domain.repository.AddressRepository;
import com.app.app.address.persistence.Address;
import com.app.app.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AddressImpl implements IAddress {
     @Autowired
    private AddressRepository repository;

    @Transactional(readOnly = true)
    @Override
    public List<Address> findAll() {
        return repository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Address findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(Address.class.getName(), id));
    }

    @Transactional
    @Override
    public Address save(Address address) {
        return repository.save(address);
    }

    @Transactional
    @Override
    public Address update(Long id, Address address) {
        return repository.findById(id).map(existElement -> {
            existElement.setAddress(address.getAddress());
            existElement.setUsers(address.getUsers());
            existElement.setTypeAddress(address.getTypeAddress());
            existElement.setCity(address.getCity());
            return repository.save(existElement);
        }).orElseThrow(() -> new ResourceNotFoundException(Address.class.getName(), id));
    }

    @Transactional
    @Override
    public void delete(Long id) {
        repository.delete(findById(id));
    }
}
