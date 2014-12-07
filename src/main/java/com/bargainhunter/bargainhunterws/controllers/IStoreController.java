package com.bargainhunter.bargainhunterws.controllers;

import com.bargainhunter.bargainhunterws.models.DTOs.StoreDTO;
import com.bargainhunter.bargainhunterws.models.entities.Store;

import javax.persistence.EntityNotFoundException;
import java.util.Collection;

public interface IStoreController {
    StoreDTO getStoreDTOById(Long storeId) throws EntityNotFoundException;

    Collection<StoreDTO> getAllStoreDTOsInRadius(Double latitude, Double longitude, Double radius);

    Collection<StoreDTO> createDTOs(Collection<Store> stores);

    StoreDTO createDTO(Store store);
}
