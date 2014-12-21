package com.bargainhunter.bargainhunterws.mappers.DTOMappers.searchController;

import com.bargainhunter.bargainhunterws.mappers.IMapper;
import com.bargainhunter.bargainhunterws.models.DTOs.searchController.OfferDTO;
import com.bargainhunter.bargainhunterws.models.DTOs.searchController.OfferSubcategoryDTO;
import com.bargainhunter.bargainhunterws.models.entities.Offer;
import com.bargainhunter.bargainhunterws.models.entities.Subcategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OfferDTOMapper implements IMapper<Offer, OfferDTO> {
    @Autowired
    private IMapper<Subcategory, OfferSubcategoryDTO> offerSubcategoryDTOMapper;

    @Override
    public OfferDTO map(Offer source, OfferDTO target) {
        target.setOfferId(source.getOfferId());
        target.setTitle(source.getTitle());
        target.setDescription(source.getDescription());
        target.setOldPrice(source.getOldPrice());
        target.setPrice(source.getPrice());

        for (Subcategory subcategory : source.getSubcategories()) {
            target.getSubcategories().add(offerSubcategoryDTOMapper.map(subcategory, new OfferSubcategoryDTO()));
        }

        return target;
    }
}
