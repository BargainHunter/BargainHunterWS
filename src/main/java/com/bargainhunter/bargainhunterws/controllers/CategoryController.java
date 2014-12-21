package com.bargainhunter.bargainhunterws.controllers;

import com.bargainhunter.bargainhunterws.models.DTOs.categoriesService.CategoriesDTO;
import com.bargainhunter.bargainhunterws.services.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CategoryController implements ICategoryController {
    @Autowired
    ICategoryService categoryService;

    @Override
    @RequestMapping(value = "/categories", method = RequestMethod.GET)
    public HttpEntity<CategoriesDTO> getAllCategoryDTOs() {
        CategoriesDTO categoriesDTOs = categoryService.getAllCategoryDTOs();

        return new ResponseEntity<>(categoriesDTOs, null, HttpStatus.OK);
    }
}
