package com.bargainhunter.bargainhunterws.controllers;

import com.bargainhunter.bargainhunterws.models.DTOs.StoreDTO;
import com.bargainhunter.bargainhunterws.models.entities.Store;

import java.util.Collection;

public interface IStoreController {
    Collection<StoreDTO> getAllStoresDTOs();

    Collection<StoreDTO> getAllStoreDTOsInRadius(Double latitude, Double longitude, Double radius);

    StoreDTO getStoreDTOById(Long storeId);

    Collection<StoreDTO> createDTOs(Collection<Store> stores);

    StoreDTO createDTO(Store store);
}
