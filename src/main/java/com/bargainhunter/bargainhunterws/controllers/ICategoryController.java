package com.bargainhunter.bargainhunterws.controllers;

import com.bargainhunter.bargainhunterws.models.DTOs.entityDTOs.CategoryDTO;

import java.util.Collection;

public interface ICategoryController {
    Collection<CategoryDTO> getAllCategoryDTOs();
}
