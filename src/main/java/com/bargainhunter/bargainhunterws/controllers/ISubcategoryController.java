package com.bargainhunter.bargainhunterws.controllers;

import com.bargainhunter.bargainhunterws.models.DTOs.SubcategoryDTO;
import com.bargainhunter.bargainhunterws.models.entities.Subcategory;

import javax.persistence.EntityNotFoundException;
import java.util.Collection;

public interface ISubcategoryController {
    Collection<SubcategoryDTO> getAllSubcategoryDTOs();

    Collection<SubcategoryDTO> getAllSubcategoryDTOsFromCategoryById(Long categoryId) throws EntityNotFoundException;

    Collection<SubcategoryDTO> createDTOs(Collection<Subcategory> categories);

    SubcategoryDTO createDTO(Subcategory subcategory);
}
