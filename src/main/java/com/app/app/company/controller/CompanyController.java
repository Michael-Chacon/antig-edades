package com.app.app.company.controller;

import com.app.app.company.domain.service.ICompany;
import com.app.app.company.persistence.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.app.app.consts.GeneralConst.ID_IN_PATH;

@RestController
@RequestMapping("/company")
public class CompanyController {
    @Autowired
    private ICompany service;

    @GetMapping
    public ResponseEntity<List<Company>> getAllCompany(){
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping(ID_IN_PATH)
    public ResponseEntity<Company> getCompanyByid(@PathVariable Long id){
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<Company> createCompany(@RequestBody Company company){
        return ResponseEntity.ok(service.save(company));
    }

    @PutMapping(ID_IN_PATH)
    public ResponseEntity<Company> updateCompany(@PathVariable Long id, @RequestBody Company company){
        return ResponseEntity.ok(service.update(id, company));
    }

    @DeleteMapping(ID_IN_PATH)
    public ResponseEntity<?> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
