package com.bargainhunter.bargainhunterws.services;

import com.bargainhunter.bargainhunterws.models.DTOs.searchService.SearchInRadiusDTO;

public interface ISearchService {
    SearchInRadiusDTO getAllBranchesWithStoresAndOffersInRadiusDTO(Double latitude, Double longitude, Double radius);
}
