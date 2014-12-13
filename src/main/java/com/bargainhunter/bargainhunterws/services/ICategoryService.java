package com.bargainhunter.bargainhunterws.services;

import com.bargainhunter.bargainhunterws.models.DTOs.categoriesService.CategoriesDTO;
import org.springframework.http.HttpEntity;

public interface ICategoryService {
    HttpEntity<CategoriesDTO> getAllCategoryDTOs();
}
