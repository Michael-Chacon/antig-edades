package com.app.app.branch.domain.service;

import com.app.app.branch.domain.repository.BranchRepository;
import com.app.app.branch.persistence.Branch;
import com.app.app.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BranchImpl implements IBranch {
     @Autowired
    private BranchRepository repository;

    @Override
    public List<Branch> findAll() {
        return repository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Branch findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(Branch.class.getName(), id));
    }

    @Transactional
    @Override
    public Branch save(Branch branch) {
        return repository.save(branch);
    }

    @Transactional
    @Override
    public Branch update(Long id, Branch branch) {
        return repository.findById(id).map(existElement -> {
            existElement.setName(branch.getName());
            existElement.setCity(branch.getCity());
            existElement.setCompany(branch.getCompany());
            return repository.save(existElement);
        }).orElseThrow(() -> new ResourceNotFoundException(Branch.class.getName(), id));
    }

    @Transactional
    @Override
    public void delete(Long id) {
        repository.delete(findById(id));
    }
}
