package com.bargainhunter.bargainhunterws.controllers;

import com.bargainhunter.bargainhunterws.models.DTOs.categoriesController.CategoriesDTO;
import com.bargainhunter.bargainhunterws.models.DTOs.categoriesController.CategoryDTO;
import com.bargainhunter.bargainhunterws.models.DTOs.categoriesController.SubcategoryDTO;
import com.bargainhunter.bargainhunterws.services.ICategoryService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.SpringApplicationContextLoader;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Collection;
import java.util.HashSet;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
        locations = "classpath:META-INF/testContext.xml",
        loader = SpringApplicationContextLoader.class)
public class CategoryControllerTests {
    @Mock
    private ICategoryService categoryService;

    @InjectMocks
    private CategoryController categoryController;

    private MockMvc mockMvc;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(categoryController).build();
    }

    @Test
    public void testGetAllCategoryDTOsWithTwoCategoriesAndFourSubcategories() throws Exception {
        CategoriesDTO categoriesDTO = new CategoriesDTO();

        Collection<CategoryDTO> categoryDTOs = new HashSet<>();

        Collection<SubcategoryDTO> firstSubcategoryDTOCollection = new HashSet<>();
        Collection<SubcategoryDTO> secondSubcategoryDTOCollection = new HashSet<>();

        SubcategoryDTO firstSubcategoryDTO = new SubcategoryDTO(
                1L,
                "Γλυκά"
        );
        SubcategoryDTO secondSubcategoryDTO = new SubcategoryDTO(
                2L,
                "Σνάκς"
        );
        SubcategoryDTO thirdSubcategoryDTO = new SubcategoryDTO(
                3L,
                "Laptop"
        );
        SubcategoryDTO fourthSubcategoryDTO = new SubcategoryDTO(
                4L,
                "Tablet"
        );

        firstSubcategoryDTOCollection.add(firstSubcategoryDTO);
        firstSubcategoryDTOCollection.add(secondSubcategoryDTO);

        secondSubcategoryDTOCollection.add(thirdSubcategoryDTO);
        secondSubcategoryDTOCollection.add(fourthSubcategoryDTO);

        CategoryDTO firstCategoryDTO = new CategoryDTO(
                1L,
                "Τρόφημα",
                firstSubcategoryDTOCollection
        );
        CategoryDTO secondCategoryDTO = new CategoryDTO(
                2L,
                "Ηλεκτρονικά",
                secondSubcategoryDTOCollection
        );

        categoryDTOs.add(firstCategoryDTO);
        categoryDTOs.add(secondCategoryDTO);

        categoriesDTO.setCategories(categoryDTOs);

        doReturn(categoriesDTO).when(categoryService).getAllCategoryDTOs();

        mockMvc.perform(get("/categories").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andExpect(jsonPath("$.categories").isArray())
                .andExpect(jsonPath("$.categories", hasSize(2)))
                .andExpect(jsonPath("$.categories[*].categoryId").exists())
                .andExpect(jsonPath("$.categories[*].description").exists())
                .andExpect(jsonPath("$.categories[*].subcategories").isArray())
                .andExpect(jsonPath("$.categories[0].subcategories", hasSize(2)))
                .andExpect(jsonPath("$.categories[1].subcategories", hasSize(2)))
                .andExpect(jsonPath("$.categories[*].subcategories[*].subcategoryId").exists())
                .andExpect(jsonPath("$.categories[*].subcategories[*].description").exists())
        ;

        verify(categoryService, times(1)).getAllCategoryDTOs();
    }
}
