package com.app.app.gender.controller;

import com.app.app.gender.domain.service.IGender;
import com.app.app.gender.persistence.Gender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.app.app.consts.GeneralConst.ID_IN_PATH;

@RestController
@RequestMapping("/gender")
public class GenderController {
    @Autowired
    private IGender service;

    @GetMapping
    public ResponseEntity<List<Gender>> getAllGender(){
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping(ID_IN_PATH)
    public ResponseEntity<Gender> getGenderByid(@PathVariable Long id){
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<Gender> createGender(@RequestBody Gender gender){
        return ResponseEntity.ok(service.save(gender));
    }

    @PutMapping(ID_IN_PATH)
    public ResponseEntity<Gender> updateGender(@PathVariable Long id, @RequestBody Gender gender){
        return ResponseEntity.ok(service.update(id, gender));
    }

    @DeleteMapping(ID_IN_PATH)
    public ResponseEntity<?> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
