package com.bargainhunter.bargainhunterws.controllers;

import com.bargainhunter.bargainhunterws.models.DTOs.CategoryDTO;
import com.bargainhunter.bargainhunterws.models.entities.Category;
import com.bargainhunter.bargainhunterws.repositories.ICategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.Collection;

@Controller
public class CategoryController implements ICategoryController {
    @Autowired
    ICategoryRepository categoryRepository;

    @Override
    public Collection<CategoryDTO> getAllCategoryDTOs() {
        Collection<Category> categories = categoryRepository.findAll();

        return createDTOs(categories);
    }

    @Override
    public Collection<CategoryDTO> createDTOs(Collection<Category> categories) {
        Collection<CategoryDTO> categoryDTOs = new ArrayList<>();

        for (Category category : categories) {
            categoryDTOs.add(createDTO(category));
        }

        return categoryDTOs;
    }

    @Override
    public CategoryDTO createDTO(Category category) {
        CategoryDTO categoryDTO = new CategoryDTO(
                category.getCategoryId(),
                category.getDescription()
        );

        return categoryDTO;
    }
}
