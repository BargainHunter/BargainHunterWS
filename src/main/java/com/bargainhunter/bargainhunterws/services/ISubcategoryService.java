package com.bargainhunter.bargainhunterws.services;

import com.bargainhunter.bargainhunterws.models.DTOs.SubcategoryDTO;
import org.springframework.http.ResponseEntity;

import java.util.Collection;

public interface ISubcategoryService {
    ResponseEntity<Collection<SubcategoryDTO>> getAllSubcategories();

    ResponseEntity<Collection<SubcategoryDTO>> getAllSubcategoriesFromCategoryById(Long categoryId);
}
