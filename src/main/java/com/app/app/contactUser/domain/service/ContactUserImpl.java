package com.app.app.contactUser.domain.service;

import com.app.app.contactUser.domain.repository.ContactUserRepository;
import com.app.app.contactUser.persistence.DTO.ContactUserDTO;
import com.app.app.contactUser.persistence.entity.ContactUser;
import com.app.app.exceptions.ResourceNotFoundException;
import com.app.app.typeContact.domain.repository.TypeContactRepository;
import com.app.app.typeContact.persistence.TypeContact;
import com.app.app.user.domain.repository.UserRepository;
import com.app.app.user.persistence.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactUserImpl implements IContactUser {
    @Autowired
    private ContactUserRepository repository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TypeContactRepository contactRepository;

    @Override
    public List<ContactUser> findAll() {
        return repository.findAll();
    }

    @Override
    public ContactUser findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(ContactUser.class.getName(), id));
    }

    @Override
    public ContactUser save(ContactUserDTO contactUserDTO) {
        Users users = userRepository.findById(contactUserDTO.getUsers()).orElseThrow(() -> new ResourceNotFoundException(Users.class.getName(), contactUserDTO.getUsers()));
        TypeContact typeContact = contactRepository.findById(contactUserDTO.getTypeContact()).orElseThrow(() -> new ResourceNotFoundException(TypeContact.class.getName(), contactUserDTO.getTypeContact()));

        ContactUser contactUser = new ContactUser();
        contactUser.setUsers(users);
        contactUser.setTypeContact(typeContact);
        contactUser.setContact(contactUserDTO.getContact());
        return repository.save(contactUser);
    }

    @Override
    public ContactUser update(Long id, ContactUserDTO contactUserDTO) {
        return repository.findById(id).map(existElement -> {
            TypeContact typeContact = contactRepository.findById(contactUserDTO.getTypeContact()).orElseThrow(() -> new ResourceNotFoundException(TypeContact.class.getName(), contactUserDTO.getTypeContact()));
            existElement.setContact(contactUserDTO.getContact());
            existElement.setTypeContact(typeContact);
            return repository.save(existElement);
        }).orElseThrow(() -> new ResourceNotFoundException(ContactUser.class.getName(), id));
    }

    @Override
    public void delete(Long id) {
        repository.delete(findById(id));
    }
}
