package com.bargainhunter.bargainhunterws.models.DTOs;

public class OfferDTO {
    private Long offerId;
    private String title;
    private String description;
    private double price;
    private Long companyId;
    private String subcategoryDescription;

    public OfferDTO() {}

    public OfferDTO(Long offerId, String title, String description, double price, Long companyId, String subcategoryDescription) {
        this.offerId = offerId;
        this.title = title;
        this.description = description;
        this.price = price;
        this.companyId = companyId;
        this.subcategoryDescription = subcategoryDescription;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public String getSubcategoryDescription() {
        return subcategoryDescription;
    }

    public void setSubcategoryDescription(String subcategoryDescription) {
        this.subcategoryDescription = subcategoryDescription;
    }
}
