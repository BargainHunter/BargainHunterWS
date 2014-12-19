package com.bargainhunter.bargainhunterws.controllers;

import com.bargainhunter.bargainhunterws.mappers.IMapper;
import com.bargainhunter.bargainhunterws.models.DTOs.searchService.BranchDTO;
import com.bargainhunter.bargainhunterws.models.DTOs.searchService.SearchInRadiusDTO;
import com.bargainhunter.bargainhunterws.models.entities.Branch;
import com.bargainhunter.bargainhunterws.models.entities.Offer;
import com.bargainhunter.bargainhunterws.models.entities.Store;
import com.bargainhunter.bargainhunterws.repositories.IStoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Component
public class SearchController implements ISearchController {
    @Autowired
    private IStoreRepository storeRepository;

    @Autowired
    private IMapper<Branch, BranchDTO> branchDTOMapper;

    @Override
    public SearchInRadiusDTO getAllBranchesWithStoresAndOffersInRadiusDTO(Double latitude, Double longitude, Double radius) {
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

        return createSearchInRadiusDTO(latitude, longitude, radius, storesInRadius);
    }

    private SearchInRadiusDTO createSearchInRadiusDTO(Double latitude, Double longitude, Double radius, Collection<Store> stores) {
        SearchInRadiusDTO searchInRadiusDTO = new SearchInRadiusDTO();

        Set<Branch> branches = new HashSet<>();

        searchInRadiusDTO.setLatitude(latitude);
        searchInRadiusDTO.setLongitude(longitude);
        searchInRadiusDTO.setRadius(radius);

        for (Store store : stores) {
            branches.add(store.getBranch());
        }

        for (Branch branch : branches) {
            for (Store store : stores) {
                if (branch.equals(store.getBranch())) {
                    branch.getStores().add(store);
                }
            }

            for (Offer offer : branch.getOffers()) {
                branch.getOffers().add(offer);
            }

            searchInRadiusDTO.getBranches().add(branchDTOMapper.map(branch, new BranchDTO()));
        }

        return searchInRadiusDTO;
    }
}
