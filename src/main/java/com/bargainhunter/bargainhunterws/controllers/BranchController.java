package com.bargainhunter.bargainhunterws.controllers;

import com.bargainhunter.bargainhunterws.models.DTOs.entityDTOs.BranchDTO;
import com.bargainhunter.bargainhunterws.models.entities.Branch;
import com.bargainhunter.bargainhunterws.repositories.IBranchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Controller
public class BranchController implements IBranchController {
    @Autowired
    IBranchRepository branchRepository;

    @Override
    public Collection<BranchDTO> getAllBranchDTOs() {
        Collection<Branch> branches = branchRepository.findAll();

        return createBranchDTOs(branches);
    }

    public Collection<BranchDTO> createBranchDTOs(Collection<Branch> branches) {
        Set<BranchDTO> branchDTOs = new HashSet<>();

        for (Branch branch : branches) {
            branchDTOs.add(createBranchDTO(branch));
        }

        return branchDTOs;
    }

    public BranchDTO createBranchDTO(Branch branch) {
        return new BranchDTO(
                branch.getBranchId(),
                branch.getBranchName()
        );
    }
}
