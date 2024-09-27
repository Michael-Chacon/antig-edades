package com.app.app.branch.domain.service;

import com.app.app.branch.DTO.BranchDTO;
import com.app.app.branch.domain.repository.BranchRepository;
import com.app.app.branch.persistence.Branch;
import com.app.app.city.domain.service.CityImpl;
import com.app.app.city.domain.service.ICity;
import com.app.app.city.persistence.City;
import com.app.app.company.domain.service.CompanyImpl;
import com.app.app.company.domain.service.ICompany;
import com.app.app.company.persistence.Company;
import com.app.app.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class BranchImpl implements IBranch {
     @Autowired
    private BranchRepository repository;

     @Autowired
     private ICity cityService;

     @Autowired
     private ICompany companyService;

    @Transactional(readOnly = true)
    @Override
    public List<Branch> findAll() {
        return repository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Branch findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(Branch.class.getName(), id));
    }

    @Override
    public Branch save(BranchDTO branchDTO) {
        City city = cityService.findById(branchDTO.getCityId());
        Company company = companyService.findById(branchDTO.getCompanyId());

        Branch branch = new Branch();
        branch.setCompany(company);
        branch.setCity(city);
        branch.setName(branchDTO.getName());
        return repository.save(branch);
    }

    @Override
    public Branch update(Long id, BranchDTO branchDTO) {
        Branch branch= findById(id);
        City city = cityService.findById(branchDTO.getCityId());
        Company company = companyService.findById(branchDTO.getCompanyId());
        branch.setName(branchDTO.getName());
        branch.setCity(city);
        branch.setCompany(company);
        return repository.save(branch);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
