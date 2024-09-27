package com.app.app.address.domain.service;

import com.app.app.address.DTO.AddressDTO;
import com.app.app.address.persistence.Address;

import java.util.List;

public interface IAddress {
    List<Address> findAll();
    Address findById(Long id);
    Address saveOrUpdate(Long id, AddressDTO address);
    void delete(Long id);
}
