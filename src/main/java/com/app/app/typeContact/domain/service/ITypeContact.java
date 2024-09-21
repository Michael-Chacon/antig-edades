package com.app.app.typeContact.domain.service;

import com.app.app.typeContact.persistence.TypeContact;

import java.util.List;

public interface ITypeContact {
    List<TypeContact> findAll();
    TypeContact findById(Long id);
    TypeContact save(TypeContact typeContact);
    TypeContact update(Long id, TypeContact typeContact);
    void delete(Long id);
}
