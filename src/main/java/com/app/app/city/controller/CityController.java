package com.app.app.city.controller;

import com.app.app.city.DTO.CityDTO;
import com.app.app.city.domain.service.ICity;
import com.app.app.city.persistence.City;
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
@RequestMapping("/city")
public class CityController {
    @Autowired
    private ICity service;

    @Autowired
    private MakeValidation makeValidation;

    @GetMapping
    public ResponseEntity<List<City>> getAllCity(){
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping(ID_IN_PATH)
    public ResponseEntity<City> getCityByid(@PathVariable Long id){
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<?> createCity(@Valid @RequestBody CityDTO city, BindingResult result){
        if (result.hasFieldErrors()){
            return makeValidation.validation(result);
        }
        return ResponseEntity.ok(service.save(city));
    }

    @PutMapping(ID_IN_PATH)
    public ResponseEntity<City> updateCity(@PathVariable Long id, @RequestBody CityDTO city){
        return ResponseEntity.ok(service.update(id, city));
    }

    @DeleteMapping(ID_IN_PATH)
    public ResponseEntity<?> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
