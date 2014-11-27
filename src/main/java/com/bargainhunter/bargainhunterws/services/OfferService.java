package com.bargainhunter.bargainhunterws.services;

import com.bargainhunter.bargainhunterws.controllers.IOfferController;
import com.bargainhunter.bargainhunterws.models.DTOs.OfferDTO;
import com.bargainhunter.bargainhunterws.repositories.IStoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.Collection;

/**
 * Created by Achilleas Naoumidis on 11/13/14.
 */
@RestController
public class OfferService implements IOfferService {
    @Autowired
    IOfferController offerController;

    @Autowired
    IStoreRepository storeRepository;

    @Override
    @RequestMapping(value = "/offers", method = RequestMethod.GET)
    public ResponseEntity<Collection<OfferDTO>> getAllOffersInRadius(
            @RequestParam double latitude,
            @RequestParam double longitude,
            @RequestParam double radius) {
        HttpHeaders headers = new HttpHeaders();

        headers.add("Content-Type", "application/json;charset=UTF-8");

        Collection<OfferDTO> offerDTOs = offerController.getAllOffersDTOsInRadius(latitude, longitude, radius);

        return new ResponseEntity<>(offerDTOs, headers, HttpStatus.OK);
    }

    @Override
    @RequestMapping(value = "/offers/{offerId}", method = RequestMethod.GET)
    public ResponseEntity<OfferDTO> getOneOfferById(@PathVariable long offerId) {
        HttpHeaders headers = new HttpHeaders();
        HttpStatus status = HttpStatus.OK;

        OfferDTO offerDTO = null;

        headers.add("Content-Type", "application/json;charset=UTF-8");

        try {
            offerDTO = offerController.getOfferDTOById(offerId);
        } catch (EntityNotFoundException e) {
            status = HttpStatus.NOT_FOUND;
        }

        return new ResponseEntity<>(offerDTO, headers, status);
    }

    @Override
    @RequestMapping(value = "/stores/{storeId}/offers", method = RequestMethod.GET)
    public ResponseEntity<Collection<OfferDTO>> getAllOffersFromStoreById(@PathVariable long storeId) {
        HttpHeaders headers = new HttpHeaders();
        HttpStatus status = HttpStatus.OK;

        Collection<OfferDTO> offerDTOs = null;

        headers.add("Content-Type", "application/json;charset=UTF-8");

        try {
            offerDTOs = offerController.getAllOffersDTOsFromStoreById(storeId);
        } catch (EntityNotFoundException e) {
            status = HttpStatus.NOT_FOUND;
        }

        return new ResponseEntity<>(offerDTOs, headers, status);
    }
}
