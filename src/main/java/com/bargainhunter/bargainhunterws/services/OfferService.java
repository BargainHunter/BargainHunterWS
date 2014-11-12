package com.bargainhunter.bargainhunterws.services;

import com.bargainhunter.bargainhunterws.models.Offer;
import com.bargainhunter.bargainhunterws.repository.OfferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Tommy on 11/12/2014.
 */
@RestController
@RequestMapping("/offers")
public class OfferService {

    private OfferRepository offerRepository;

    @Autowired
    public OfferService(OfferRepository offerRepository) {
        this.offerRepository = offerRepository;
    }

    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public Offer get(@PathVariable long id) {
        return this.offerRepository.findOne(id);
    }
}
