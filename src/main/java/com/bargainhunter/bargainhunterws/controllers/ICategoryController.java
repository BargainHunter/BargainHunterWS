package com.bargainhunter.bargainhunterws.controllers;

import com.bargainhunter.bargainhunterws.models.DTOs.categoriesService.CategoriesDTO;
import org.springframework.http.HttpEntity;

public interface ICategoryController {
    HttpEntity<CategoriesDTO> getAllCategoryDTOs();
}
