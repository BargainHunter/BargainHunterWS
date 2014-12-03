package com.bargainhunter.bargainhunterws.controllers;

import com.bargainhunter.bargainhunterws.models.DTOs.SubcategoryDTO;
import com.bargainhunter.bargainhunterws.models.entities.Subcategory;
import com.bargainhunter.bargainhunterws.repositories.ICategoryRepository;
import com.bargainhunter.bargainhunterws.repositories.ISubcategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

@Controller
public class SubcategoryController implements ISubcategoryController {
    @Autowired
    ISubcategoryRepository subcategoryRepository;

    @Autowired
    ICategoryRepository categoryRepository;

    @Override
    public Collection<SubcategoryDTO> getAllSubcategoryDTOs() {
        Collection<Subcategory> subcategories = subcategoryRepository.findAll();

        return createDTOs(subcategories);
    }

    @Override
    public Collection<SubcategoryDTO> getAllSubcategoryDTOsFromCategoryById(Long categoryId) {
        Set<Subcategory> subcategories = categoryRepository.getOne(categoryId).getSubcategories();

        return createDTOs(subcategories);
    }

    @Override
    public Collection<SubcategoryDTO> createDTOs(Collection<Subcategory> subcategories) {
        Collection<SubcategoryDTO> subcategoryDTOs = new ArrayList<>();

        for (Subcategory subcategory : subcategories) {
            subcategoryDTOs.add(createDTO(subcategory));
        }

        return subcategoryDTOs;
    }

    @Override
    public SubcategoryDTO createDTO(Subcategory subcategory) {
        SubcategoryDTO subcategoryDTO = new SubcategoryDTO(
                subcategory.getSubcategoryId(),
                subcategory.getDescription(),
                subcategory.getCategory().getCategoryId()
        );

        return subcategoryDTO;
    }
}
