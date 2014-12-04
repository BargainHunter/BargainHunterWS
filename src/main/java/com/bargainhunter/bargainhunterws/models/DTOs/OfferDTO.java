package com.bargainhunter.bargainhunterws.models.DTOs;

import java.util.Collection;

public class OfferDTO {
    private Long offerId;
    private String title;
    private String description;
    private Double price;
    private Double oldPrice;
    private Long branchId;
    private Collection<SubcategoryDTO> subcategories;

    public OfferDTO() {}

    public OfferDTO(Long offerId, String title, String description, Double price, Double oldPrice, Long branchId, Collection<SubcategoryDTO> subcategories) {
        this.offerId = offerId;
        this.title = title;
        this.description = description;
        this.price = price;
        this.oldPrice = oldPrice;
        this.branchId = branchId;
        this.subcategories = subcategories;
    }

    public Long getOfferId() {
        return offerId;
    }

    public void setOfferId(Long offerId) {
        this.offerId = offerId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getOldPrice() {
        return oldPrice;
    }

    public void setOldPrice(Double oldPrice) {
        this.oldPrice = oldPrice;
    }

    public Long getBranchId() {
        return branchId;
    }

    public void setBranchId(Long branchId) {
        this.branchId = branchId;
    }

    public Collection<SubcategoryDTO> getSubcategories() {
        return subcategories;
    }

    public void setSubcategories(Collection<SubcategoryDTO> subcategories) {
        this.subcategories = subcategories;
    }
}
