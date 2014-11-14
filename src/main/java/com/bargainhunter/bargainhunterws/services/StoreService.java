package com.bargainhunter.bargainhunterws.services;

import com.bargainhunter.bargainhunterws.models.Store;
import com.bargainhunter.bargainhunterws.repository.IStoreRepository;
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
    IStoreRepository storeRepository;

    @Override
    @RequestMapping(value = "/stores", method = RequestMethod.GET)
    public Collection<Store> getAllStores() {
        return storeRepository.findAll();
    }

    @Override
    @RequestMapping(value = "/stores/{storeId}", method = RequestMethod.GET)
    public Store getOneById(@PathVariable long storeId) {
        return storeRepository.findOne(storeId);
    }
}
