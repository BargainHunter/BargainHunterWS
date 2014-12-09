package com.bargainhunter.bargainhunterws.controllers;

import com.bargainhunter.bargainhunterws.models.DTOs.entityDTOs.BranchDTO;

import java.util.Collection;

public interface IBranchController {
    public Collection<BranchDTO> getAllBranchDTOs();
}
