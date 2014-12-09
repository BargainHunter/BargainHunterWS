package com.bargainhunter.bargainhunterws.services;

import com.bargainhunter.bargainhunterws.controllers.ICategoriesController;
import com.bargainhunter.bargainhunterws.models.DTOs.categoriesService.CategoryDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
public class CategoriesService implements ICategoriesService {
    @Autowired
    ICategoriesController categoriesController;

    @Override
    @RequestMapping(value = "/categories_all", method = RequestMethod.GET)
    public ResponseEntity<Collection<CategoryDTO>> getAllCategoryDTOs() {
        Collection<CategoryDTO> categoryDTOs = categoriesController.getAllCategoryDTOs();

        return new ResponseEntity<>(categoryDTOs, null, HttpStatus.OK);
    }
}
