package com.bargainhunter.bargainhunterws.controllers;

import com.bargainhunter.bargainhunterws.models.DTOs.OfferDTO;
import com.bargainhunter.bargainhunterws.models.entities.Offer;

import java.util.Collection;

public interface IOfferController {
    OfferDTO getOfferDTOById(Long offerId);

    Collection<OfferDTO> getAllOffersDTOs();

    Collection<OfferDTO> getAllOfferDTOsInRadius(Double latitude, Double longitude, Double radius);

    Collection<OfferDTO> getAllOfferDTOsFromStoreById(Long storeId);

    Collection<OfferDTO> createDTOs(Collection<Offer> offers);

    OfferDTO createDTO(Offer offer);
}
