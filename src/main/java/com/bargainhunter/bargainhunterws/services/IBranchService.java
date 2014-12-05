package com.bargainhunter.bargainhunterws.services;

import com.bargainhunter.bargainhunterws.models.DTOs.BranchDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Collection;

public interface IBranchService {
    @RequestMapping(value = "/branches", method = RequestMethod.GET)
    public ResponseEntity<Collection<BranchDTO>> getAllBranches();
}
