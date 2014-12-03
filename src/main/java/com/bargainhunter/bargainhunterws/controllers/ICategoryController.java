package com.bargainhunter.bargainhunterws.controllers;

import com.bargainhunter.bargainhunterws.models.DTOs.CategoryDTO;
import com.bargainhunter.bargainhunterws.models.entities.Category;

import java.util.Collection;

public interface ICategoryController {
    Collection<CategoryDTO> getAllCategoryDTOs();

    Collection<CategoryDTO> createDTOs(Collection<Category> categories);

    CategoryDTO createDTO(Category category);
}
