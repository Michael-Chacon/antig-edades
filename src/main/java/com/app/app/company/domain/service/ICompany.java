package com.app.app.company.domain.service;

import com.app.app.company.persistence.Company;

import java.util.List;

public interface ICompany {
    List<Company> findAll();
    Company findById(Long id);
    Company save(Company company);
    Company update(Long id, Company company);
    void delete(Long id);
}
