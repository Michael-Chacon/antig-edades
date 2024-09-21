package com.app.app.typeContact.controller;

import com.app.app.typeContact.domain.service.ITypeContact;
import com.app.app.typeContact.persistence.TypeContact;
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
@RequestMapping("/typeContact")
public class TypeContactController {
    @Autowired
    private ITypeContact service;

    @Autowired
    private MakeValidation makeValidation;

    @GetMapping
    public ResponseEntity<List<TypeContact>> getAllTContact(){
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping(ID_IN_PATH)
    public ResponseEntity<TypeContact> getTContactByid(@PathVariable Long id){
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<?> createTContact(@Valid @RequestBody TypeContact typeContact, BindingResult result){
        if (result.hasFieldErrors()){
            return makeValidation.validation(result);
        }
        return ResponseEntity.ok(service.save(typeContact));
    }

    @PutMapping(ID_IN_PATH)
    public ResponseEntity<TypeContact> updateTContact(@PathVariable Long id, @RequestBody TypeContact typeContact){
        return ResponseEntity.ok(service.update(id, typeContact));
    }

    @DeleteMapping(ID_IN_PATH)
    public ResponseEntity<?> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
