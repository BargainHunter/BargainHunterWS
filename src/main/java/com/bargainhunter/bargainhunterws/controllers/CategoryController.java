package com.bargainhunter.bargainhunterws.controllers;

import com.bargainhunter.bargainhunterws.models.DTOs.entityDTOs.CategoryDTO;
import com.bargainhunter.bargainhunterws.models.entities.Category;
import com.bargainhunter.bargainhunterws.repositories.ICategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Controller
public class CategoryController implements ICategoryController {
    @Autowired
    ICategoryRepository categoryRepository;

    @Override
    public Collection<CategoryDTO> getAllCategoryDTOs() {
        Collection<Category> categories = categoryRepository.findAll();

        return createCategoryDTOs(categories);
    }

    public Collection<CategoryDTO> createCategoryDTOs(Collection<Category> categories) {
        Set<CategoryDTO> categoryDTOs = new HashSet<>();

        for (Category category : categories) {
            categoryDTOs.add(createCategoryDTO(category));
        }

        return categoryDTOs;
    }

    public CategoryDTO createCategoryDTO(Category category) {
        return new CategoryDTO(
                category.getCategoryId(),
                category.getDescription()
        );
    }
}
