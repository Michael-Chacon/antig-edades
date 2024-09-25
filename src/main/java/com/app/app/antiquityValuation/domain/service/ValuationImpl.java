package com.app.app.antiquityValuation.domain.service;

import com.app.app.antiquityValuation.DTO.AntiquityMoreViewDTO;
import com.app.app.antiquityValuation.DTO.SaveValuationDTO;
import com.app.app.antiquityValuation.domain.repository.ValuationRepository;
import com.app.app.antiquityValuation.persistence.Valuation;
import com.app.app.antiquity.domain.service.IAntiquity;
import com.app.app.antiquity.persistence.Antiquity;
import com.app.app.exceptions.ResourceNotFoundException;
import com.app.app.user.domain.service.IUsers;
import com.app.app.user.persistence.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ValuationImpl implements IValuation {
     @Autowired
    private ValuationRepository repository;

     @Autowired
     private IUsers iUsers;

     @Autowired
     private IAntiquity iAntiquity;

    @Transactional(readOnly = true)
    @Override
    public List<Valuation> findAll() {
        return repository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Valuation findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(Valuation.class.getName(), id));
    }

    @Transactional
    @Override
    public Valuation save(SaveValuationDTO valuationDTO) {
        Users users = iUsers.findById(valuationDTO.getCodeUser());
        Antiquity antiquity = iAntiquity.findById(valuationDTO.getCodeAntiquity());
        Valuation valuation = new Valuation();
        valuation.setValuation(valuationDTO.getScore());
        valuation.setComment(valuationDTO.getComment());
        valuation.setAntiquity(antiquity);
        valuation.setUsers(users);
        return repository.save(valuation);
    }

    @Transactional
    @Override
    public Valuation update(Long id, SaveValuationDTO valuationDTO) {
        return repository.findById(id).map(existElement -> {
            Antiquity antiquity = iAntiquity.findById(valuationDTO.getCodeAntiquity());
            Users users = iUsers.findById(valuationDTO.getCodeUser());
            existElement.setAntiquity(antiquity);
            existElement.setUsers(users);
            existElement.setValuation(valuationDTO.getScore());
            existElement.setComment(valuationDTO.getComment());
            return repository.save(existElement);
        }).orElseThrow(() -> new ResourceNotFoundException(Valuation.class.getName(), id));
    }

    @Transactional
    @Override
    public void delete(Long id) {
        repository.delete(findById(id));
    }

    @Override
    public List<AntiquityMoreViewDTO> moreViews() {
        return repository.moreVisitors();
    }
}
