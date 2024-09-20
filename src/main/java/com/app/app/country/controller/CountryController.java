package com.app.app.country.controller;

import com.app.app.country.domain.service.ICountry;
import com.app.app.country.persistence.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.app.app.consts.GeneralConst.ID_IN_PATH;

@RestController
@RequestMapping("/country")
public class CountryController {
    @Autowired
    private ICountry service;

    @GetMapping
    public ResponseEntity<List<Country>> getAllCountry(){
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping(ID_IN_PATH)
    public ResponseEntity<Country> getCountryByid(@PathVariable Long id){
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<Country> createCountry(@RequestBody Country country){
        return ResponseEntity.ok(service.save(country));
    }

    @PutMapping(ID_IN_PATH)
    public ResponseEntity<Country> updateCountry(@PathVariable Long id, @RequestBody Country country){
        return ResponseEntity.ok(service.update(id, country));
    }

    @DeleteMapping(ID_IN_PATH)
    public ResponseEntity<?> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
