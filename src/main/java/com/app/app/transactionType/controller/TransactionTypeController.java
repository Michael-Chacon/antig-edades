package com.app.app.transactionType.controller;

import com.app.app.transactionType.domain.service.ITransactionType;
import com.app.app.transactionType.persistence.TransactionType;
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
@RequestMapping("/transactionType")
public class TransactionTypeController {
    @Autowired
    private ITransactionType service;

    @Autowired
    private MakeValidation makeValidation;

    @GetMapping
    public ResponseEntity<List<TransactionType>> getAllTTransaction(){
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping(ID_IN_PATH)
    public ResponseEntity<TransactionType> getTTransactionByid(@PathVariable Long id){
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<?> createTTransaction(@Valid @RequestBody TransactionType transactionType, BindingResult result){
        if (result.hasFieldErrors()){
            return makeValidation.validation(result);
        }
        return ResponseEntity.ok(service.save(transactionType));
    }

    @PutMapping(ID_IN_PATH)
    public ResponseEntity<TransactionType> updateTTransaction(@PathVariable Long id, @RequestBody TransactionType transactionType){
        return ResponseEntity.ok(service.update(id, transactionType));
    }

    @DeleteMapping(ID_IN_PATH)
    public ResponseEntity<?> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
