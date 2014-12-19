package com.bargainhunter.bargainhunterws.controllers;

import com.bargainhunter.bargainhunterws.mappers.IMapper;
import com.bargainhunter.bargainhunterws.models.DTOs.categoriesService.CategoriesDTO;
import com.bargainhunter.bargainhunterws.models.DTOs.categoriesService.CategoryDTO;
import com.bargainhunter.bargainhunterws.models.entities.Category;
import com.bargainhunter.bargainhunterws.repositories.ICategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

@Component
public class CategoryController implements ICategoryController {
    @Autowired
    private ICategoryRepository categoryRepository;

    @Autowired
    private IMapper<Category, CategoryDTO> categoryDTOMapper;

    @Override
    public CategoriesDTO getAllCategoryDTOs() {
        CategoriesDTO categoriesDTO = new CategoriesDTO();

        for (Category category : categoryRepository.findAll()) {
            categoriesDTO.getCategories().add(categoryDTOMapper.map(category, new CategoryDTO()));
        }

        return categoriesDTO;
    }
}
