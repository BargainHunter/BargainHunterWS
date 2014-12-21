package com.bargainhunter.bargainhunterws.services;

import com.bargainhunter.bargainhunterws.models.DTOs.searchController.SearchInRadiusDTO;

public interface ISearchService {
    SearchInRadiusDTO getAllBranchesWithStoresAndOffersInRadiusDTO(Double latitude, Double longitude, Double radius);
}
