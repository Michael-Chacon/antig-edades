package com.app.app.collectionist.domain.service;

import com.app.app.branch.domain.repository.BranchRepository;
import com.app.app.branch.domain.service.IBranch;
import com.app.app.branch.persistence.Branch;
import com.app.app.collectionist.domain.repository.CollectionistRepository;
import com.app.app.collectionist.persistence.DTO.UserCollectionistDTO;
import com.app.app.collectionist.persistence.entity.Collectionist;
import com.app.app.exceptions.ResourceNotFoundException;
import com.app.app.gender.domain.repository.GenderRepository;
import com.app.app.gender.domain.service.IGender;
import com.app.app.gender.persistence.Gender;
import com.app.app.mapper.UserCollectionistMapper;
import com.app.app.user.domain.repository.UserRepository;
import com.app.app.user.persistence.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CollectionistImpl implements ICollectionist {
    @Autowired
    private CollectionistRepository repository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private IBranch branchService;

    @Autowired
    private IGender genderService;

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

    @Override
    public UserCollectionistDTO save(UserCollectionistDTO employeeDto) {
        Users user = UserCollectionistMapper.INSTANCE.toUsers(employeeDto);
        Branch branch = branchService.findById(employeeDto.getCodeBranch());
        Gender gender = genderService.findById(employeeDto.getCodeGender());
        user.setBranch(branch);
        user.setGender(gender);

        userRepository.save(user);
        Collectionist collectionist = UserCollectionistMapper.INSTANCE.toCollectionist(employeeDto);
        collectionist.setUsers(user);
        repository.save(collectionist);
        return employeeDto;
    }

    @Override
    public UserCollectionistDTO update(Long id, UserCollectionistDTO employeeDTO) {
        Collectionist collectionist = findById(id);


        Users existingUser = collectionist.getUsers();
        Branch newBranch = branchService.findById(employeeDTO.getCodeBranch());
        Gender newGender = genderService.findById(employeeDTO.getCodeGender());
        Users updatedUser = UserCollectionistMapper.INSTANCE.toUsers(employeeDTO);
        existingUser.setName(updatedUser.getName());
        existingUser.setLastnameOne(updatedUser.getLastnameOne());
        existingUser.setLastnameTwo(updatedUser.getLastnameTwo());
        existingUser.setEmail(updatedUser.getEmail());
        existingUser.setBranch(newBranch);
        existingUser.setGender(newGender);

        Collectionist updatedCollectionist = UserCollectionistMapper.INSTANCE.toCollectionist(employeeDTO);
        collectionist.setLoan(updatedCollectionist.getLoan());
        collectionist.setContractDate(updatedCollectionist.getContractDate());
        collectionist.setUsers(existingUser);
        repository.save(collectionist);

        return employeeDTO;
    }

    @Transactional
    @Override
    public void delete(Long id) {
        repository.delete(findById(id));
    }
}
