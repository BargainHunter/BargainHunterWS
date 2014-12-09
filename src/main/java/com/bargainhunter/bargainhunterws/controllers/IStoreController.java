package com.bargainhunter.bargainhunterws.controllers;

import com.bargainhunter.bargainhunterws.models.DTOs.entityDTOs.StoreDTO;

import javax.persistence.EntityNotFoundException;
import java.util.Collection;

public interface IStoreController {
    StoreDTO getStoreDTOById(Long storeId) throws EntityNotFoundException;

    Collection<StoreDTO> getAllStoreDTOs();
}
