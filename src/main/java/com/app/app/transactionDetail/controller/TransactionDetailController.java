package com.app.app.transactionDetail.controller;

import com.app.app.transactionDetail.DTO.SalesHistoryDTO;
import com.app.app.transactionDetail.domain.service.ITransactionDetail;
import com.app.app.transactionDetail.DTO.TransactionDetailDTO;
import com.app.app.transactionDetail.persistence.entity.TransactionDetail;
import com.app.app.utils.MakeValidation;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

import static com.app.app.consts.GeneralConst.ID_IN_PATH;

@RestController
@RequestMapping("/transactionDetail")
public class TransactionDetailController {
    @Autowired
    private ITransactionDetail service;

    @Autowired
    private MakeValidation makeValidation;

    @GetMapping
    public ResponseEntity<List<TransactionDetail>> getAllTransactionDetail(){
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping(ID_IN_PATH)
    public ResponseEntity<TransactionDetail> getTransactionDetailByid(@PathVariable Long id){
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<?> createTransactionDetail(@Valid @RequestBody TransactionDetailDTO transactionDetail, BindingResult result){
        if (result.hasFieldErrors()){
            return makeValidation.validation(result);
        }
        return ResponseEntity.ok(service.savaOrUpdate(null, transactionDetail));
    }

    @PutMapping(ID_IN_PATH)
    public ResponseEntity<TransactionDetail> updateTransactionDetail(@PathVariable Long id, @RequestBody TransactionDetailDTO transactionDetail){
        return ResponseEntity.ok(service.savaOrUpdate(id, transactionDetail));
    }

    @DeleteMapping(ID_IN_PATH)
    public ResponseEntity<?> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping("/salesHistory")
    public ResponseEntity<List<SalesHistoryDTO>> SalesHistory(){
        return ResponseEntity.ok(service.getHistoryToSales());
    }

    @GetMapping("/total")
    public ResponseEntity<BigDecimal> total(){
        return ResponseEntity.ok(service.getTotal());
    }

}
