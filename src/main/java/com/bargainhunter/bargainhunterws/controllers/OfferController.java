package com.bargainhunter.bargainhunterws.controllers;

import com.bargainhunter.bargainhunterws.models.DTOs.OfferDTO;
import com.bargainhunter.bargainhunterws.models.entities.Offer;
import com.bargainhunter.bargainhunterws.models.entities.Store;
import com.bargainhunter.bargainhunterws.repositories.IOfferRepository;
import com.bargainhunter.bargainhunterws.repositories.IStoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.*;

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
    public OfferDTO getOfferDTOById(long offerId) {
        Offer offer = offerRepository.findOne(offerId);
        return createDTO(offer);
    }

    @Override
    public Collection<OfferDTO> getAllOffersDTOs() {
        Collection<Offer> offers = offerRepository.findAll();
        return createDTOs(offers);
    }

    @Override
    public Collection<OfferDTO> getAllOffersDTOsFromStoreById(long storeId) {
        Collection<Offer> offers = storeRepository.findOne(storeId).getCompany().getOffers();
        return createDTOs(offers);
    }

    @Override
    public Collection<OfferDTO> getAllOffersDTOsInRadius(double latitude, double longitude, double radius) {


        Collection<Store> storesInRadius = new HashSet<>();
        DistanceCalc distanceCalc = new DistanceCalc();
        Collection<Store> stores = storeRepository.findAll();
        for (Store store : stores) {
            if ((distanceCalc.distance(store.getLatitude(),
                                  store.getLongitude(),
                                  latitude,
                                  longitude)) < radius) {
                storesInRadius.add(store);
            }
        }
        Collection<Offer> offers = new HashSet<>();
        for (Store store : storesInRadius) {
            for (Offer of : store.getCompany().getOffers()) {
                    offers.add(of);
            }
        }
        return createDTOs(offers);
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
                offer.getCompany().getCompanyId()
        );
        return offerDTO;
    }
}
