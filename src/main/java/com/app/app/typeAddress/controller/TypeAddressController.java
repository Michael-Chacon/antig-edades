package com.app.app.typeAddress.controller;

import com.app.app.typeAddress.domain.service.ITypeAddress;
import com.app.app.typeAddress.persistence.TypeAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.app.app.consts.GeneralConst.ID_IN_PATH;

@RestController
@RequestMapping("/typeAddress")
public class TypeAddressController {
    @Autowired
    private ITypeAddress service;

    @GetMapping
    public ResponseEntity<List<TypeAddress>> getAllTAddres(){
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping(ID_IN_PATH)
    public ResponseEntity<TypeAddress> getTAddresByid(@PathVariable Long id){
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<TypeAddress> createTAddres(@RequestBody TypeAddress typeAddress){
        return ResponseEntity.ok(service.save(typeAddress));
    }

    @PutMapping(ID_IN_PATH)
    public ResponseEntity<TypeAddress> updateTAddres(@PathVariable Long id, @RequestBody TypeAddress typeAddress){
        return ResponseEntity.ok(service.update(id, typeAddress));
    }

    @DeleteMapping(ID_IN_PATH)
    public ResponseEntity<?> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
