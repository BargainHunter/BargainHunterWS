package com.bargainhunter.bargainhunterws.services;

import com.bargainhunter.bargainhunterws.models.DTOs.StoreDTO;
import org.springframework.http.ResponseEntity;

import java.util.Collection;

public interface IStoreService {
    ResponseEntity<Collection<StoreDTO>> getAllStoresInRadius(Double latitude, Double longitude, Double radius);

    ResponseEntity<StoreDTO> getOneStoreById(Long storeId);
}
