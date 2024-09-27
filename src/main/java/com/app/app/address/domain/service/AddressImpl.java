package com.app.app.address.domain.service;

import com.app.app.address.DTO.AddressDTO;
import com.app.app.address.domain.repository.AddressRepository;
import com.app.app.address.persistence.Address;
import com.app.app.city.domain.service.ICity;
import com.app.app.city.persistence.City;
import com.app.app.exceptions.ResourceNotFoundException;
import com.app.app.typeAddress.domain.service.ITypeAddress;
import com.app.app.typeAddress.persistence.TypeAddress;
import com.app.app.user.domain.service.IUsers;
import com.app.app.user.persistence.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AddressImpl implements IAddress {
    @Autowired
    private AddressRepository repository;

    @Autowired
    private ICity cityService;

    @Autowired
    private IUsers userService;

    @Autowired
    private ITypeAddress typeAddressService;

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

    @Override
    public Address saveOrUpdate(Long id, AddressDTO addressDTO) {

        Address address;
        if (id != null) {
            address = findById(id);
        } else {
            address = new Address();
        }

        Users users = userService.findById(addressDTO.getUserId());
        City city = cityService.findById(addressDTO.getCityId());
        TypeAddress type = typeAddressService.findById(addressDTO.getTypeAddressId());

        address.setAddress(addressDTO.getAddress());
        address.setUsers(users);
        address.setTypeAddress(type);
        address.setCity(city);
        return repository.save(address);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
