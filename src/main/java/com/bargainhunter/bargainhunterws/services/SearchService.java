package com.bargainhunter.bargainhunterws.services;

import com.bargainhunter.bargainhunterws.mappers.IMapper;
import com.bargainhunter.bargainhunterws.models.DTOs.searchService.BranchDTO;
import com.bargainhunter.bargainhunterws.models.DTOs.searchService.SearchInRadiusDTO;
import com.bargainhunter.bargainhunterws.models.entities.Branch;
import com.bargainhunter.bargainhunterws.models.entities.Store;
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
    private IMapper<Branch, BranchDTO> branchDTOMapper;

    @Override
    public SearchInRadiusDTO getAllBranchesWithStoresAndOffersInRadiusDTO(Double latitude, Double longitude, Double radius) {
        Collection<Store> stores = storeRepository.findAllInRadius(latitude, longitude, radius);

        return createSearchInRadiusDTO(latitude, longitude, radius, stores);
    }

    private SearchInRadiusDTO createSearchInRadiusDTO(Double latitude, Double longitude, Double radius, Collection<Store> stores) {
        SearchInRadiusDTO searchInRadiusDTO = new SearchInRadiusDTO();

        Set<Branch> branches = new HashSet<>();

        searchInRadiusDTO.setLatitude(latitude);
        searchInRadiusDTO.setLongitude(longitude);
        searchInRadiusDTO.setRadius(radius);

        Branch tempBranch;

        for (Store store : stores) {
            tempBranch = store.getBranch();
            tempBranch.setStores(new HashSet<>());
            branches.add(tempBranch);
        }

        for (Branch branch : branches) {
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
