package com.bargainhunter.bargainhunterws.controllers;

import com.bargainhunter.bargainhunterws.models.DTOs.categoriesService.CategoriesDTO;
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
public class CategoryController implements ICategoryController {
    @Autowired
    ICategoryRepository categoryRepository;

    @Override
    public CategoriesDTO getAllCategoryDTOs() {
        return createCategoryDTOs(categoryRepository.findAll());
    }

    private CategoriesDTO createCategoryDTOs(Collection<Category> categories) {
        CategoriesDTO categoriesDTO = new CategoriesDTO();

        for (Category category : categories) {
            categoriesDTO.getCategories().add(createCategoryDTO(category));
        }

        return categoriesDTO;
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
