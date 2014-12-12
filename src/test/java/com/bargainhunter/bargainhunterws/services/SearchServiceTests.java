package com.bargainhunter.bargainhunterws.services;

import com.bargainhunter.bargainhunterws.controllers.ISearchController;
import com.bargainhunter.bargainhunterws.models.DTOs.searchService.*;
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

import java.util.HashSet;
import java.util.Set;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:META-INF/testContext.xml",
        loader = SpringApplicationContextLoader.class)
@WebAppConfiguration
public class SearchServiceTests {
    @Mock
    private ISearchController searchController;

    @InjectMocks
    private SearchService searchService;

    private MockMvc mockMvc;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(searchService).build();
    }

    @Test
    public void testGetAllBranchesWithStoresAndOffersInRadiusWithoutEntries() throws Exception {
        SearchInRadiusDTO searchInRadiusDTO = new SearchInRadiusDTO();

        searchInRadiusDTO.setLatitude(0D);
        searchInRadiusDTO.setLongitude(0D);
        searchInRadiusDTO.setRadius(0D);
        searchInRadiusDTO.setBranches(new HashSet<>());

        doReturn(searchInRadiusDTO).when(searchController).getAllBranchesWithStoresAndOffersInRadiusDTO(0D, 0D, 0D);

        mockMvc.perform(get("/search_in_radius?latitude=0&longitude=0&radius=0").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andExpect(jsonPath("$.latitude").exists())
                .andExpect(jsonPath("$.latitude", is(0D)))
                .andExpect(jsonPath("$.longitude").exists())
                .andExpect(jsonPath("$.longitude", is(0D)))
                .andExpect(jsonPath("$.radius").exists())
                .andExpect(jsonPath("$.radius", is(0D)))
                .andExpect(jsonPath("$.branches").isArray())
                .andExpect(jsonPath("$.branches", hasSize(0)))
        ;

        verify(searchController, times(1)).getAllBranchesWithStoresAndOffersInRadiusDTO(0D, 0D, 0D);
    }

    @Test
    public void testGetAllBranchesWithStoresAndOffersInRadiusWithOneBranchOneStoreOneOfferWithOneSubcategory() throws Exception {
        SearchInRadiusDTO searchInRadiusDTO = new SearchInRadiusDTO();

        searchInRadiusDTO.setLatitude(0D);
        searchInRadiusDTO.setLongitude(0D);
        searchInRadiusDTO.setRadius(0D);

        Set<BranchDTO> branchDTOs = new HashSet<>();
        Set<StoreDTO> storeDTOs = new HashSet<>();
        Set<OfferDTO> offerDTOs = new HashSet<>();
        Set<OfferSubcategoryDTO> offerSubcategoryDTOs = new HashSet<>();

        OfferSubcategoryDTO offerSubcategoryDTO = new OfferSubcategoryDTO(1L);

        offerSubcategoryDTOs.add(offerSubcategoryDTO);

        OfferDTO firstOffer = new OfferDTO(
                1L,
                "Chocolate",
                "Chocolate in half price",
                1.20D,
                2.40D,
                offerSubcategoryDTOs);

        offerDTOs.add(firstOffer);

        StoreDTO storeDTO = new StoreDTO(
                1L,
                "Masoutis",
                "Serres",
                "Miaouli",
                "4",
                41.089438D,
                23.544533D
        );

        storeDTOs.add(storeDTO);

        BranchDTO branchDTO = new BranchDTO(
                1L,
                storeDTOs,
                offerDTOs
        );

        branchDTOs.add(branchDTO);

        searchInRadiusDTO.setBranches(branchDTOs);

        doReturn(searchInRadiusDTO).when(searchController).getAllBranchesWithStoresAndOffersInRadiusDTO(0D, 0D, 0D);

        mockMvc.perform(get("/search_in_radius?latitude=0&longitude=0&radius=0").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andExpect(jsonPath("$.latitude").exists())
                .andExpect(jsonPath("$.latitude", is(0D)))
                .andExpect(jsonPath("$.longitude").exists())
                .andExpect(jsonPath("$.longitude", is(0D)))
                .andExpect(jsonPath("$.radius").exists())
                .andExpect(jsonPath("$.radius", is(0D)))
                .andExpect(jsonPath("$.branches").isArray())
                .andExpect(jsonPath("$.branches", hasSize(1)))
                .andExpect(jsonPath("$.branches[*].stores").isArray())
                .andExpect(jsonPath("$.branches[*].stores", hasSize(1)))
                .andExpect(jsonPath("$.branches[*].offers").isArray())
                .andExpect(jsonPath("$.branches[*].offers", hasSize(1)))
                .andExpect(jsonPath("$.branches[*].offers[*].subcategories").isArray())
                .andExpect(jsonPath("$.branches[*].offers[*].subcategories", hasSize(1)))
        ;

        verify(searchController, times(1)).getAllBranchesWithStoresAndOffersInRadiusDTO(0D, 0D, 0D);
    }
}
