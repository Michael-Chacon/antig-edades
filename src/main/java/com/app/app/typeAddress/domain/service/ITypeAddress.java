package com.app.app.typeAddress.domain.service;

import com.app.app.typeAddress.persistence.TypeAddress;

import java.util.List;

public interface ITypeAddress {
    List<TypeAddress> findAll();
    TypeAddress findById(Long id);
    TypeAddress save(TypeAddress typeAddress);
    TypeAddress update(Long id, TypeAddress typeAddress);
    void delete(Long id);
}
