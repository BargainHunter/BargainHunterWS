package com.bargainhunter.bargainhunterws.services;

import com.bargainhunter.bargainhunterws.models.DTOs.OfferDTO;
import org.springframework.http.ResponseEntity;

import java.util.Collection;

public interface IOfferService {
    ResponseEntity<Collection<OfferDTO>> getAllOffersInRadius(Double latitude, Double longitude, Double radius);

    ResponseEntity<OfferDTO> getOneOfferById(Long offerId);

    ResponseEntity<Collection<OfferDTO>> getAllOffersFromStoreById(Long storeId);
}
