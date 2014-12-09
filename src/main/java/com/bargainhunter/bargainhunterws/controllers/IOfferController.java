package com.bargainhunter.bargainhunterws.controllers;

import com.bargainhunter.bargainhunterws.models.DTOs.entityDTOs.OfferDTO;

import javax.persistence.EntityNotFoundException;
import java.util.Collection;

public interface IOfferController {
    OfferDTO getOfferDTOById(Long offerId) throws EntityNotFoundException;

    Collection<OfferDTO> getAllOfferDTOs();

    Collection<OfferDTO> getAllOfferDTOsFromStoreById(Long storeId) throws EntityNotFoundException;
}
