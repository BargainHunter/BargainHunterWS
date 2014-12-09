package com.bargainhunter.bargainhunterws.controllers;

import com.bargainhunter.bargainhunterws.models.DTOs.searchService.SearchInRadiusDTO;
import com.bargainhunter.bargainhunterws.models.DTOs.searchService.BranchDTO;
import com.bargainhunter.bargainhunterws.models.DTOs.searchService.OfferDTO;
import com.bargainhunter.bargainhunterws.models.DTOs.searchService.StoreDTO;
import com.bargainhunter.bargainhunterws.models.entities.Branch;
import com.bargainhunter.bargainhunterws.models.entities.Offer;
import com.bargainhunter.bargainhunterws.models.entities.Store;
import com.bargainhunter.bargainhunterws.models.entities.Subcategory;
import com.bargainhunter.bargainhunterws.repositories.IStoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Controller
public class SearchController implements ISearchController {
    @Autowired
    IStoreRepository storeRepository;

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
        Set<BranchDTO> branchDTOs = new HashSet<>();

        searchInRadiusDTO.setLatitude(latitude);
        searchInRadiusDTO.setLongitude(longitude);
        searchInRadiusDTO.setRadius(radius);

        for (Store store : stores) {
            branches.add(store.getBranch());
        }

        for (Branch branch : branches) {
            BranchDTO branchDTO = new BranchDTO();

            branchDTO.setBranchId(branch.getBranchId());

            for (Store store : branch.getStores()) {
                if (stores.contains(store)) {
                    branchDTO.getStores().add(createStoreDTO(store));
                }
            }

            for (Offer offer : branch.getOffers()) {
                branchDTO.getOffers().add(createOfferDTO(offer));
            }

            branchDTOs.add(branchDTO);
        }

        searchInRadiusDTO.setBranches(branchDTOs);

        return searchInRadiusDTO;
    }

    private StoreDTO createStoreDTO(Store store) {
        return new StoreDTO(
                store.getStoreId(),
                store.getBranch().getBranchName(),
                store.getCity(),
                store.getAddress(),
                store.getAddressNo(),
                store.getLatitude(),
                store.getLongitude()
        );
    }

    private OfferDTO createOfferDTO(Offer offer) {
        Set<Long> subcategoryIds = new HashSet<>();

        for (Subcategory subcategory : offer.getSubcategories()) {
            subcategoryIds.add(subcategory.getSubcategoryId());
        }

        return new OfferDTO(
                offer.getOfferId(),
                offer.getTitle(),
                offer.getDescription(),
                offer.getPrice(),
                offer.getOldPrice(),
                subcategoryIds
        );
    }
}
