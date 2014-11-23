package com.bargainhunter.bargainhunterws.services;

import com.bargainhunter.bargainhunterws.controllers.IOfferController;
import com.bargainhunter.bargainhunterws.models.DTOs.OfferDTO;
import com.bargainhunter.bargainhunterws.repositories.IStoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
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
    public ResponseEntity<Collection<OfferDTO>> getAllOffers() {
        HttpHeaders headers = new HttpHeaders();
        HttpStatus status = HttpStatus.OK;

        Collection<OfferDTO> offerDTOs = null;

        headers.add("Content-Type", "application/json;charset=UTF-8");

        try {
            offerDTOs = offerController.getAllOffersDTOs();
        } catch (Exception e) {
            System.out.println(Arrays.toString(e.getStackTrace()));
            status = HttpStatus.INTERNAL_SERVER_ERROR;
        }

        return new ResponseEntity<>(offerDTOs, headers, status);
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
        } catch (NullPointerException e) {
            status = HttpStatus.NOT_FOUND;
        } catch (Exception e) {
            System.out.println(Arrays.toString(e.getStackTrace()));
            status = HttpStatus.INTERNAL_SERVER_ERROR;
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
        } catch (NullPointerException e) {
            status = HttpStatus.NOT_FOUND;
        } catch (Exception e) {
            System.out.println(Arrays.toString(e.getStackTrace()));
            status = HttpStatus.INTERNAL_SERVER_ERROR;
        }

        return new ResponseEntity<>(offerDTOs, headers, status);
    }

    @Override
    @RequestMapping(value = "/offer", method = RequestMethod.GET)
    public ResponseEntity<Collection<OfferDTO>> getAllOffersInRadius(@RequestParam(value = "latitude") double latitude,
                                                                     @RequestParam(value = "longitude") double longitude,
                                                                     @RequestParam(value = "radius") double radius) {
        HttpHeaders headers = new HttpHeaders();
        HttpStatus status = HttpStatus.OK;

        Collection<OfferDTO> offerDTOs = null;

        headers.add("Content-Type", "application/json;charset=UTF-8");

        try {
            offerDTOs = offerController.getAllOffersDTOsInRadius(latitude, longitude, radius);
        } catch (NullPointerException e) {
            status = HttpStatus.NOT_FOUND;
        } catch (Exception e) {
            System.out.println(Arrays.toString(e.getStackTrace()));
            status = HttpStatus.INTERNAL_SERVER_ERROR;
        }

        return new ResponseEntity<>(offerDTOs, headers, status);
    }
}













