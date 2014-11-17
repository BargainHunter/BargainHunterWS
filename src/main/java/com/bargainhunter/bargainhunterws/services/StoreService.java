package com.bargainhunter.bargainhunterws.services;

import com.bargainhunter.bargainhunterws.controllers.IStoreController;
import com.bargainhunter.bargainhunterws.models.DTOs.StoreDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Collection;

/**
 * Created by Achilleas Naoumidis on 11/9/14.
 */
@RestController
public class StoreService implements IStoreService {
    @Autowired
    IStoreController storeController;

    @Override
    @RequestMapping(value = "/stores", method = RequestMethod.GET)
    public ResponseEntity<Collection<StoreDTO>> getAllStores() {
        HttpHeaders headers = new HttpHeaders();
        HttpStatus status = HttpStatus.OK;

        Collection<StoreDTO> storeDTOs = null;

        headers.add("Content-Type", "application/json;charset=UTF-8");

        try {
            storeDTOs = storeController.getAllStoresDTOs();
        } catch (Exception e) {
            System.out.println(Arrays.toString(e.getStackTrace()));
            status = HttpStatus.INTERNAL_SERVER_ERROR;
        }

        return new ResponseEntity<>(storeDTOs, headers, status);
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
        } catch (NullPointerException e) {
            status = HttpStatus.NOT_FOUND;
        } catch (Exception e) {
            System.out.println(Arrays.toString(e.getStackTrace()));
            status = HttpStatus.INTERNAL_SERVER_ERROR;
        }

        return new ResponseEntity<>(storeDTO, headers, status);
    }
}
