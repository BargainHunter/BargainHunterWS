package com.bargainhunter.bargainhunterws.controllers;

import com.bargainhunter.bargainhunterws.models.DTOs.StoreDTO;
import com.bargainhunter.bargainhunterws.models.entities.Store;
import com.bargainhunter.bargainhunterws.repositories.IStoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
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
    public Collection<StoreDTO> getAllStoresDTOsInRadius(double latitude, double longitude, double radius) {
        Collection<Store> stores = storeRepository.findAll();
        Collection<Store> storesInRadius = new HashSet<>();

        DistanceController distanceController = new DistanceController();

        for (Store store : stores) {
            if (distanceController.calcDistance(
                    store.getLatitude(),
                    store.getLongitude(),
                    latitude,
                    longitude) < radius) {
                storesInRadius.add(store);
            }
        }

        return createDTOs(storesInRadius);
    }

    @Override
    public StoreDTO getStoreDTOById(long storeId) {
        Store store = storeRepository.getOne(storeId);
        return createDTO(store);
    }

    @Override
    public Collection<StoreDTO> createDTOs(Collection<Store> stores) {
        Collection<StoreDTO> storeDTOs = new ArrayList<>();

        for (Store store : stores) {
            storeDTOs.add(createDTO(store));
        }

        return storeDTOs;
    }

    @Override
    public StoreDTO createDTO(Store store) {
        StoreDTO storeDTO = new StoreDTO(
                store.getStoreId(),
                store.getStoreName(),
                store.getCity(),
                store.getAddress(),
                store.getAddressNo(),
                store.getLatitude(),
                store.getLongitude(),
                store.getCompany().getCompanyId());

        return storeDTO;
    }
}
