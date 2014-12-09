package com.bargainhunter.bargainhunterws.services;

import com.bargainhunter.bargainhunterws.controllers.OfferController;
import com.bargainhunter.bargainhunterws.models.DTOs.entityDTOs.OfferDTO;
import com.bargainhunter.bargainhunterws.models.DTOs.entityDTOs.SubcategoryDTO;
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
import java.util.Collection;
import java.util.HashSet;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:META-INF/testContext.xml",
        loader = SpringApplicationContextLoader.class)
@WebAppConfiguration
public class OfferServiceTests {
    @Mock
    private OfferController offerController;

    @InjectMocks
    private OfferService offerService;

    private MockMvc mockMvc;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(offerService).build();
    }

    @Test
    public void testGetAllOfferFromStoreByIdSuccessfullyWithTwoEntries() throws Exception {
        Collection<OfferDTO> offers = new HashSet<>();
        Collection<SubcategoryDTO> subcategories = new HashSet<>();

        SubcategoryDTO firstSubcategory = new SubcategoryDTO(1L, "Sweets", 1L);
        subcategories.add(firstSubcategory);
        Collection<SubcategoryDTO> sweetSubcategory = subcategories;
        SubcategoryDTO secondSubcategory = new SubcategoryDTO(2L, "Snacks", 1L);
        subcategories.add(secondSubcategory);
        Collection<SubcategoryDTO> sweetAndSnackSubcategory = subcategories;

        OfferDTO firstOffer = new OfferDTO(1L,
                "Chocolate",
                "Chocolate in half price",
                1.20,
                2.40,
                1L,
                sweetSubcategory);
        offers.add(firstOffer);

        OfferDTO secondOffer = new OfferDTO(2L,
                "Croissant",
                "Croissant in half price",
                0.70,
                1.40,
                1L,
                sweetAndSnackSubcategory);
        offers.add(secondOffer);

        doReturn(offers).when(offerController).getAllOfferDTOsFromStoreById(1L);

        mockMvc.perform(get("/stores/1/offers").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andExpect(jsonPath(".offerId").exists())
                .andExpect(jsonPath(".title").exists())
                .andExpect(jsonPath(".description").exists())
                .andExpect(jsonPath(".price").exists())
                .andExpect(jsonPath(".oldPrice").exists())
                .andExpect(jsonPath(".branchId").exists())
                .andExpect(jsonPath(".subcategories.subcategoryId").exists())
                .andExpect(jsonPath(".subcategories.description").exists())
                .andExpect(jsonPath(".subcategories.categoryId").exists());

        verify(offerController, times(1)).getAllOfferDTOsFromStoreById(1L);
    }

    @Test
    public void testGetAllOfferDTOsFromStoreByIdUnsyccessfully() throws Exception {
        doThrow(EntityNotFoundException.class).when(offerController).getAllOfferDTOsFromStoreById(1L);

        mockMvc.perform(get("/stores/1/offers").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());

        verify(offerController, times(1)).getAllOfferDTOsFromStoreById(1L);
    }

    @Test
    public void testGetAllOffersSuccessfullyWithEntries() throws Exception {
        Collection<OfferDTO> offers = new HashSet<>();
        Collection<SubcategoryDTO> subcategories = new HashSet<>();

        SubcategoryDTO firstSubcategory = new SubcategoryDTO(1L, "Sweets", 1L);
        subcategories.add(firstSubcategory);
        Collection<SubcategoryDTO> sweetSubcategory = subcategories;
        SubcategoryDTO secondSubcategory = new SubcategoryDTO(2L, "Snacks", 1L);
        subcategories.add(secondSubcategory);
        Collection<SubcategoryDTO> sweetAndSnackSubcategory = subcategories;

        OfferDTO firstOffer = new OfferDTO(1L,
                "Chocolate",
                "Chocolate in half price",
                1.20,
                2.40,
                1L,
                sweetSubcategory);
        offers.add(firstOffer);

        OfferDTO secondOffer = new OfferDTO(2L,
                "Croissant",
                "Croissant in half price",
                0.70,
                1.40,
                1L,
                sweetAndSnackSubcategory);
        offers.add(secondOffer);

        doReturn(offers).when(offerController).getAllOfferDTOs();

        mockMvc.perform(get("/offers").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andExpect(jsonPath(".offerId").exists())
                .andExpect(jsonPath(".title").exists())
                .andExpect(jsonPath(".description").exists())
                .andExpect(jsonPath(".price").exists())
                .andExpect(jsonPath(".oldPrice").exists())
                .andExpect(jsonPath(".branchId").exists())
                .andExpect(jsonPath(".subcategories.subcategoryId").exists())
                .andExpect(jsonPath(".subcategories.description").exists())
                .andExpect(jsonPath(".subcategories.categoryId").exists());

        verify(offerController, times(1)).getAllOfferDTOs();
    }

    @Test
    public void testGetAllOffersSuccessfullyWithoutEntries() throws Exception {
        Collection<OfferDTO> offers = new HashSet<>();

        doReturn(offers).when(offerController).getAllOfferDTOs();

        mockMvc.perform(get("/offers").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"));

        verify(offerController, times(1)).getAllOfferDTOs();
    }

    @Test
    public void testGetOneOfferByIdSuccessfully() throws Exception {
        Collection<SubcategoryDTO> subcategories = new HashSet<>();

        SubcategoryDTO firstSubcategory = new SubcategoryDTO(1L, "Sweets", 1L);
        subcategories.add(firstSubcategory);
        SubcategoryDTO secondSubcategory = new SubcategoryDTO(2L, "Snacks", 1L);
        subcategories.add(secondSubcategory);

        OfferDTO offer = new OfferDTO(1L,
                "Chocolate",
                "Chocolate in half price",
                1.20,
                2.40,
                1L,
                subcategories);

        doReturn(offer).when(offerController).getOfferDTOById(1L);

        mockMvc.perform(get("/offers/1").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andExpect(jsonPath(".offerId").exists())
                .andExpect(jsonPath(".title").exists())
                .andExpect(jsonPath(".description").exists())
                .andExpect(jsonPath(".price").exists())
                .andExpect(jsonPath(".oldPrice").exists())
                .andExpect(jsonPath(".branchId").exists())
                .andExpect(jsonPath(".subcategories.subcategoryId").exists())
                .andExpect(jsonPath(".subcategories.description").exists())
                .andExpect(jsonPath(".subcategories.categoryId").exists());

        verify(offerController, times(1)).getOfferDTOById(1L);
    }

    @Test
    public void testGetOneOfferByIdUnsuccessfully() throws Exception {
        doThrow(EntityNotFoundException.class).when(offerController).getOfferDTOById(1L);

        mockMvc.perform(get("/offers/1").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());

        verify(offerController, times(1)).getOfferDTOById(1L);
    }
}
