package com.bargainhunter.bargainhunterws.services;

import com.bargainhunter.bargainhunterws.models.DTOs.entityDTOs.BranchDTO;
import org.springframework.http.ResponseEntity;

import java.util.Collection;

public interface IBranchService {
    ResponseEntity<Collection<BranchDTO>> getAllBranches();
}
