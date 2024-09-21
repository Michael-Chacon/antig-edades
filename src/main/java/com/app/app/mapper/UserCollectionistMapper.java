package com.app.app.mapper;

import com.app.app.collectionist.persistence.DTO.UserCollectionistDTO;
import com.app.app.collectionist.persistence.entity.Collectionist;
import com.app.app.user.persistence.Users;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserCollectionistMapper {
    UserCollectionistMapper INSTANCE = Mappers.getMapper(UserCollectionistMapper.class);
    Users toUsers(UserCollectionistDTO dto);
    Collectionist toCollectionist(UserCollectionistDTO dto);

}
