package com.app.app.branch.controller;

import com.app.app.branch.domain.service.IBranch;
import com.app.app.branch.persistence.Branch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.app.app.consts.GeneralConst.ID_IN_PATH;

@RestController
@RequestMapping("/branch")
public class BranchController {
    @Autowired
    private IBranch service;

    @GetMapping
    public ResponseEntity<List<Branch>> getAllBranch(){
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping(ID_IN_PATH)
    public ResponseEntity<Branch> getBranchByid(@PathVariable Long id){
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<Branch> createBranch(@RequestBody Branch branch){
        return ResponseEntity.ok(service.save(branch));
    }

    @PutMapping(ID_IN_PATH)
    public ResponseEntity<Branch> updateBranch(@PathVariable Long id, @RequestBody Branch branch){
        return ResponseEntity.ok(service.update(id, branch));
    }

    @DeleteMapping(ID_IN_PATH)
    public ResponseEntity<?> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
