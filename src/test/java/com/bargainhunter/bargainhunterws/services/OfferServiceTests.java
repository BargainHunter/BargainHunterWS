package com.bargainhunter.bargainhunterws.services;

import com.bargainhunter.bargainhunterws.controllers.OfferController;
import com.bargainhunter.bargainhunterws.models.DTOs.OfferDTO;
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

import java.util.Collection;
import java.util.HashSet;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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
        // this must be called for the @Mock annotations above to be processed
        // and for the mock service to be injected into the controller under
        // test.
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(offerService).build();
    }

    @Test
    public void testGetAllOfferDTOsFromStoreByIdTwoObjects() throws Exception {
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
                .andExpect(content().contentType("application/json;charset=UTF-8"));

        verify(offerController, times(1)).getAllOfferDTOsFromStoreById(1L);
    }
}
