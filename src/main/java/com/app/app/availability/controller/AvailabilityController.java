package com.app.app.availability.controller;

import com.app.app.availability.domain.service.IAvailability;
import com.app.app.availability.persistence.Availability;
import com.app.app.utils.MakeValidation;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.app.app.consts.GeneralConst.ID_IN_PATH;

@RestController
@RequestMapping("/availability")
public class AvailabilityController {
    @Autowired
    private IAvailability service;

    @Autowired
    private MakeValidation makeValidation;

    @GetMapping
    public ResponseEntity<List<Availability>> getAllAvailability(){
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping(ID_IN_PATH)
    public ResponseEntity<Availability> getAvailabilityByid(@PathVariable Long id){
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<?> createAvailability(@Valid @RequestBody Availability availability, BindingResult result){
        if (result.hasFieldErrors()){
            return makeValidation.validation(result);
        }
        return ResponseEntity.ok(service.save(availability));
    }

    @PutMapping(ID_IN_PATH)
    public ResponseEntity<Availability> updateAvailability(@PathVariable Long id, @RequestBody Availability availability){
        return ResponseEntity.ok(service.update(id, availability));
    }

    @DeleteMapping(ID_IN_PATH)
    public ResponseEntity<?> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
