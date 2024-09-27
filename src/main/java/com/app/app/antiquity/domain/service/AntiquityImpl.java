package com.app.app.antiquity.domain.service;

import com.app.app.antiquity.DTO.AntiquityDTO;
import com.app.app.antiquity.DTO.AvailableDTO;
import com.app.app.antiquity.domain.repository.AntiquityRepository;
import com.app.app.antiquity.persistence.Antiquity;
import com.app.app.availability.domain.service.IAvailability;
import com.app.app.availability.persistence.Availability;
import com.app.app.branch.domain.service.IBranch;
import com.app.app.branch.persistence.Branch;
import com.app.app.categoria.domain.service.ICategory;
import com.app.app.categoria.persistence.Category;
import com.app.app.conservationStatus.domain.service.IConservationStatus;
import com.app.app.conservationStatus.persistence.ConservationStatus;
import com.app.app.exceptions.ResourceNotFoundException;
import com.app.app.period.domain.service.IPeriod;
import com.app.app.period.persistence.Period;
import com.app.app.user.domain.service.IUsers;
import com.app.app.user.persistence.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Service
@Transactional
public class AntiquityImpl implements IAntiquity {
     @Autowired
    private AntiquityRepository repository;

     @Autowired
     private ICategory categoryService;

     @Autowired
     private IPeriod periodService;

     @Autowired
     private IConservationStatus conservationService;

     @Autowired
     private IAvailability availabilityService;

     @Autowired
     private IBranch branchService;

     @Autowired
     private IUsers userService;

    @Transactional(readOnly = true)
     @Override
    public List<Antiquity> findAll() {
        return repository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Antiquity findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(Antiquity.class.getName(), id));
    }

    @Override
    public Antiquity saveOrUpdate(Long id, AntiquityDTO antiquityDTO) {
        Antiquity antiquity;

        if (id != null){
            antiquity = findById(id);
        }else{
            antiquity = new Antiquity();
        }

        Category category = categoryService.findById(antiquityDTO.getCategoryId());
        Period period = periodService.findById(antiquityDTO.getPeriodId());
        ConservationStatus conservationStatus = conservationService.findById(antiquityDTO.getConservationId());
        Availability availability = availabilityService.findById(antiquityDTO.getAvailabilityId());
        Branch branch = branchService.findById(antiquityDTO.getBranchId());
        Users user = userService.findById(antiquityDTO.getOwnerId());

        antiquity.setCategory(category);
        antiquity.setPeriod(period);
        antiquity.setConservationStatus(conservationStatus);
        antiquity.setAvailability(availability);
        antiquity.setBranch(branch);
        antiquity.setOwner(user);
        antiquity.setName(antiquityDTO.getName());
        antiquity.setDescription(antiquityDTO.getDescription());
        antiquity.setPrice(antiquityDTO.getPrice());
        antiquity.setOrigin(antiquityDTO.getOrigin());
        return repository.save(antiquity);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Transactional(readOnly = true)
    @Override
    public List<AvailableDTO> availableForSold() {
        return repository.findAntiquityByAvailableStatus();
    }

    @Transactional(readOnly = true)
    @Override
    public Set<AvailableDTO> antiquityByRangeOfPrice() {
        return repository.findAntiquitiesForRangePrice(new BigDecimal("1000"), new BigDecimal("3000"));
    }
}
