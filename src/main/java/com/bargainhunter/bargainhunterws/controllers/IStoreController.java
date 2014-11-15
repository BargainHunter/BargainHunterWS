package com.bargainhunter.bargainhunterws.controllers;

import com.bargainhunter.bargainhunterws.models.DTOs.StoreDTO;
import com.bargainhunter.bargainhunterws.models.entities.Store;

import java.util.Collection;

/**
 * Created by Achilleas Naoumidis on 11/14/14.
 */
public interface IStoreController {
    Collection<StoreDTO> getAllStoresDTOs();

    StoreDTO getStoreDTOById(long storeId);

    Collection<StoreDTO> createDTOs(Collection<Store> stores);

    StoreDTO createDTO(Store store);
}
