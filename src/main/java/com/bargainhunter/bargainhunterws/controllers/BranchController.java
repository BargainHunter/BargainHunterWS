package com.bargainhunter.bargainhunterws.controllers;

import com.bargainhunter.bargainhunterws.models.DTOs.BranchDTO;
import com.bargainhunter.bargainhunterws.models.entities.Branch;
import com.bargainhunter.bargainhunterws.repositories.IBranchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.Collection;

@Controller
public class BranchController implements IBranchController {
    @Autowired
    IBranchRepository branchRepository;

    @Override
    public Collection<BranchDTO> createDTOs(Collection<Branch> branches) {
        Collection<BranchDTO> branchDTOs = new ArrayList<>();

        for (Branch branch : branches) {
            branchDTOs.add(createDTO(branch));
        }

        return branchDTOs;
    }

    @Override
    public BranchDTO createDTO(Branch branch) {
        BranchDTO branchDTO = new BranchDTO(
                branch.getBranchId(),
                branch.getBranchName(),
                branch.getCompany().getCompanyId()
        );

        return branchDTO;
    }
}
