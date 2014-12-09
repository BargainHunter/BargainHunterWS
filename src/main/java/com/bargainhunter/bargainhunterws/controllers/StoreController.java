package com.bargainhunter.bargainhunterws.controllers;

import com.bargainhunter.bargainhunterws.models.DTOs.entityDTOs.StoreDTO;
import com.bargainhunter.bargainhunterws.models.entities.Store;
import com.bargainhunter.bargainhunterws.repositories.IStoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.persistence.EntityNotFoundException;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Controller
public class StoreController implements IStoreController {
    @Autowired
    IStoreRepository storeRepository;

    @Override
    public StoreDTO getStoreDTOById(Long storeId) throws EntityNotFoundException {
        Store store = storeRepository.getOne(storeId);

        return createStoreDTO(store);
    }

    @Override
    public Collection<StoreDTO> getAllStoreDTOs() {
        Collection<Store> stores = storeRepository.findAll();

        return createStoreDTOs(stores);
    }

    public Collection<StoreDTO> createStoreDTOs(Collection<Store> stores) {
        Set<StoreDTO> storeDTOs = new HashSet<>();

        for (Store store : stores) {
            storeDTOs.add(createStoreDTO(store));
        }

        return storeDTOs;
    }

    public StoreDTO createStoreDTO(Store store) {
        return new StoreDTO(
                store.getStoreId(),
                store.getBranch().getBranchName(),
                store.getCity(),
                store.getAddress(),
                store.getAddressNo(),
                store.getLatitude(),
                store.getLongitude(),
                store.getBranch().getBranchId()
        );
    }
}
