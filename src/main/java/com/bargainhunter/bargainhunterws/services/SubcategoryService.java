package com.bargainhunter.bargainhunterws.services;

import com.bargainhunter.bargainhunterws.controllers.ISubcategoryController;
import com.bargainhunter.bargainhunterws.models.DTOs.SubcategoryDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityNotFoundException;
import java.util.Collection;

@RestController
public class SubcategoryService implements ISubcategoryService {
    @Autowired
    ISubcategoryController subcategoryController;

    @Override
    @RequestMapping(value = "/subcategories", method = RequestMethod.GET)
    public ResponseEntity<Collection<SubcategoryDTO>> getAllSubcategories() {
        HttpHeaders headers = new HttpHeaders();

        headers.add("Content-Type", "application/json;charset=UTF-8");

        Collection<SubcategoryDTO> subcategoryDTOs = subcategoryController.getAllSubcategoryDTOs();

        return new ResponseEntity<>(subcategoryDTOs, headers, HttpStatus.OK);
    }

    @Override
    @RequestMapping(value = "/categories/{categoryId}/subcategories", method = RequestMethod.GET)
    public ResponseEntity<Collection<SubcategoryDTO>> getAllSubcategoriesFromCategoryById(@PathVariable Long categoryId) {
        HttpHeaders headers = new HttpHeaders();
        HttpStatus status = HttpStatus.OK;

        Collection<SubcategoryDTO> subcategoryDTOs = null;

        headers.add("Content-Type", "application/json;charset=UTF-8");

        try {
            subcategoryDTOs = subcategoryController.getAllSubcategoryDTOsFromCategoryById(categoryId);
        } catch (EntityNotFoundException e) {
            status = HttpStatus.NOT_FOUND;
        }

        return new ResponseEntity<>(subcategoryDTOs, headers, status);
    }
}
