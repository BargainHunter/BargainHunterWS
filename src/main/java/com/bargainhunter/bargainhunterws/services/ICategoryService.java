package com.bargainhunter.bargainhunterws.services;

import com.bargainhunter.bargainhunterws.models.DTOs.CategoryDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Collection;

public interface ICategoryService {
    @RequestMapping(value = "/categories", method = RequestMethod.GET)
    ResponseEntity<Collection<CategoryDTO>> getAllCategoryDTOs();
}
