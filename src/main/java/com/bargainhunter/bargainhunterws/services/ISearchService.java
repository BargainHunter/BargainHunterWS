package com.bargainhunter.bargainhunterws.services;

import com.bargainhunter.bargainhunterws.models.DTOs.searchService.SearchInRadiusDTO;
import org.springframework.http.HttpEntity;

public interface ISearchService {
    HttpEntity<SearchInRadiusDTO> getAllBranchesWithStoresAndOffersInRadius(Double latitude, Double longitude, Double radius);
}
