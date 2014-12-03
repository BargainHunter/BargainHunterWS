package com.bargainhunter.bargainhunterws.controllers;

import com.bargainhunter.bargainhunterws.models.DTOs.OfferDTO;
import com.bargainhunter.bargainhunterws.models.entities.Offer;

import java.util.Collection;

public interface IOfferController {
    OfferDTO getOfferDTOById(long offerId);

    Collection<OfferDTO> getAllOffersDTOs();

    Collection<OfferDTO> getAllOfferDTOsInRadius(double latitude, double longitude, double radius);

    Collection<OfferDTO> getAllOfferDTOsFromStoreById(long storeId);

    Collection<OfferDTO> createDTOs(Collection<Offer> offers);

    OfferDTO createDTO(Offer offer);
}
