package com.app.app.city.controller;

import com.app.app.city.domain.service.ICity;
import com.app.app.city.persistence.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.app.app.consts.GeneralConst.ID_IN_PATH;

@RestController
@RequestMapping("/city")
public class CityController {
    @Autowired
    private ICity service;

    @GetMapping
    public ResponseEntity<List<City>> getAllCity(){
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping(ID_IN_PATH)
    public ResponseEntity<City> getCityByid(@PathVariable Long id){
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<City> createCity(@RequestBody City city){
        return ResponseEntity.ok(service.save(city));
    }

    @PutMapping(ID_IN_PATH)
    public ResponseEntity<City> updateCity(@PathVariable Long id, @RequestBody City city){
        return ResponseEntity.ok(service.update(id, city));
    }

    @DeleteMapping(ID_IN_PATH)
    public ResponseEntity<?> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
