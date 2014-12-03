package com.bargainhunter.bargainhunterws.services;

import com.bargainhunter.bargainhunterws.models.DTOs.SubcategoryDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Collection;

public interface ISubcategoryService {
    @RequestMapping(value = "/subcategories", method = RequestMethod.GET)
    ResponseEntity<Collection<SubcategoryDTO>> getAllSubcategories();

    @RequestMapping(value = "/categories/{categoryId}/subcategories", method = RequestMethod.GET)
    ResponseEntity<Collection<SubcategoryDTO>> getAllSubcategoriesFromCategoryById(@PathVariable Long categoryId);
}
