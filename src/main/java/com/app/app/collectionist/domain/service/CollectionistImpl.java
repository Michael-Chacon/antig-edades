package com.app.app.collectionist.domain.service;

import com.app.app.branch.domain.repository.BranchRepository;
import com.app.app.branch.persistence.Branch;
import com.app.app.collectionist.domain.repository.CollectionistRepository;
import com.app.app.collectionist.persistence.DTO.UserCollectionistDTO;
import com.app.app.collectionist.persistence.entity.Collectionist;
import com.app.app.exceptions.ResourceNotFoundException;
import com.app.app.gender.domain.repository.GenderRepository;
import com.app.app.gender.persistence.Gender;
import com.app.app.mapper.UserCollectionistMapper;
import com.app.app.user.domain.repository.UserRepository;
import com.app.app.user.persistence.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CollectionistImpl implements ICollectionist {
    @Autowired
    private CollectionistRepository repository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BranchRepository branchRepository;

    @Autowired
    private GenderRepository genderRepository;

    @Transactional(readOnly = true)
    @Override
    public List<Collectionist> findAll() {
        return repository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Collectionist findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(Collectionist.class.getName(), id));
    }

    @Transactional
    @Override
    public UserCollectionistDTO save(UserCollectionistDTO employeeDto) {
        Users user = UserCollectionistMapper.INSTANCE.toUsers(employeeDto);
        Branch branch = branchRepository.findById(employeeDto.getCodeBranch()).orElseThrow(() -> new ResourceNotFoundException(Branch.class.getName(), employeeDto.getCodeBranch()));
        user.setBranch(branch);
        Gender gender = genderRepository.findById(employeeDto.getCodeGender()).orElseThrow(() -> new ResourceNotFoundException(Gender.class.getName(), employeeDto.getCodeGender()));
        user.setGender(gender);
        userRepository.save(user);
        Collectionist collectionist = UserCollectionistMapper.INSTANCE.toCollectionist(employeeDto);
        collectionist.setUsers(user);
        repository.save(collectionist);
        return employeeDto;
    }

    @Transactional
    @Override
    public UserCollectionistDTO update(Long id, UserCollectionistDTO employeeDTO) {
        return repository.findById(id).map(existElement -> {
            Users existingUser = existElement.getUsers();
            Branch newBranch = branchRepository.findById(employeeDTO.getCodeBranch()).orElseThrow(() -> new ResourceNotFoundException(Branch.class.getName(), employeeDTO.getCodeBranch()));
            Gender newGender = genderRepository.findById(employeeDTO.getCodeGender()).orElseThrow(() -> new ResourceNotFoundException(Gender.class.getName(), employeeDTO.getCodeGender()));
            Users updatedUser = UserCollectionistMapper.INSTANCE.toUsers(employeeDTO);
            existingUser.setName(updatedUser.getName());
            existingUser.setLastnameOne(updatedUser.getLastnameOne());
            existingUser.setLastnameTwo(updatedUser.getLastnameTwo());
            existingUser.setEmail(updatedUser.getEmail());
            existingUser.setBranch(newBranch);
            existingUser.setGender(newGender);

            Collectionist updatedCollectionist = UserCollectionistMapper.INSTANCE.toCollectionist(employeeDTO);
            existElement.setLoan(updatedCollectionist.getLoan());
            existElement.setContractDate(updatedCollectionist.getContractDate());
            existElement.setUsers(existingUser);
            repository.save(existElement);

            return employeeDTO;
        }).orElseThrow(() -> new ResourceNotFoundException(Collectionist.class.getName(), id));
    }

    @Transactional
    @Override
    public void delete(Long id) {
        repository.delete(findById(id));
    }
}
