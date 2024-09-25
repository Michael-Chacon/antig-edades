package com.app.app.transaction.controller;

import com.app.app.transaction.DTO.BiggestBuyersDTO;
import com.app.app.transaction.domain.service.ITransaction;
import com.app.app.transaction.persistence.DTO.TransactionDTO;
import com.app.app.transaction.persistence.entity.Transaction;
import com.app.app.utils.MakeValidation;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

import static com.app.app.consts.GeneralConst.ID_IN_PATH;

@RestController
@RequestMapping("/transaction")
public class TransactionController {
    @Autowired
    private ITransaction service;

    @Autowired
    private MakeValidation makeValidation;

    @GetMapping
    public ResponseEntity<List<Transaction>> getAllTransaction(){
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping(ID_IN_PATH)
    public ResponseEntity<Transaction> getTransactionByid(@PathVariable Long id){
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<?> createTransaction(@Valid @RequestBody TransactionDTO contactUser, BindingResult result){
        if (result.hasFieldErrors()){
            return makeValidation.validation(result);
        }
        return ResponseEntity.ok(service.save(contactUser));
    }

    @PutMapping(ID_IN_PATH)
    public ResponseEntity<Transaction> updateTransaction(@PathVariable Long id, @RequestBody TransactionDTO contactUser){
        return ResponseEntity.ok(service.update(id, contactUser));
    }

    @DeleteMapping(ID_IN_PATH)
    public ResponseEntity<?> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping("/biggestBuyers")
    public ResponseEntity<List<BiggestBuyersDTO>> getBiggestBuyers(){
        return ResponseEntity.ok(service.biggestBuyers());
    }

}
