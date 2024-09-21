package com.app.app.employee.domain.service;

import com.app.app.employee.persistence.DTO.UserEmployeeDTO;
import com.app.app.employee.persistence.entity.Employee;

import java.util.List;

public interface IEmployee {
    List<Employee> findAll();
    Employee findById(Long id);
    UserEmployeeDTO save(UserEmployeeDTO employeeDTO);
    UserEmployeeDTO update(Long id, UserEmployeeDTO employeeDTO);
    void delete(Long id);
}
