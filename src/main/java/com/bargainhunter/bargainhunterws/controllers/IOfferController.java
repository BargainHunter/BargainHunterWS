package com.bargainhunter.bargainhunterws.controllers;

import com.bargainhunter.bargainhunterws.models.DTOs.OfferDTO;
import com.bargainhunter.bargainhunterws.models.entities.Offer;

import java.util.Collection;

/**
 * Created by Achilleas Naoumidis on 11/14/14.
 */
public interface IOfferController {
    OfferDTO getOfferDTOById(long offerId);

    Collection<OfferDTO> getAllOffersDTOs();

    Collection<OfferDTO> getAllOffersDTOsInRadius(double latitude, double longitude, double radius);

    Collection<OfferDTO> getAllOffersDTOsFromStoreById(long storeId);

    Collection<OfferDTO> createDTOs(Collection<Offer> offers);

    OfferDTO createDTO(Offer offer);
}
