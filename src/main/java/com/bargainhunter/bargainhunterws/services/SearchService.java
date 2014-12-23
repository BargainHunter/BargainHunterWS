package com.bargainhunter.bargainhunterws.services;

import com.bargainhunter.bargainhunterws.mappers.IMapper;
import com.bargainhunter.bargainhunterws.models.DTOs.searchController.BranchDTO;
import com.bargainhunter.bargainhunterws.models.DTOs.searchController.SearchInRadiusDTO;
import com.bargainhunter.bargainhunterws.models.entities.Branch;
import com.bargainhunter.bargainhunterws.models.entities.Store;
import com.bargainhunter.bargainhunterws.repositories.IOfferRepository;
import com.bargainhunter.bargainhunterws.repositories.IStoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Service
public class SearchService implements ISearchService {
    @Autowired
    private IStoreRepository storeRepository;

    @Autowired
    private IOfferRepository offerRepository;

    @Autowired
    private IMapper<Branch, BranchDTO> branchDTOMapper;

    @Override
    public SearchInRadiusDTO getAllBranchesWithStoresAndOffersInRadiusDTO(Double latitude, Double longitude, Double radius) {
        Collection<Store> stores = storeRepository.findAllInRadius(latitude, longitude, radius);

        return createSearchInRadiusDTO(latitude, longitude, radius, stores);
    }

    private SearchInRadiusDTO createSearchInRadiusDTO(Double latitude, Double longitude, Double radius, Collection<Store> stores) {
        SearchInRadiusDTO searchInRadiusDTO = new SearchInRadiusDTO();

        searchInRadiusDTO.setLatitude(latitude);
        searchInRadiusDTO.setLongitude(longitude);
        searchInRadiusDTO.setRadius(radius);

        Set<Branch> branches = new HashSet<>();

        for (Store store : stores) {
            branches.add(store.getBranch());
        }

        for (Branch branch : branches) {
            branch.setOffers(new HashSet<>(offerRepository.findActiveOfBranch(branch)));
            branch.setStores(new HashSet<>());

            for (Store store : stores) {
                if (branch.equals(store.getBranch())) {
                    branch.getStores().add(store);
                }
            }

            searchInRadiusDTO.getBranches().add(branchDTOMapper.map(branch, new BranchDTO()));
        }

        return searchInRadiusDTO;
    }
}
