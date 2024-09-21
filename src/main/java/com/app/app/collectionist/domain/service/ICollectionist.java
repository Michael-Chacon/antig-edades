package com.app.app.collectionist.domain.service;

import com.app.app.collectionist.persistence.DTO.UserCollectionistDTO;
import com.app.app.collectionist.persistence.entity.Collectionist;

import java.util.List;

public interface ICollectionist {
    List<Collectionist> findAll();
    Collectionist findById(Long id);
    UserCollectionistDTO save(UserCollectionistDTO collectionistDTO);
    UserCollectionistDTO update(Long id, UserCollectionistDTO collectionistDTO);
    void delete(Long id);
}
