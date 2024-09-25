package com.app.app.antiquityValuation.controller;

import com.app.app.antiquityValuation.DTO.AntiquityMoreViewDTO;
import com.app.app.antiquityValuation.DTO.SaveValuationDTO;
import com.app.app.antiquityValuation.domain.service.IValuation;
import com.app.app.antiquityValuation.persistence.Valuation;
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
@RequestMapping("/valuation")
public class ValuationController {
    @Autowired
    private IValuation service;

    @Autowired
    private MakeValidation makeValidation;

    @GetMapping
    public ResponseEntity<List<Valuation>> getAllValuation(){
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping(ID_IN_PATH)
    public ResponseEntity<Valuation> getValuationByid(@PathVariable Long id){
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<?> createValuation(@Valid @RequestBody SaveValuationDTO valuation, BindingResult result){
        if (result.hasFieldErrors()){
            return makeValidation.validation(result);
        }
        return ResponseEntity.ok(service.save(valuation));
    }

    @PutMapping(ID_IN_PATH)
    public ResponseEntity<Valuation> updateValuation(@PathVariable Long id, @RequestBody SaveValuationDTO valuation){
        return ResponseEntity.ok(service.update(id, valuation));
    }

    @DeleteMapping(ID_IN_PATH)
    public ResponseEntity<?> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping("/moreViews")
    public ResponseEntity<List<AntiquityMoreViewDTO>> moreViews(){
        return ResponseEntity.ok(service.moreViews());
    }

}
