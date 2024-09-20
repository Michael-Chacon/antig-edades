package com.app.app.user.domain.service;

import com.app.app.user.persistence.Users;

import java.util.List;

public interface IUsers {
    List<Users> findAll();
    Users findById(Long id);
    Users save(Users users);
    Users update(Long id, Users users);
    void delete(Long id);
}
