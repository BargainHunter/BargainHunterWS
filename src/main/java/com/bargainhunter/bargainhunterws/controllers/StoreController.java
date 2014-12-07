package com.bargainhunter.bargainhunterws.controllers;

import com.bargainhunter.bargainhunterws.models.DTOs.StoreDTO;
import com.bargainhunter.bargainhunterws.models.entities.Store;
import com.bargainhunter.bargainhunterws.repositories.IStoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

@Controller
public class StoreController implements IStoreController {
    @Autowired
    IStoreRepository storeRepository;

    @Override
    public StoreDTO getStoreDTOById(Long storeId) throws EntityNotFoundException {
        Store store = storeRepository.getOne(storeId);

        return createDTO(store);
    }

    @Override
    public Collection<StoreDTO> getAllStoreDTOsInRadius(Double latitude, Double longitude, Double radius) {
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
                store.getBranch().getBranchName(),
                store.getCity(),
                store.getAddress(),
                store.getAddressNo(),
                store.getLatitude(),
                store.getLongitude(),
                store.getBranch().getBranchId()
        );

        return storeDTO;
    }
}
