package com.bargainhunter.bargainhunterws.services;

import com.bargainhunter.bargainhunterws.models.DTOs.searchService.SearchInRadiusDTO;
import org.springframework.http.ResponseEntity;

public interface ISearchService {
    ResponseEntity<SearchInRadiusDTO> getAllBranchesWithStoresAndOffersInRadius(Double latitude, Double longitude, Double radius);
}
