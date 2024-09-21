package com.app.app.contactUser.domain.service;

import com.app.app.contactUser.persistence.DTO.ContactUserDTO;
import com.app.app.contactUser.persistence.entity.ContactUser;

import java.util.List;

public interface IContactUser {
    List<ContactUser> findAll();
    ContactUser findById(Long id);
    ContactUser save(ContactUserDTO dto);
    ContactUser update(Long id, ContactUserDTO dto);
    void delete(Long id);
}
