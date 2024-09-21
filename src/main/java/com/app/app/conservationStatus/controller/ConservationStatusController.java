package com.app.app.conservationStatus.controller;

import com.app.app.conservationStatus.domain.service.IConservationStatus;
import com.app.app.conservationStatus.persistence.ConservationStatus;
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
@RequestMapping("/conservationStatus")
public class ConservationStatusController {
    @Autowired
    private IConservationStatus service;

    @Autowired
    private MakeValidation makeValidation;

    @GetMapping
    public ResponseEntity<List<ConservationStatus>> getAllStatus(){
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping(ID_IN_PATH)
    public ResponseEntity<ConservationStatus> getStatusByid(@PathVariable Long id){
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<?> createStatus(@Valid @RequestBody ConservationStatus conservationStatus, BindingResult result){
        if (result.hasFieldErrors()){
            return makeValidation.validation(result);
        }
        return ResponseEntity.ok(service.save(conservationStatus));
    }

    @PutMapping(ID_IN_PATH)
    public ResponseEntity<ConservationStatus> updateStatus(@PathVariable Long id, @RequestBody ConservationStatus conservationStatus){
        return ResponseEntity.ok(service.update(id, conservationStatus));
    }

    @DeleteMapping(ID_IN_PATH)
    public ResponseEntity<?> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
