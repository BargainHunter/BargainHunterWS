package com.bargainhunter.bargainhunterws.services;

import com.bargainhunter.bargainhunterws.controllers.ICategoryController;
import com.bargainhunter.bargainhunterws.models.DTOs.categoriesService.CategoriesDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CategoryService implements ICategoryService {
    @Autowired
    ICategoryController categoriesController;

    @Override
    @RequestMapping(value = "/categories", method = RequestMethod.GET)
    public HttpEntity<CategoriesDTO> getAllCategoryDTOs() {
        CategoriesDTO categoriesDTOs = categoriesController.getAllCategoryDTOs();

        return new ResponseEntity<>(categoriesDTOs, null, HttpStatus.OK);
    }
}
