package com.bargainhunter.bargainhunterws.controllers;

import com.bargainhunter.bargainhunterws.models.DTOs.OfferDTO;
import com.bargainhunter.bargainhunterws.models.entities.Offer;

import java.util.Collection;

/**
 * Created by Achilleas Naoumidis on 11/14/14.
 */
public interface IOfferController {
    Collection<OfferDTO> getAllOffersDTOs();

    Collection<OfferDTO> getAllOffersDTOsFromStoreById(long storeId);

    OfferDTO getOfferDTOById(long offerId);

    Collection<OfferDTO> createDTOs(Collection<Offer> offers);

    OfferDTO createDTO(Offer offer);
}
