package com.bargainhunter.bargainhunterws.services;

import com.bargainhunter.bargainhunterws.controllers.ICategoryController;
import com.bargainhunter.bargainhunterws.models.DTOs.CategoryDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
public class CategoryService implements ICategoryService {
    @Autowired
    ICategoryController categoryController;

    @Override
    @RequestMapping(value = "/categories", method = RequestMethod.GET)
    public ResponseEntity<Collection<CategoryDTO>> getAllCategoryDTOs() {
        HttpHeaders headers = new HttpHeaders();

        headers.add("Content-Type", "application/json;charset=UTF-8");

        Collection<CategoryDTO> categoryDTOs = categoryController.getAllCategoryDTOs();

        return new ResponseEntity<>(categoryDTOs, headers, HttpStatus.OK);
    }
}
