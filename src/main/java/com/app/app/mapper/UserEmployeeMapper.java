package com.app.app.mapper;

import com.app.app.employee.persistence.DTO.UserEmployeeDTO;
import com.app.app.employee.persistence.entity.Employee;
import com.app.app.user.persistence.Users;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserEmployeeMapper {
    UserEmployeeMapper INSTANCE = Mappers.getMapper(UserEmployeeMapper.class);

    Users toUsers(UserEmployeeDTO dto);

    // Mapear UserCollectionistMapper a Collectionist automáticamente
    Employee toEmployee(UserEmployeeDTO dto);
}
