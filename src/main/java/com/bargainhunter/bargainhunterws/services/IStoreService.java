package com.bargainhunter.bargainhunterws.services;

import com.bargainhunter.bargainhunterws.models.DTOs.StoreDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collection;

public interface IStoreService {
    public ResponseEntity<Collection<StoreDTO>> getAllStoresInRadius(
            @RequestParam double latitude,
            @RequestParam double longitude,
            @RequestParam double radius);

    @RequestMapping(value = "/stores/{storeId}", method = RequestMethod.GET)
    ResponseEntity<StoreDTO> getOneStoreById(@PathVariable long storeId);
}
