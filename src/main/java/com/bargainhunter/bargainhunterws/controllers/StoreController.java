package com.bargainhunter.bargainhunterws.controllers;

import com.bargainhunter.bargainhunterws.models.DTOs.StoreDTO;
import com.bargainhunter.bargainhunterws.models.entities.Store;
import com.bargainhunter.bargainhunterws.repositories.IStoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.Collection;
import java.util.HashSet;

/**
 * Created by Achilleas Naoumidis on 11/15/14.
 */
@Controller
public class StoreController implements IStoreController {
    @Autowired
    IStoreRepository storeRepository;

    @Override
    public Collection<StoreDTO> getAllStoresDTOs() {
        Collection<Store> stores = storeRepository.findAll();
        return createDTOs(stores);
    }

    @Override
    public StoreDTO getStoreDTOById(long storeId) {
        Store store = storeRepository.findOne(storeId);
        return createDTO(store);
    }

    @Override
    public Collection<StoreDTO> createDTOs(Collection<Store> stores) {
        Collection<StoreDTO> storeDTOs = new HashSet<>();

        for (Store store : stores) {
            storeDTOs.add(createDTO(store));
        }

        return storeDTOs;
    }

    @Override
    public StoreDTO createDTO(Store store) {
        StoreDTO storeDTO = new StoreDTO(
                store.getStoreId(),
                store.getCompany().getCompanyName(),
                store.getCity(),
                store.getAddress(),
                store.getAddressNo(),
                store.getLatitude(),
                store.getLongitude());
        return storeDTO;
    }
}
