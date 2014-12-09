package com.bargainhunter.bargainhunterws.services;

import com.bargainhunter.bargainhunterws.models.DTOs.entityDTOs.StoreDTO;
import org.springframework.http.ResponseEntity;

import java.util.Collection;

public interface IStoreService {
    ResponseEntity<StoreDTO> getOneStoreById(Long storeId);

    ResponseEntity<Collection<StoreDTO>> getAllStoresInRadius(Double latitude, Double longitude, Double radius);
}
