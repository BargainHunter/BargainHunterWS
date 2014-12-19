package com.bargainhunter.bargainhunterws.mappers.DTOMappers.searchService;

import com.bargainhunter.bargainhunterws.mappers.IMapper;
import com.bargainhunter.bargainhunterws.models.DTOs.searchService.OfferDTO;
import com.bargainhunter.bargainhunterws.models.DTOs.searchService.OfferSubcategoryDTO;
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
