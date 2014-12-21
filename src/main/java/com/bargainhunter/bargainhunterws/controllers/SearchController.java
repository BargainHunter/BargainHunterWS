package com.bargainhunter.bargainhunterws.controllers;

import com.bargainhunter.bargainhunterws.models.DTOs.searchService.SearchInRadiusDTO;
import com.bargainhunter.bargainhunterws.services.ISearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SearchController implements ISearchController {
    @Autowired
    ISearchService searchService;

    @Override
    @RequestMapping(value = "/search_in_radius", method = RequestMethod.GET)
    public HttpEntity<SearchInRadiusDTO> getAllBranchesWithStoresAndOffersInRadius(
            @RequestParam Double latitude,
            @RequestParam Double longitude,
            @RequestParam Double radius) {
        SearchInRadiusDTO searchInRadiusDTO = searchService.getAllBranchesWithStoresAndOffersInRadiusDTO(latitude, longitude, radius);

        return new ResponseEntity<>(searchInRadiusDTO, null, HttpStatus.OK);
    }
}
