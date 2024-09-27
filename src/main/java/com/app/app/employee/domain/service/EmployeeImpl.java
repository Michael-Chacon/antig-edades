package com.app.app.employee.domain.service;

import com.app.app.branch.domain.repository.BranchRepository;
import com.app.app.branch.domain.service.IBranch;
import com.app.app.branch.persistence.Branch;
import com.app.app.employee.domain.repository.EmployeeRepository;
import com.app.app.employee.persistence.DTO.UserEmployeeDTO;
import com.app.app.employee.persistence.entity.Employee;
import com.app.app.exceptions.ResourceNotFoundException;
import com.app.app.gender.domain.repository.GenderRepository;
import com.app.app.gender.domain.service.IGender;
import com.app.app.gender.persistence.Gender;
import com.app.app.mapper.UserEmployeeMapper;
import com.app.app.user.domain.repository.UserRepository;
import com.app.app.user.persistence.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class EmployeeImpl implements IEmployee {
    @Autowired
    private EmployeeRepository repository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private IBranch branchService;

    @Autowired
    private IGender genderService;

    @Transactional(readOnly = true)
    @Override
    public List<Employee> findAll() {
        return repository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Employee findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(Employee.class.getName(), id));
    }

    @Override
    public Employee save(UserEmployeeDTO employeeDto) {
        Users user = UserEmployeeMapper.INSTANCE.toUsers(employeeDto);
        Branch branch = branchService.findById(employeeDto.getCodeBranch());
        Gender gender = genderService.findById(employeeDto.getCodeGender());
        user.setBranch(branch);
        user.setGender(gender);
        userRepository.save(user);

        Employee employee = UserEmployeeMapper.INSTANCE.toEmployee(employeeDto);
        employee.setUsers(user);
        return repository.save(employee);
    }

    @Override
    public Employee update(Long id, UserEmployeeDTO employeeDTO) {
        Employee employee = findById(id);

        Branch newBranch = branchService.findById(employeeDTO.getCodeBranch());
        Gender newGender = genderService.findById(employeeDTO.getCodeGender());

        Users existingUser = employee.getUsers();
        Users updatedUser = UserEmployeeMapper.INSTANCE.toUsers(employeeDTO);

        existingUser.setName(updatedUser.getName());
        existingUser.setLastnameOne(updatedUser.getLastnameOne());
        existingUser.setLastnameTwo(updatedUser.getLastnameTwo());
        existingUser.setEmail(updatedUser.getEmail());
        existingUser.setBranch(newBranch);
        existingUser.setGender(newGender);

        Employee updatedEmployee = UserEmployeeMapper.INSTANCE.toEmployee(employeeDTO);
        employee.setSalary(updatedEmployee.getSalary());
        employee.setContractDate(updatedEmployee.getContractDate());
        employee.setUsers(existingUser);
        return repository.save(employee);
    }

    @Transactional
    @Override
    public void delete(Long id) {
        repository.delete(findById(id));
    }
}
