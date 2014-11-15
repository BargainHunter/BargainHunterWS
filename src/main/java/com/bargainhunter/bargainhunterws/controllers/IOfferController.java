package com.bargainhunter.bargainhunterws.controllers;

import com.bargainhunter.bargainhunterws.models.dtos.OfferDTO;

import java.util.Collection;

/**
 * Created by Achilleas Naoumidis on 11/14/14.
 */
public interface IOfferController {
    Collection<OfferDTO> getAll();

    OfferDTO getOneById(long offerId);

    Collection<OfferDTO> getAllFromStore(long storeId);
}
