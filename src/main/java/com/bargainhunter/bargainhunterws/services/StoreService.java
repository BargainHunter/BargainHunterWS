package com.bargainhunter.bargainhunterws.services;

import com.bargainhunter.bargainhunterws.controllers.IStoreController;
import com.bargainhunter.bargainhunterws.models.DTOs.entityDTOs.StoreDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.Collection;

@RestController
public class StoreService implements IStoreService {
    @Autowired
    IStoreController storeController;

    @Override
    @RequestMapping(value = "/stores/{storeId}", method = RequestMethod.GET)
    public ResponseEntity<StoreDTO> getOneStoreById(@PathVariable Long storeId) {
        HttpStatus status = HttpStatus.OK;

        StoreDTO storeDTO = null;

        try {
            storeDTO = storeController.getStoreDTOById(storeId);
        } catch (EntityNotFoundException e) {
            status = HttpStatus.NOT_FOUND;
        }

        return new ResponseEntity<>(storeDTO, null, status);
    }

    @Override
    @RequestMapping(value = "/stores", method = RequestMethod.GET)
    public ResponseEntity<Collection<StoreDTO>> getAllStoresInRadius(Double latitude, Double longitude, Double radius) {
        Collection<StoreDTO> storeDTOs = storeController.getAllStoreDTOs();

        return new ResponseEntity<>(storeDTOs, null, HttpStatus.OK);
    }
}
