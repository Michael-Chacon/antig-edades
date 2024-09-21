package com.app.app.collectionist.controller;

import com.app.app.collectionist.domain.service.ICollectionist;
import com.app.app.collectionist.persistence.DTO.UserCollectionistDTO;
import com.app.app.collectionist.persistence.entity.Collectionist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.app.app.consts.GeneralConst.ID_IN_PATH;

@RestController
@RequestMapping("/collectionist")
public class CollectionistController {
    @Autowired
    private ICollectionist service;

    @GetMapping
    public ResponseEntity<List<Collectionist>> getAllCollectionist(){
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping(ID_IN_PATH)
    public ResponseEntity<Collectionist> getCollectionistByid(@PathVariable Long id){
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<UserCollectionistDTO> createCollectionist(@RequestBody UserCollectionistDTO employee){
        return ResponseEntity.ok(service.save(employee));
    }

    @PutMapping(ID_IN_PATH)
    public ResponseEntity<UserCollectionistDTO> updateCollectionist(@PathVariable Long id, @RequestBody UserCollectionistDTO employee){
        return ResponseEntity.ok(service.update(id, employee));
    }

    @DeleteMapping(ID_IN_PATH)
    public ResponseEntity<?> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
