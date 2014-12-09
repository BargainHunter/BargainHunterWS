package com.bargainhunter.bargainhunterws.controllers;

import com.bargainhunter.bargainhunterws.models.DTOs.entityDTOs.SubcategoryDTO;
import com.bargainhunter.bargainhunterws.models.entities.Subcategory;
import com.bargainhunter.bargainhunterws.repositories.ICategoryRepository;
import com.bargainhunter.bargainhunterws.repositories.ISubcategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.persistence.EntityNotFoundException;
import java.util.Collection;
import java.util.HashSet;
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

        return createSubcategoryDTOs(subcategories);
    }

    @Override
    public Collection<SubcategoryDTO> getAllSubcategoryDTOsFromCategoryById(Long categoryId) throws EntityNotFoundException {
        Set<Subcategory> subcategories = categoryRepository.getOne(categoryId).getSubcategories();

        return createSubcategoryDTOs(subcategories);
    }

    public Collection<SubcategoryDTO> createSubcategoryDTOs(Collection<Subcategory> subcategories) {
        Set<SubcategoryDTO> subcategoryDTOs = new HashSet<>();

        for (Subcategory subcategory : subcategories) {
            subcategoryDTOs.add(createSubcategoryDTO(subcategory));
        }

        return subcategoryDTOs;
    }

    public SubcategoryDTO createSubcategoryDTO(Subcategory subcategory) {
        return new SubcategoryDTO(
                subcategory.getSubcategoryId(),
                subcategory.getDescription(),
                subcategory.getCategory().getCategoryId()
        );
    }
}
