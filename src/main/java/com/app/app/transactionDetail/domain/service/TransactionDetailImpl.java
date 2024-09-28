package com.app.app.transactionDetail.domain.service;

import com.app.app.antiquity.domain.service.IAntiquity;
import com.app.app.antiquity.persistence.Antiquity;
import com.app.app.exceptions.ResourceNotFoundException;
import com.app.app.paymentMethod.domain.service.IPaymentMethod;
import com.app.app.paymentMethod.persistence.PaymentMethod;
import com.app.app.transaction.domain.service.ITransaction;
import com.app.app.transaction.persistence.entity.Transaction;
import com.app.app.transactionDetail.DTO.SalesHistoryDTO;
import com.app.app.transactionDetail.domain.repository.TransactionDetailRepository;
import com.app.app.transactionDetail.DTO.TransactionDetailDTO;
import com.app.app.transactionDetail.persistence.entity.TransactionDetail;
import com.app.app.user.domain.service.IUsers;
import com.app.app.user.persistence.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Service
@Transactional
public class TransactionDetailImpl implements ITransactionDetail {
    @Autowired
    private TransactionDetailRepository repository;

    @Autowired
    private IUsers userService;

    @Autowired
    private IAntiquity antiquityService;

    @Autowired
    private IPaymentMethod paymentMethodService;

    @Autowired
    private ITransaction transactionService;


    @Transactional(readOnly = true)
    @Override
    public List<TransactionDetail> findAll() {
        return repository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public TransactionDetail findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(TransactionDetail.class.getName(), id));
    }

    @Override
    public TransactionDetail savaOrUpdate(Long id, TransactionDetailDTO dto) {
        TransactionDetail transactionDetail;

        if (id != null) {
            transactionDetail = findById(id);
        } else {
            transactionDetail = new TransactionDetail();
        }

        PaymentMethod paymentMethod = paymentMethodService.findById(dto.getPaymentMethod());
        Antiquity antiquity = antiquityService.findById(dto.getAntiquity());
//      El propietario de la aniguedad debe ser el vendedor
        Users user = userService.findById(dto.getSalesman());
        Transaction transaction = transactionService.findById(dto.getTransaction());

        transactionDetail.setTransactionPrice(dto.getTransactionPrice());
        transactionDetail.setTransaction(transaction);
        transactionDetail.setSalesman(user);
        transactionDetail.setAntiquity(antiquity);
        transactionDetail.setPaymentMethod(paymentMethod);
        return repository.save(transactionDetail);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Transactional(readOnly = true)
    @Override
    public List<SalesHistoryDTO> getHistoryToSales() {
        return repository.findSalesHistory();
    }

    @Transactional(readOnly = true)
    @Override
    public BigDecimal getTotal() {
        return repository.calculateTotal(LocalDate.parse("2024-09-02"), LocalDate.of(2024, 9, 20));
    }
}
