package com.bargainhunter.bargainhunterws.controllers;

import com.bargainhunter.bargainhunterws.models.DTOs.SubcategoryDTO;
import com.bargainhunter.bargainhunterws.models.entities.Subcategory;

import java.util.Collection;

public interface ISubcategoryController {
    Collection<SubcategoryDTO> getAllSubcategoryDTOs();

    Collection<SubcategoryDTO> getAllSubcategoryDTOsFromCategoryById(Long categoryId);

    Collection<SubcategoryDTO> createDTOs(Collection<Subcategory> categories);

    SubcategoryDTO createDTO(Subcategory subcategory);
}
