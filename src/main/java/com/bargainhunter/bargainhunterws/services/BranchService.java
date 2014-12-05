package com.bargainhunter.bargainhunterws.services;

import com.bargainhunter.bargainhunterws.controllers.IBranchController;
import com.bargainhunter.bargainhunterws.models.DTOs.BranchDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
public class BranchService implements IBranchService {
    @Autowired
    IBranchController branchController;

    @Override
    @RequestMapping(value = "/branches", method = RequestMethod.GET)
    public ResponseEntity<Collection<BranchDTO>> getAllBranches() {
        HttpHeaders headers = new HttpHeaders();

        headers.add("Content-Type", "application/json;charset=UTF-8");

        Collection<BranchDTO> categoryDTOs = branchController.getAllBranchDTOs();

        return new ResponseEntity<>(categoryDTOs, headers, HttpStatus.OK);
    }
}
