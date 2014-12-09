package com.bargainhunter.bargainhunterws.services;

import com.bargainhunter.bargainhunterws.controllers.IOfferController;
import com.bargainhunter.bargainhunterws.models.DTOs.entityDTOs.OfferDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityNotFoundException;
import java.util.Collection;

@RestController
public class OfferService implements IOfferService {
    @Autowired
    IOfferController offerController;

    @Override
    @RequestMapping(value = "/offers/{offerId}", method = RequestMethod.GET)
    public ResponseEntity<OfferDTO> getOneOfferById(@PathVariable Long offerId) {
        HttpStatus status = HttpStatus.OK;

        OfferDTO offerDTO = null;

        try {
            offerDTO = offerController.getOfferDTOById(offerId);
        } catch (EntityNotFoundException e) {
            status = HttpStatus.NOT_FOUND;
        }

        return new ResponseEntity<>(offerDTO, null, status);
    }

    @Override
    @RequestMapping(value = "/offers", method = RequestMethod.GET)
    public ResponseEntity<Collection<OfferDTO>> getAllOffers() {
        Collection<OfferDTO> offerDTOs = offerController.getAllOfferDTOs();

        return new ResponseEntity<>(offerDTOs, null, HttpStatus.OK);
    }

    @Override
    @RequestMapping(value = "/stores/{storeId}/offers", method = RequestMethod.GET)
    public ResponseEntity<Collection<OfferDTO>> getAllOffersFromStoreById(@PathVariable Long storeId) {
        HttpStatus status = HttpStatus.OK;

        Collection<OfferDTO> offerDTOs = null;

        try {
            offerDTOs = offerController.getAllOfferDTOsFromStoreById(storeId);
        } catch (EntityNotFoundException e) {
            status = HttpStatus.NOT_FOUND;
        }

        return new ResponseEntity<>(offerDTOs, null, status);
    }
}
