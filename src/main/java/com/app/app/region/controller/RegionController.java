package com.app.app.region.controller;

import com.app.app.region.domain.service.IRegion;
import com.app.app.region.persistence.Region;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.app.app.consts.GeneralConst.ID_IN_PATH;

@RestController
@RequestMapping("/region")
public class RegionController {
    @Autowired
    private IRegion service;

    @GetMapping
    public ResponseEntity<List<Region>> getAllRegion(){
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping(ID_IN_PATH)
    public ResponseEntity<Region> getRegionByid(@PathVariable Long id){
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<Region> createRegion(@RequestBody Region region){
        return ResponseEntity.ok(service.save(region));
    }

    @PutMapping(ID_IN_PATH)
    public ResponseEntity<Region> updateRegion(@PathVariable Long id, @RequestBody Region region){
        return ResponseEntity.ok(service.update(id, region));
    }

    @DeleteMapping(ID_IN_PATH)
    public ResponseEntity<?> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
