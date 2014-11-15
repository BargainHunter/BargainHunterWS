package com.bargainhunter.bargainhunterws.services;

import com.bargainhunter.bargainhunterws.models.entities.Store;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Collection;

/**
 * Created by Achilleas Naoumidis on 11/14/14.
 */
public interface IStoreService {
    @RequestMapping(value = "/stores", method = RequestMethod.GET)
    Collection<Store> getAllStores();

    @RequestMapping(value = "/stores/{storeId}", method = RequestMethod.GET)
    Store getOneById(@PathVariable long storeId);
}
