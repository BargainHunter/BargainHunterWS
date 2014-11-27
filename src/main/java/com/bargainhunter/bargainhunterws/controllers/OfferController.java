package com.bargainhunter.bargainhunterws.controllers;

import com.bargainhunter.bargainhunterws.models.DTOs.OfferDTO;
import com.bargainhunter.bargainhunterws.models.entities.Offer;
import com.bargainhunter.bargainhunterws.models.entities.Store;
import com.bargainhunter.bargainhunterws.repositories.IOfferRepository;
import com.bargainhunter.bargainhunterws.repositories.IStoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

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
        Offer offer = offerRepository.getOne(offerId);

        return createDTO(offer);
    }

    @Override
    public Collection<OfferDTO> getAllOffersDTOs() {
        Collection<Offer> offers = offerRepository.findAll();
        return createDTOs(offers);
    }

    @Override
    public Collection<OfferDTO> getAllOffersDTOsInRadius(double latitude, double longitude, double radius) {
        Collection<Store> stores = storeRepository.findAll();
        Collection<Store> storesInRadius = new HashSet<>();
        Collection<Offer> offers = new HashSet<>();

        DistanceController distanceController = new DistanceController();

        for (Store store : stores) {
            if (distanceController.calcDistance(
                    store.getLatitude(),
                    store.getLongitude(),
                    latitude,
                    longitude) < radius) {
                storesInRadius.add(store);
            }
        }

        for (Store store : storesInRadius) {
            for (Offer of : store.getCompany().getOffers()) {
                    offers.add(of);
            }
        }

        return createDTOs(offers);
    }

    @Override
    public Collection<OfferDTO> getAllOffersDTOsFromStoreById(long storeId) {
        Set<Offer> offers = storeRepository.getOne(storeId).getCompany().getOffers();

        return createDTOs(offers);
    }

    @Override
    public Collection<OfferDTO> createDTOs(Collection<Offer> offers) {
        Collection<OfferDTO> offerDTOs = new ArrayList<>();

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
