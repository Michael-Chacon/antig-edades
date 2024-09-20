package com.app.app.address.domain.service;

import com.app.app.address.persistence.Address;

import java.util.List;

public interface IAddress {
    List<Address> findAll();
    Address findById(Long id);
    Address save(Address address);
    Address update(Long id, Address address);
    void delete(Long id);
}
