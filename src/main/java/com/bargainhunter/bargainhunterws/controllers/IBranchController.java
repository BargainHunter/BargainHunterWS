package com.bargainhunter.bargainhunterws.controllers;

import com.bargainhunter.bargainhunterws.models.DTOs.BranchDTO;
import com.bargainhunter.bargainhunterws.models.entities.Branch;

import java.util.Collection;

public interface IBranchController {
    public Collection<BranchDTO> createDTOs(Collection<Branch> branchs);

    public BranchDTO createDTO(Branch branch);
}
