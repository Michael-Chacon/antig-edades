package com.app.app.employee.domain.service;

import com.app.app.branch.domain.repository.BranchRepository;
import com.app.app.branch.persistence.Branch;
import com.app.app.employee.domain.repository.EmployeeRepository;
import com.app.app.employee.persistence.DTO.UserEmployeeDTO;
import com.app.app.employee.persistence.entity.Employee;
import com.app.app.exceptions.ResourceNotFoundException;
import com.app.app.mapper.UserEmployeeMapper;
import com.app.app.user.domain.repository.UserRepository;
import com.app.app.user.persistence.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeImpl implements IEmployee {
     @Autowired
    private EmployeeRepository repository;

     @Autowired
     private UserRepository userRepository;

     @Autowired
     private BranchRepository branchRepository;

    @Override
    public List<Employee> findAll() {
        return repository.findAll();
    }

    @Override
    public Employee findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(Employee.class.getName(), id));
    }

    @Override
    public UserEmployeeDTO save(UserEmployeeDTO employeeDto) {
        System.out.println("---------------------"+employeeDto);
        Users user = UserEmployeeMapper.INSTANCE.toUsers(employeeDto);
        Branch branch = branchRepository.findById(employeeDto.getCodeBranch()).orElseThrow(() -> new ResourceNotFoundException(Branch.class.getName(), employeeDto.getCodeBranch()));
        System.out.println("================="+user);
        user.setBranch(branch);
        Users aaa =  userRepository.save(user);
        System.out.println("_______________"+aaa);
        // Mapea el DTO a Employee, relaciona con Users y guarda
        Employee employee = UserEmployeeMapper.INSTANCE.toEmployee(employeeDto);
        employee.setUsers(user);
        repository.save(employee);
        return employeeDto;
    }

    @Override
    public UserEmployeeDTO update(Long id, UserEmployeeDTO employeeDTO) {
        return repository.findById(id).map(existElement -> {
            Users existingUser = existElement.getUsers();

            Users updatedUser = UserEmployeeMapper.INSTANCE.toUsers(employeeDTO);
            existingUser.setName(updatedUser.getName());
            existingUser.setLastnameOne(updatedUser.getLastnameOne());
            existingUser.setLastnameTwo(updatedUser.getLastnameTwo());
            existingUser.setEmail(updatedUser.getEmail());
            userRepository.save(existingUser);

            Employee updatedEmployee = UserEmployeeMapper.INSTANCE.toEmployee(employeeDTO);
            existElement.setSalary(updatedEmployee.getSalary());
            existElement.setContractDate(updatedEmployee.getContractDate());
            existElement.setUsers(existingUser);
            repository.save(existElement);

            return employeeDTO;
        }).orElseThrow(() -> new ResourceNotFoundException(Employee.class.getName(), id));
    }

    @Override
    public void delete(Long id) {
        repository.delete(findById(id));
    }
}
