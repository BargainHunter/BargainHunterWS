package com.bargainhunter.bargainhunterws.mappers.DTOMappers.categoriesController;

import com.bargainhunter.bargainhunterws.mappers.IMapper;
import com.bargainhunter.bargainhunterws.models.DTOs.categoriesController.SubcategoryDTO;
import com.bargainhunter.bargainhunterws.models.entities.Subcategory;
import org.springframework.stereotype.Component;

@Component
public class SubcategoryDTOMapper implements IMapper<Subcategory, SubcategoryDTO> {
    @Override
    public SubcategoryDTO map(Subcategory source, SubcategoryDTO target) {
        target.setSubcategoryId(source.getSubcategoryId());
        target.setDescription(source.getDescription());

        return target;
    }
}
