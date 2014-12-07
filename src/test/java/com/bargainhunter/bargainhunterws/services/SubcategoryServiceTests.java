package com.bargainhunter.bargainhunterws.services;

import com.bargainhunter.bargainhunterws.controllers.ISubcategoryController;
import com.bargainhunter.bargainhunterws.models.DTOs.SubcategoryDTO;
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
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.Collection;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
        locations = "classpath:META-INF/testContext.xml",
        loader = SpringApplicationContextLoader.class)
@WebAppConfiguration
public class SubcategoryServiceTests {
    @Mock
    private ISubcategoryController subcategoryController;

    @InjectMocks
    private SubcategoryService subcategoryService;

    private MockMvc mockMvc;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(subcategoryService).build();
    }

    @Test
    public void testGetAllSubcategoriesWithNoEntries() throws Exception {
        Collection<SubcategoryDTO> subcategoryDTOs = new ArrayList<>();

        doReturn(subcategoryDTOs).when(subcategoryController).getAllSubcategoryDTOs();

        mockMvc.perform(get("/subcategories").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"));

        verify(subcategoryController, times(1)).getAllSubcategoryDTOs();
    }

    @Test
    public void testGetAllSubcategoriesWithTwoEntries() throws Exception {
        Collection<SubcategoryDTO> subcategoryDTOs = new ArrayList<>();

        SubcategoryDTO firstSubcategoryDTO = new SubcategoryDTO(
                1L,
                "Γλυκά",
                1L
        );

        SubcategoryDTO secondSubcategoryDTO = new SubcategoryDTO(
                1L,
                "Σνάκς",
                1L
        );

        subcategoryDTOs.add(firstSubcategoryDTO);
        subcategoryDTOs.add(secondSubcategoryDTO);

        doReturn(subcategoryDTOs).when(subcategoryController).getAllSubcategoryDTOs();

        mockMvc.perform(get("/subcategories").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"));

        verify(subcategoryController, times(1)).getAllSubcategoryDTOs();
    }

    @Test
    public void testGetAllSubcategoriesFromCategoryByIdSuccessfully() throws Exception {
        Collection<SubcategoryDTO> subcategoryDTOs = new ArrayList<>();

        SubcategoryDTO firstSubcategoryDTO = new SubcategoryDTO(
                1L,
                "Γλυκά",
                1L
        );

        SubcategoryDTO secondSubcategoryDTO = new SubcategoryDTO(
                1L,
                "Σνάκς",
                1L
        );

        subcategoryDTOs.add(firstSubcategoryDTO);
        subcategoryDTOs.add(secondSubcategoryDTO);

        doReturn(subcategoryDTOs).when(subcategoryController).getAllSubcategoryDTOsFromCategoryById(1L);

        mockMvc.perform(get("/categories/1/subcategories").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"));

        verify(subcategoryController, times(1)).getAllSubcategoryDTOsFromCategoryById(1L);
    }

    @Test
    public void testGetAllSubcategoriesFromCategoryByIdUnsuccessfully() throws Exception {
        doThrow(EntityNotFoundException.class).when(subcategoryController).getAllSubcategoryDTOsFromCategoryById(1L);

        mockMvc.perform(get("/categories/1/subcategories").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());

        verify(subcategoryController, times(1)).getAllSubcategoryDTOsFromCategoryById(1L);
    }
}
