package com.bargainhunter.bargainhunterws.services;

import com.bargainhunter.bargainhunterws.models.Offer;
import com.bargainhunter.bargainhunterws.repository.OfferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Achilleas Naoumidis on 11/13/14.
 */
@RestController
public class OfferService {
    @Autowired
    OfferRepository offerRepository;

    @RequestMapping(value = "/offers", method = RequestMethod.GET)
    public List<Offer> getAll() {
        return offerRepository.findAll();
    }
}
