package com.app.app.employee.domain.service;

import com.app.app.employee.domain.repository.EmployeeRepository;
import com.app.app.employee.persistence.DTO.UserEmployeeDTO;
import com.app.app.employee.persistence.entity.Employee;
import com.app.app.exceptions.ResourceNotFoundException;
import com.app.app.user.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeImpl implements IEmployee {
     @Autowired
    private EmployeeRepository repository;

     private UserRepository userRepository;

    @Override
    public List<Employee> findAll() {
        return repository.findAll();
    }

    @Override
    public Employee findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(Employee.class.getName(), id));
    }

    @Override
    public UserEmployeeDTO save(UserEmployeeDTO employee) {
        return repository.save(employee);
    }

    @Override
    public Employee update(Long id, Employee employee) {
        return repository.findById(id).map(existElement -> {
            existElement.setSalary(employee.getSalary());
            existElement.setContractDate(employee.getContractDate());
            existElement.setUsers(employee.getUsers());
            return repository.save(existElement);
        }).orElseThrow(() -> new ResourceNotFoundException(Employee.class.getName(), id));
    }

    @Override
    public void delete(Long id) {
        repository.delete(findById(id));
    }
}
