package com.app.app.company.domain.service;

import com.app.app.company.domain.repository.CompanyRepository;
import com.app.app.company.persistence.Company;
import com.app.app.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyImpl implements ICompany {
     @Autowired
    private CompanyRepository repository;

    @Override
    public List<Company> findAll() {
        return repository.findAll();
    }

    @Override
    public Company findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(Company.class.getName(), id));
    }

    @Override
    public Company save(Company company) {
        return repository.save(company);
    }

    @Override
    public Company update(Long id, Company company) {
        return repository.findById(id).map(existElemetn -> {
            existElemetn.setName(company.getName());
            return repository.save(existElemetn);
        }).orElseThrow(() -> new ResourceNotFoundException(Company.class.getName(), id));
    }

    @Override
    public void delete(Long id) {
        repository.delete(findById(id));
    }
}
