package com.bargainhunter.bargainhunterws.models.DTOs;

public class BranchDTO {
    private Long branchId;
    private String branchName;
    private Long companyId;

    public BranchDTO() {
    }

    public BranchDTO(Long branchId, String branchName, Long companyId) {
        this.branchId = branchId;
        this.branchName = branchName;
        this.companyId = companyId;
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

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }
}