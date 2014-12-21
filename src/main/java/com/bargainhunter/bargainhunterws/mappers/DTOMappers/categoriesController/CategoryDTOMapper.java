package com.bargainhunter.bargainhunterws.mappers.DTOMappers.categoriesController;

import com.bargainhunter.bargainhunterws.mappers.IMapper;
import com.bargainhunter.bargainhunterws.models.DTOs.categoriesController.CategoryDTO;
import com.bargainhunter.bargainhunterws.models.DTOs.categoriesController.SubcategoryDTO;
import com.bargainhunter.bargainhunterws.models.entities.Category;
import com.bargainhunter.bargainhunterws.models.entities.Subcategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CategoryDTOMapper implements IMapper<Category, CategoryDTO> {
    @Autowired
    private IMapper<Subcategory, SubcategoryDTO> subcategoryDTOMapper;

    @Override
    public CategoryDTO map(Category source, CategoryDTO target) {
        target.setCategoryId(source.getCategoryId());
        target.setDescription(source.getDescription());

        for (Subcategory subcategory : source.getSubcategories()) {
            target.getSubcategories().add(subcategoryDTOMapper.map(subcategory, new SubcategoryDTO()));
        }

        return target;
    }
}
