package com.app.app.branch.domain.service;

import com.app.app.branch.persistence.Branch;

import java.util.List;

public interface IBranch {
    List<Branch> findAll();
    Branch findById(Long id);
    Branch save(Branch branch);
    Branch update(Long id, Branch branch);
    void delete(Long id);
}
