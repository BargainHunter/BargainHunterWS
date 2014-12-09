package com.bargainhunter.bargainhunterws.controllers;

import com.bargainhunter.bargainhunterws.models.DTOs.entityDTOs.SubcategoryDTO;

import javax.persistence.EntityNotFoundException;
import java.util.Collection;

public interface ISubcategoryController {
    Collection<SubcategoryDTO> getAllSubcategoryDTOs();

    Collection<SubcategoryDTO> getAllSubcategoryDTOsFromCategoryById(Long categoryId) throws EntityNotFoundException;
}
