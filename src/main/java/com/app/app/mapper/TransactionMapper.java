package com.app.app.mapper;

import com.app.app.transaction.persistence.DTO.TransactionDTO;
import com.app.app.transactionType.persistence.TransactionType;
import com.app.app.user.persistence.Users;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TransactionMapper {
    TransactionMapper INSTACE = Mappers.getMapper(TransactionMapper.class);
    Users toUsers(TransactionDTO dto);
    TransactionType toTransationType(TransactionDTO dto);
}
