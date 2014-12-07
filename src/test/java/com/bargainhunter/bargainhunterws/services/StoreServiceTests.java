package com.bargainhunter.bargainhunterws.services;

import com.bargainhunter.bargainhunterws.controllers.IStoreController;
import com.bargainhunter.bargainhunterws.models.DTOs.StoreDTO;
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
public class StoreServiceTests {
    @Mock
    private IStoreController storeController;

    @InjectMocks
    private StoreService storeService;

    private MockMvc mockMvc;

    @Before
    public void setup() throws Exception {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(storeService).build();
    }

    @Test
    public void testGetAllStoresInRadiusWithNoEntries() throws Exception {
        Collection<StoreDTO> storeDTOs = new ArrayList<>();

        doReturn(storeDTOs).when(storeController).getAllStoreDTOsInRadius(0D, 0D, 0D);

        mockMvc.perform(get("/stores?latitude=0&longitude=0&radius=0").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"));

        verify(storeController, times(1)).getAllStoreDTOsInRadius(0D, 0D, 0D);
    }

    @Test
    public void testGetAllStoresInRadiusWithTwoEntries() throws Exception {
        Collection<StoreDTO> storeDTOs = new ArrayList<>();

        StoreDTO firstStoreDTO = new StoreDTO(
                1L,
                "Masoutis",
                "Serres",
                "Miaouli",
                "4",
                41.089438,
                23.544533,
                1L
        );

        StoreDTO secondStoreDTO = new StoreDTO(
                2L,
                "Masoutis",
                "Serres",
                "Patriarxou Grigoriou Z",
                "10",
                41.086757,
                23.545687,
                1L
        );

        storeDTOs.add(firstStoreDTO);
        storeDTOs.add(secondStoreDTO);

        doReturn(storeDTOs).when(storeController).getAllStoreDTOsInRadius(0D, 0D, 0D);

        mockMvc.perform(get("/stores?latitude=0&longitude=0&radius=0").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"));

        verify(storeController, times(1)).getAllStoreDTOsInRadius(0D, 0D, 0D);
    }

    @Test
    public void testGetOneStoreByIdSuccessfully() throws Exception {
        StoreDTO storeDTO = new StoreDTO(
                1L,
                "Masoutis",
                "Serres",
                "Miaouli",
                "4",
                41.089438,
                23.544533,
                1L
        );

        doReturn(storeDTO).when(storeController).getStoreDTOById(1L);

        mockMvc.perform(get("/stores/1").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"));

        verify(storeController, times(1)).getStoreDTOById(1L);
    }

    @Test
    public void testGetOneStoreByIdUnsuccessfully() throws Exception {
        doThrow(EntityNotFoundException.class).when(storeController).getStoreDTOById(1L);

        mockMvc.perform(get("/stores/1").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());

        verify(storeController, times(1)).getStoreDTOById(1L);
    }
}
