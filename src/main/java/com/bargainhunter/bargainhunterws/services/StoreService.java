package com.bargainhunter.bargainhunterws.services;

import com.bargainhunter.bargainhunterws.controllers.IStoreController;
import com.bargainhunter.bargainhunterws.models.DTOs.StoreDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
    public Collection<StoreDTO> getAllStores() {
        return storeController.getAllStoresDTOs();
    }

    @Override
    @RequestMapping(value = "/stores/{storeId}", method = RequestMethod.GET)
    public StoreDTO getOneById(@PathVariable long storeId) {
        return storeController.getStoreDTOById(storeId);
    }
}
