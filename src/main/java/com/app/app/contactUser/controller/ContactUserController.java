package com.app.app.contactUser.controller;

import com.app.app.contactUser.domain.service.IContactUser;
import com.app.app.contactUser.persistence.DTO.ContactUserDTO;
import com.app.app.contactUser.persistence.entity.ContactUser;
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
@RequestMapping("/contactUser")
public class ContactUserController {
    @Autowired
    private IContactUser service;

    @Autowired
    private MakeValidation makeValidation;

    @GetMapping
    public ResponseEntity<List<ContactUser>> getAllContactUser(){
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping(ID_IN_PATH)
    public ResponseEntity<ContactUser> getContactUserByid(@PathVariable Long id){
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<?> createContactUser(@Valid @RequestBody ContactUserDTO contactUser, BindingResult result){
        if (result.hasFieldErrors()){
            return makeValidation.validation(result);
        }
        return ResponseEntity.ok(service.save(contactUser));
    }

    @PutMapping(ID_IN_PATH)
    public ResponseEntity<ContactUser> updateContactUser(@PathVariable Long id, @RequestBody ContactUserDTO contactUser){
        return ResponseEntity.ok(service.update(id, contactUser));
    }

    @DeleteMapping(ID_IN_PATH)
    public ResponseEntity<?> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
