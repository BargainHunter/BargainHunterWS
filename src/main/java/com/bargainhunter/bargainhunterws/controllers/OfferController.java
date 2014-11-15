package com.bargainhunter.bargainhunterws.controllers;

import com.bargainhunter.bargainhunterws.models.DTOs.OfferDTO;
import com.bargainhunter.bargainhunterws.models.entities.Offer;
import com.bargainhunter.bargainhunterws.repositories.IOfferRepository;
import com.bargainhunter.bargainhunterws.repositories.IStoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.Collection;
import java.util.HashSet;

/**
 * Created by Achilleas Naoumidis on 11/15/14.
 */
@Controller
public class OfferController implements IOfferController {
    @Autowired
    IOfferRepository offerRepository;

    @Autowired
    IStoreRepository storeRepository;

    @Override
    public Collection<OfferDTO> getAllOffersDTOs() {
        Collection<Offer> offers = offerRepository.findAll();
        return createDTOs(offers);
    }

    @Override
    public Collection<OfferDTO> getAllOffersDTOsFromStoreById(long storeId) {
        Collection<Offer> offers = storeRepository.findOne(storeId).getOffers();
        return createDTOs(offers);
    }

    @Override
    public OfferDTO getOfferDTOById(long offerId) {
        Offer offer = offerRepository.findOne(offerId);
        return createDTO(offer);
    }

    @Override
    public Collection<OfferDTO> createDTOs(Collection<Offer> offers) {
        Collection<OfferDTO> offerDTOs = new HashSet<>();

        for (Offer offer : offers) {
            offerDTOs.add(createDTO(offer));
        }

        return offerDTOs;
    }

    @Override
    public OfferDTO createDTO(Offer offer) {
        OfferDTO offerDTO = new OfferDTO(
                offer.getOfferId(),
                offer.getTitle(),
                offer.getDescription(),
                offer.getPrice(),
                offer.getStore().getStoreId()
        );
        return offerDTO;
    }
}
