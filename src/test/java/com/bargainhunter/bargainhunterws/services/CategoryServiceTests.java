package com.bargainhunter.bargainhunterws.services;

import com.bargainhunter.bargainhunterws.controllers.CategoryController;
import com.bargainhunter.bargainhunterws.models.DTOs.CategoryDTO;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.SpringApplicationContextLoader;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Collection;
import java.util.HashSet;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:META-INF/testContext.xml",
        loader = SpringApplicationContextLoader.class)
public class CategoryServiceTests {
    @Mock
    private CategoryController categoryController;

    @InjectMocks
    private CategoryService categoryService;

    private MockMvc mockMvc;

    @Before
    public void setup() {
        // this must be called for the @Mock annotations above to be processed
        // and for the mock service to be injected into the controller under
        // test.
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(categoryService).build();
    }

    @Test
    public void testGetAllCategoryDTOsWithTwoObjects() throws Exception {
        Collection<CategoryDTO> categories = new HashSet<>();

        CategoryDTO first = new CategoryDTO(1L, "Food");
        categories.add(first);

        CategoryDTO second = new CategoryDTO(2L, "Drinks");
        categories.add(second);

        doReturn(categories).when(categoryController).getAllCategoryDTOs();

        mockMvc.perform(get("/categories"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andExpect(jsonPath(".categoryId").exists())
                .andExpect(jsonPath(".description").exists());

        verify(categoryController, times(1)).getAllCategoryDTOs();
    }
}