package com.app.app.transactionDetail.controller;

import com.app.app.transactionDetail.domain.service.ITransactionDetail;
import com.app.app.transactionDetail.persistence.DTO.TransactionDetailDTO;
import com.app.app.transactionDetail.persistence.entity.TransactionDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.app.app.consts.GeneralConst.ID_IN_PATH;

@RestController
@RequestMapping("/transactionDetail")
public class TransactionDetailController {
    @Autowired
    private ITransactionDetail service;

    @GetMapping
    public ResponseEntity<List<TransactionDetail>> getAllTransactionDetail(){
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping(ID_IN_PATH)
    public ResponseEntity<TransactionDetail> getTransactionDetailByid(@PathVariable Long id){
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<TransactionDetail> createTransactionDetail(@RequestBody TransactionDetailDTO transactionDetail){
        return ResponseEntity.ok(service.save(transactionDetail));
    }

    @PutMapping(ID_IN_PATH)
    public ResponseEntity<TransactionDetail> updateTransactionDetail(@PathVariable Long id, @RequestBody TransactionDetailDTO transactionDetail){
        return ResponseEntity.ok(service.update(id, transactionDetail));
    }

    @DeleteMapping(ID_IN_PATH)
    public ResponseEntity<?> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
