package com.app.app.employee.domain.service;

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
        System.out.println("================="+user);
        Users aaa =  userRepository.save(user);
        System.out.println("_______________"+aaa);
        // Mapea el DTO a Employee, relaciona con Users y guarda
        Employee employee = UserEmployeeMapper.INSTANCE.toEmployee(employeeDto);
        employee.setUsers(user);
        repository.save(employee);
        return employeeDto;
    }

//    @Override
//    public UserEmployeeDTO update(Long id, UserEmployeeDTO employeeDTO) {
//        return repository.findById(id).map(existElement -> {
//            Users users = UserEmployeeMapper.INSTANCE.toUsers(employeeDTO);
//            userRepository.save(users);
//            Employee employee = UserEmployeeMapper.INSTANCE.toEmployee(employeeDTO);
//            existElement.setSalary(employee.getSalary());
//            existElement.setContractDate(employee.getContractDate());
//            existElement.setUsers(users);
//             repository.save(existElement);
//             return employeeDTO;
//        }).orElseThrow(() -> new ResourceNotFoundException(Employee.class.getName(), id));
//    }

    @Override
    public UserEmployeeDTO update(Long id, UserEmployeeDTO employeeDTO) {
        return repository.findById(id).map(existElement -> {
            // Busca el usuario asociado al empleado existente
            Users existingUser = existElement.getUsers();

            // Convierte el DTO a entidad Users
            Users updatedUser = UserEmployeeMapper.INSTANCE.toUsers(employeeDTO);

            // Actualiza los campos del usuario existente
            existingUser.setName(updatedUser.getName());
            existingUser.setEmail(updatedUser.getEmail());
            // ... actualiza otros campos según sea necesario

            // Guarda el usuario actualizado
            userRepository.save(existingUser);

            // Convierte el DTO a entidad Employee
            Employee updatedEmployee = UserEmployeeMapper.INSTANCE.toEmployee(employeeDTO);

            // Actualiza los campos del empleado existente
            existElement.setSalary(updatedEmployee.getSalary());
            existElement.setContractDate(updatedEmployee.getContractDate());
            existElement.setUsers(existingUser);

            // Guarda los cambios en la entidad Employee
            repository.save(existElement);

            return employeeDTO; // Devuelve el DTO actualizado
        }).orElseThrow(() -> new ResourceNotFoundException(Employee.class.getName(), id));
    }

    @Override
    public void delete(Long id) {
        repository.delete(findById(id));
    }
}
