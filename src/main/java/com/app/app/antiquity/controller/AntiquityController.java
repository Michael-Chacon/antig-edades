package com.app.app.antiquity.controller;

import com.app.app.antiquity.DTO.AntiquityDTO;
import com.app.app.antiquity.DTO.AvailableDTO;
import com.app.app.antiquity.domain.service.IAntiquity;
import com.app.app.antiquity.persistence.Antiquity;
import com.app.app.utils.MakeValidation;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.Set;

import static com.app.app.consts.GeneralConst.ID_IN_PATH;

@RestController
@RequestMapping("/antiquity")
public class AntiquityController {
    @Autowired
    private IAntiquity service;

    @Autowired
    private MakeValidation makeValidation;

    @GetMapping
    public ResponseEntity<List<Antiquity>> getAllAntiquity(){
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping(ID_IN_PATH)
    public ResponseEntity<Antiquity> getAntiquityByid(@PathVariable Long id){
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<?> createAntiquity(@Valid @RequestBody AntiquityDTO antiquity, BindingResult result){
        if (result.hasFieldErrors()){
            return makeValidation.validation(result);
        }
        return ResponseEntity.ok(service.saveOrUpdate(null, antiquity));
    }

    @PutMapping(ID_IN_PATH)
    public ResponseEntity<Antiquity> updateAntiquity(@PathVariable Long id, @RequestBody AntiquityDTO antiquity){
        return ResponseEntity.ok(service.saveOrUpdate(id, antiquity));
    }

    @DeleteMapping(ID_IN_PATH)
    public ResponseEntity<?> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping("/forSold")
    public ResponseEntity<List<AvailableDTO>> getAvailableForSold(){
        return ResponseEntity.ok(service.availableForSold());
    }

    @GetMapping("/range")
    public ResponseEntity<Set<AvailableDTO>> getAntiquityForRangeOfPrice(){
        return ResponseEntity.ok(service.antiquityByRangeOfPrice());
    }

}
