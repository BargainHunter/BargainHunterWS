package com.bargainhunter.bargainhunterws.services;

import com.bargainhunter.bargainhunterws.models.DTOs.categoriesService.CategoryDTO;
import org.springframework.http.ResponseEntity;

import java.util.Collection;

public interface ICategoriesService {
    ResponseEntity<Collection<CategoryDTO>> getAllCategoryDTOs();
}
