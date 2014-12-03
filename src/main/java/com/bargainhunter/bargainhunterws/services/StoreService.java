package com.bargainhunter.bargainhunterws.services;

import com.bargainhunter.bargainhunterws.controllers.IStoreController;
import com.bargainhunter.bargainhunterws.models.DTOs.StoreDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
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
    @RequestMapping(value = "/stores", method = RequestMethod.GET)
    public ResponseEntity<Collection<StoreDTO>> getAllStoresInRadius(
            @RequestParam double latitude,
            @RequestParam double longitude,
            @RequestParam double radius) {
        HttpHeaders headers = new HttpHeaders();

        headers.add("Content-Type", "application/json;charset=UTF-8");

        Collection<StoreDTO> storeDTOs = storeController.getAllStoreDTOsInRadius(latitude, longitude, radius);

        return new ResponseEntity<>(storeDTOs, headers, HttpStatus.OK);
    }

    @Override
    @RequestMapping(value = "/stores/{storeId}", method = RequestMethod.GET)
    public ResponseEntity<StoreDTO> getOneStoreById(@PathVariable long storeId) {
        HttpHeaders headers = new HttpHeaders();
        HttpStatus status = HttpStatus.OK;

        StoreDTO storeDTO = null;

        headers.add("Content-Type", "application/json;charset=UTF-8");

        try {
            storeDTO = storeController.getStoreDTOById(storeId);
        } catch (EntityNotFoundException e) {
            status = HttpStatus.NOT_FOUND;
        }

        return new ResponseEntity<>(storeDTO, headers, status);
    }
}
