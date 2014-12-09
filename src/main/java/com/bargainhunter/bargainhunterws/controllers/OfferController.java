package com.bargainhunter.bargainhunterws.controllers;

import com.bargainhunter.bargainhunterws.models.DTOs.entityDTOs.OfferDTO;
import com.bargainhunter.bargainhunterws.models.DTOs.entityDTOs.SubcategoryDTO;
import com.bargainhunter.bargainhunterws.models.entities.Offer;
import com.bargainhunter.bargainhunterws.models.entities.Subcategory;
import com.bargainhunter.bargainhunterws.repositories.IOfferRepository;
import com.bargainhunter.bargainhunterws.repositories.IStoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.persistence.EntityNotFoundException;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Controller
public class OfferController implements IOfferController {
    @Autowired
    IOfferRepository offerRepository;

    @Autowired
    IStoreRepository storeRepository;

    @Autowired
    ISubcategoryController subcategoryController;

    @Override
    public OfferDTO getOfferDTOById(Long offerId) throws EntityNotFoundException {
        Offer offer = offerRepository.getOne(offerId);

        return createOfferDTO(offer);
    }

    @Override
    public Collection<OfferDTO> getAllOfferDTOs() {
        Collection<Offer> offers = offerRepository.findAll();

        return createOfferDTOs(offers);
    }

    @Override
    public Collection<OfferDTO> getAllOfferDTOsFromStoreById(Long storeId) throws EntityNotFoundException {
        Set<Offer> offers = storeRepository.getOne(storeId).getBranch().getOffers();

        return createOfferDTOs(offers);
    }

    private Collection<OfferDTO> createOfferDTOs(Collection<Offer> offers) {
        Set<OfferDTO> offerDTOs = new HashSet<>();

        for (Offer offer : offers) {
            offerDTOs.add(createOfferDTO(offer));
        }

        return offerDTOs;
    }

    private OfferDTO createOfferDTO(Offer offer) {
        Collection<SubcategoryDTO> subcategoryDTOs = createSubcategoryDTOs(offer.getSubcategories());

        return new OfferDTO(
                offer.getOfferId(),
                offer.getTitle(),
                offer.getDescription(),
                offer.getPrice(),
                offer.getOldPrice(),
                offer.getBranch().getBranchId(),
                subcategoryDTOs
        );
    }

    private Collection<SubcategoryDTO> createSubcategoryDTOs(Collection<Subcategory> subcategories) {
        Set<SubcategoryDTO> subcategoryDTOs = new HashSet<>();

        for (Subcategory subcategory : subcategories) {
            subcategoryDTOs.add(createSubcategoryDTO(subcategory));
        }

        return subcategoryDTOs;
    }

    private SubcategoryDTO createSubcategoryDTO(Subcategory subcategory) {
        return new SubcategoryDTO(
                subcategory.getSubcategoryId(),
                subcategory.getDescription(),
                subcategory.getCategory().getCategoryId()
        );
    }
}
