package com.bargainhunter.bargainhunterws.services;

import com.bargainhunter.bargainhunterws.controllers.IBranchController;
import com.bargainhunter.bargainhunterws.models.DTOs.entityDTOs.BranchDTO;
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

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
        locations = "classpath:META-INF/testContext.xml",
        loader = SpringApplicationContextLoader.class)
public class BranchServiceTests {
    @Mock
    private IBranchController branchController;

    @InjectMocks
    private BranchService branchService;

    private MockMvc mockMvc;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(branchService).build();
    }

    @Test
    public void testGetAllBranchesWithNoEntries() throws Exception {
        Collection<BranchDTO> branchDTOs = new HashSet<>();

        doReturn(branchDTOs).when(branchController).getAllBranchDTOs();

        mockMvc.perform(get("/branches").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"));

        verify(branchController, times(1)).getAllBranchDTOs();
    }

    @Test
    public void testGetAllBranchesWithTwoEntries() throws Exception {
        Collection<BranchDTO> branchDTOs = new HashSet<>();

        BranchDTO firstBranchDTO = new BranchDTO(1L, "Masoutis");
        branchDTOs.add(firstBranchDTO);

        BranchDTO secondBranchDTO = new BranchDTO(2L, "Gatidis");
        branchDTOs.add(secondBranchDTO);

        doReturn(branchDTOs).when(branchController).getAllBranchDTOs();

        mockMvc.perform(get("/branches").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"));

        verify(branchController, times(1)).getAllBranchDTOs();
    }
}
