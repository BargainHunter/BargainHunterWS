package com.bargainhunter.bargainhunterws.controllers;

import com.bargainhunter.bargainhunterws.models.DTOs.OfferDTO;
import com.bargainhunter.bargainhunterws.models.entities.Offer;

import javax.persistence.EntityNotFoundException;
import java.util.Collection;

public interface IOfferController {
    OfferDTO getOfferDTOById(Long offerId) throws EntityNotFoundException;

    Collection<OfferDTO> getAllOfferDTOsInRadius(Double latitude, Double longitude, Double radius);

    Collection<OfferDTO> getAllOfferDTOsFromStoreById(Long storeId) throws EntityNotFoundException;

    Collection<OfferDTO> createDTOs(Collection<Offer> offers);

    OfferDTO createDTO(Offer offer);
}
