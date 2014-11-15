package com.bargainhunter.bargainhunterws.services;

import com.bargainhunter.bargainhunterws.models.entities.Offer;
import com.bargainhunter.bargainhunterws.repositories.IOfferRepository;
import com.bargainhunter.bargainhunterws.repositories.IStoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

/**
 * Created by Achilleas Naoumidis on 11/13/14.
 */
@RestController
public class OfferService implements IOfferService {
    @Autowired
    IOfferRepository offerRepository;

    @Autowired
    IStoreRepository storeRepository;

    @Override
    @RequestMapping(value = "/offers", method = RequestMethod.GET)
    public Collection<Offer> getAll() {
        return offerRepository.findAll();
    }

    @Override
    @RequestMapping(value = "/offers/{offerId}", method = RequestMethod.GET)
    public Offer getOneById(@PathVariable long offerId) {
        return offerRepository.findOne(offerId);
    }

    @Override
    @RequestMapping(value = "/stores/{storeId}/offers", method = RequestMethod.GET)
    public Collection<Offer> getAllFromStore(@PathVariable long storeId) {
        return storeRepository.findOne(storeId).getOffers();
    }
}
