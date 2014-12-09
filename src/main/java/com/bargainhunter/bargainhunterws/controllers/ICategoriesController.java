package com.bargainhunter.bargainhunterws.controllers;

import com.bargainhunter.bargainhunterws.models.DTOs.categoriesService.CategoryDTO;

import java.util.Collection;

public interface ICategoriesController {
    Collection<CategoryDTO> getAllCategoryDTOs();
}
