package com.bargainhunter.bargainhunterws.services;

import com.bargainhunter.bargainhunterws.mappers.IMapper;
import com.bargainhunter.bargainhunterws.models.DTOs.categoriesController.CategoriesDTO;
import com.bargainhunter.bargainhunterws.models.DTOs.categoriesController.CategoryDTO;
import com.bargainhunter.bargainhunterws.models.entities.Category;
import com.bargainhunter.bargainhunterws.repositories.ICategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService implements ICategoryService {
    @Autowired
    private ICategoryRepository categoryRepository;

    @Autowired
    private IMapper<Category, CategoryDTO> categoryDTOMapper;

    @Override
    public CategoriesDTO getAllCategoryDTOs() {
        CategoriesDTO categoriesDTO = new CategoriesDTO();

        for (Category category : categoryRepository.findAll()) {
            categoriesDTO.getCategories().add(categoryDTOMapper.map(category, new CategoryDTO()));
        }

        return categoriesDTO;
    }
}
