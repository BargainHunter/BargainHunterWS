package com.bargainhunter.bargainhunterws.services;

import com.bargainhunter.bargainhunterws.models.DTOs.OfferDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Collection;

/**
 * Created by Achilleas Naoumidis on 11/14/14.
 */
public interface IOfferService {
    @RequestMapping(value = "/offers", method = RequestMethod.GET)
    ResponseEntity<Collection<OfferDTO>> getAllOffers();

    @RequestMapping(value = "/offers/{offerId}", method = RequestMethod.GET)
    ResponseEntity<OfferDTO> getOneOfferById(@PathVariable long offerId);

    @RequestMapping(value = "/stores/{storeId}/offers", method = RequestMethod.GET)
    ResponseEntity<Collection<OfferDTO>> getAllOffersFromStoreById(@PathVariable long storeId);
}
