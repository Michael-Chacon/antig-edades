package com.app.app.period.web.controller;

import com.app.app.period.domain.service.IPeriod;
import com.app.app.period.persistence.Period;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.app.app.consts.GeneralConst.ID_IN_PATH;

@RestController
@RequestMapping("/period")
public class PeriodController {
    @Autowired
    private IPeriod service;

    @GetMapping
    public ResponseEntity<List<Period>> getAllCategories(){
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping(ID_IN_PATH)
    public ResponseEntity<Period> getPeriodByid(@PathVariable Long id){
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<Period> createPeriod(@RequestBody Period period){
        return ResponseEntity.ok(service.save(period));
    }

    @PutMapping(ID_IN_PATH)
    public ResponseEntity<Period> updatePeriod(@PathVariable Long id, @RequestBody Period period){
        return ResponseEntity.ok(service.update(id, period));
    }

    @DeleteMapping(ID_IN_PATH)
    public ResponseEntity<?> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
