package com.bargainhunter.bargainhunterws.controllers;

import com.bargainhunter.bargainhunterws.models.DTOs.searchController.SearchInRadiusDTO;
import org.springframework.http.HttpEntity;

public interface ISearchController {
    HttpEntity<SearchInRadiusDTO> getAllBranchesWithStoresAndOffersInRadius(Double latitude, Double longitude, Double radius);
}
