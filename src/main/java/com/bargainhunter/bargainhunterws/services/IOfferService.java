package com.bargainhunter.bargainhunterws.services;

import com.bargainhunter.bargainhunterws.models.DTOs.entityDTOs.OfferDTO;
import org.springframework.http.ResponseEntity;

import java.util.Collection;

public interface IOfferService {
    ResponseEntity<OfferDTO> getOneOfferById(Long offerId);

    ResponseEntity<Collection<OfferDTO>> getAllOffers();

    ResponseEntity<Collection<OfferDTO>> getAllOffersFromStoreById(Long storeId);
}
