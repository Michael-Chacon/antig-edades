package com.app.app.address.controller;

import com.app.app.address.DTO.AddressDTO;
import com.app.app.address.domain.service.IAddress;
import com.app.app.address.persistence.Address;
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
@RequestMapping("/address")
public class AddressController {
    @Autowired
    private IAddress service;

    @Autowired
    private MakeValidation makeValidation;

    @GetMapping
    public ResponseEntity<List<Address>> getAllAddress(){
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping(ID_IN_PATH)
    public ResponseEntity<Address> getAddressByid(@PathVariable Long id){
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<?> createAddress(@Valid @RequestBody AddressDTO addressDTO, BindingResult result){
        if (result.hasFieldErrors()){
            return makeValidation.validation(result);
        }
        return ResponseEntity.ok(service.saveOrUpdate(null, addressDTO));
    }

    @PutMapping(ID_IN_PATH)
    public ResponseEntity<Address> updateAddress(@PathVariable Long id, @RequestBody AddressDTO addressDTO){
        return ResponseEntity.ok(service.saveOrUpdate(id, addressDTO));
    }

    @DeleteMapping(ID_IN_PATH)
    public ResponseEntity<?> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
