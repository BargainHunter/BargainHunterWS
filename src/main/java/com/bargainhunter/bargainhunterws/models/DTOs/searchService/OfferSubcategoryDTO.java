package com.bargainhunter.bargainhunterws.models.DTOs.searchService;

public class OfferSubcategoryDTO {
    private Long subcategoryId;

    public OfferSubcategoryDTO() {
    }

    public OfferSubcategoryDTO(Long subcategoryId) {
        this.subcategoryId = subcategoryId;
    }

    public Long getSubcategoryId() {
        return subcategoryId;
    }

    public void setSubcategoryId(Long subcategoryId) {
        this.subcategoryId = subcategoryId;
    }
}
