package com.bargainhunter.bargainhunterws.controllers;

import com.bargainhunter.bargainhunterws.models.dtos.StoreDTO;

import java.util.Collection;

/**
 * Created by Achilleas Naoumidis on 11/14/14.
 */
public interface IStoreController {
    Collection<StoreDTO> getAllStores();

    StoreDTO getOneById(long storeId);
}
