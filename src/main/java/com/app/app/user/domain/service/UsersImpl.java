package com.app.app.user.domain.service;

import com.app.app.exceptions.ResourceNotFoundException;
import com.app.app.user.domain.repository.UserRepository;
import com.app.app.user.persistence.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersImpl implements IUsers {
     @Autowired
    private UserRepository repository;

    @Override
    public List<Users> findAll() {
        return repository.findAll();
    }

    @Override
    public Users findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(Users.class.getName(), id));
    }

    @Override
    public Users save(Users users) {
        return repository.save(users);
    }

    @Override
    public Users update(Long id, Users users) {
        return repository.findById(id).map(existElement -> {
            existElement.setName(users.getName());
            existElement.setLastnameOne(users.getLastnameOne());
            existElement.setLastnameTwo(users.getLastnameTwo());
            existElement.setEmail(users.getEmail());
            existElement.setPassword(users.getPassword());
            return repository.save(existElement);
        }).orElseThrow(() -> new ResourceNotFoundException(Users.class.getName(), id));
    }

    @Override
    public void delete(Long id) {
        repository.delete(findById(id));
    }
}
