package com.app.app.antiquity.controller;

import com.app.app.antiquity.domain.service.IAntiquity;
import com.app.app.antiquity.persistence.Antiquity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.app.app.consts.GeneralConst.ID_IN_PATH;

@RestController
@RequestMapping("/antiquity")
public class AntiquityController {
    @Autowired
    private IAntiquity service;

    @GetMapping
    public ResponseEntity<List<Antiquity>> getAllAntiquity(){
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping(ID_IN_PATH)
    public ResponseEntity<Antiquity> getAntiquityByid(@PathVariable Long id){
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<Antiquity> createAntiquity(@RequestBody Antiquity antiquity){
        return ResponseEntity.ok(service.save(antiquity));
    }

    @PutMapping(ID_IN_PATH)
    public ResponseEntity<Antiquity> updateAntiquity(@PathVariable Long id, @RequestBody Antiquity antiquity){
        return ResponseEntity.ok(service.update(id, antiquity));
    }

    @DeleteMapping(ID_IN_PATH)
    public ResponseEntity<?> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
