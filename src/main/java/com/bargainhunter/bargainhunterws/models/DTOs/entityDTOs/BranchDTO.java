package com.bargainhunter.bargainhunterws.models.DTOs.entityDTOs;

import java.io.Serializable;

public class BranchDTO implements Serializable {
    private Long branchId;
    private String branchName;

    public BranchDTO() {
    }

    public BranchDTO(Long branchId, String branchName) {
        this.branchId = branchId;
        this.branchName = branchName;
    }

    public Long getBranchId() {
        return branchId;
    }

    public void setBranchId(Long branchId) {
        this.branchId = branchId;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }
}