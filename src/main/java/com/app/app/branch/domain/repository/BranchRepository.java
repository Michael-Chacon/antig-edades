package com.app.app.branch.domain.repository;

import com.app.app.branch.persistence.Branch;
import org.springframework.data.jpa.repository.JpaRepository;
public interface BranchRepository extends JpaRepository<Branch, Long> {
}
