package com.app.app.employee.domain.repository;

import com.app.app.employee.persistence.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
