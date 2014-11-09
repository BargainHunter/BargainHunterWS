package com.bargainhunter.bargainhunterws.services;

import com.bargainhunter.bargainhunterws.models.Store;
import com.bargainhunter.bargainhunterws.repository.IStoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Achilleas Naoumidis on 11/9/14.
 */
@RestController
public class StoreService {
    @Autowired
    IStoreRepository storeRepository;

    @RequestMapping(value = "/stores", method = RequestMethod.GET)
    public List<Store> getAllStores() {
        return storeRepository.findAll();
    }
}
