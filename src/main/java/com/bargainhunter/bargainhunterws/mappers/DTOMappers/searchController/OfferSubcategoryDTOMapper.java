package com.bargainhunter.bargainhunterws.mappers.DTOMappers.searchController;

import com.bargainhunter.bargainhunterws.mappers.IMapper;
import com.bargainhunter.bargainhunterws.models.DTOs.searchController.OfferSubcategoryDTO;
import com.bargainhunter.bargainhunterws.models.entities.Subcategory;
import org.springframework.stereotype.Component;

@Component
public class OfferSubcategoryDTOMapper implements IMapper<Subcategory, OfferSubcategoryDTO> {
    @Override
    public OfferSubcategoryDTO map(Subcategory source, OfferSubcategoryDTO target) {
        target.setSubcategoryId(source.getSubcategoryId());

        return target;
    }
}
