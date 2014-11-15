package com.bargainhunter.bargainhunterws.services;

import com.bargainhunter.bargainhunterws.models.DTOs.StoreDTO;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Collection;

/**
 * Created by Achilleas Naoumidis on 11/14/14.
 */
public interface IStoreService {
    @RequestMapping(value = "/stores", method = RequestMethod.GET)
    Collection<StoreDTO> getAllStores();

    @RequestMapping(value = "/stores/{storeId}", method = RequestMethod.GET)
    StoreDTO getOneById(@PathVariable long storeId);
}
