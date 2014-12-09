package com.bargainhunter.bargainhunterws.controllers;

import com.bargainhunter.bargainhunterws.models.DTOs.categoriesService.CategoryDTO;
import com.bargainhunter.bargainhunterws.models.DTOs.categoriesService.SubcategoryDTO;
import com.bargainhunter.bargainhunterws.models.entities.Category;
import com.bargainhunter.bargainhunterws.models.entities.Subcategory;
import com.bargainhunter.bargainhunterws.repositories.ICategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Controller
public class CategoriesController implements ICategoriesController {
    @Autowired
    ICategoryRepository categoryRepository;

    @Override
    public Collection<CategoryDTO> getAllCategoryDTOs() {
        return createCategoryDTOs(categoryRepository.findAll());
    }

    private Collection<CategoryDTO> createCategoryDTOs(Collection<Category> categories) {
        Set<CategoryDTO> categoryDTOs = new HashSet<>();

        for (Category category : categories) {
            categoryDTOs.add(createCategoryDTO(category));
        }

        return categoryDTOs;
    }

    private CategoryDTO createCategoryDTO(Category category) {
        Set<Subcategory> subcategories = category.getSubcategories();

        return new CategoryDTO(
                category.getCategoryId(),
                category.getDescription(),
                createSubcategoryDTOs(subcategories)
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
                subcategory.getDescription()
        );
    }
}
