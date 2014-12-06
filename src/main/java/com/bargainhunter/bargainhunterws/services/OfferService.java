package com.bargainhunter.bargainhunterws.services;

import com.bargainhunter.bargainhunterws.controllers.IOfferController;
import com.bargainhunter.bargainhunterws.models.DTOs.OfferDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.Collection;

@RestController
public class OfferService implements IOfferService {
    @Autowired
    IOfferController offerController;

    @Override
    @RequestMapping(value = "/offers", method = RequestMethod.GET)
    public ResponseEntity<Collection<OfferDTO>> getAllOffersInRadius(
            @RequestParam Double latitude,
            @RequestParam Double longitude,
            @RequestParam Double radius) {
        Collection<OfferDTO> offerDTOs = offerController.getAllOfferDTOsInRadius(latitude, longitude, radius);

        return new ResponseEntity<>(offerDTOs, null, HttpStatus.OK);
    }

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
