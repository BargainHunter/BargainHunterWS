package com.bargainhunter.bargainhunterws.services;

import com.bargainhunter.bargainhunterws.models.DTOs.entityDTOs.CategoryDTO;
import org.springframework.http.ResponseEntity;

import java.util.Collection;

public interface ICategoryService {
    ResponseEntity<Collection<CategoryDTO>> getAllCategoryDTOs();
}
