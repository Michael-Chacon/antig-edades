package com.app.app.paymentMethod.controller;

import com.app.app.paymentMethod.domain.service.IPaymentMethod;
import com.app.app.paymentMethod.persistence.PaymentMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.app.app.consts.GeneralConst.ID_IN_PATH;

@RestController
@RequestMapping("/paymentMethod")
public class PaymentMethodController {
    @Autowired
    private IPaymentMethod service;

    @GetMapping
    public ResponseEntity<List<PaymentMethod>> getAllPaymentMethod(){
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping(ID_IN_PATH)
    public ResponseEntity<PaymentMethod> getCountryByid(@PathVariable Long id){
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<PaymentMethod> createCountry(@RequestBody PaymentMethod paymentMethod){
        return ResponseEntity.ok(service.save(paymentMethod));
    }

    @PutMapping(ID_IN_PATH)
    public ResponseEntity<PaymentMethod> updateCountry(@PathVariable Long id, @RequestBody PaymentMethod paymentMethod){
        return ResponseEntity.ok(service.update(id, paymentMethod));
    }

    @DeleteMapping(ID_IN_PATH)
    public ResponseEntity<?> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
