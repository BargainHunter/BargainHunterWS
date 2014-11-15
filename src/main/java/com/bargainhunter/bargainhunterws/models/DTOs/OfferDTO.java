package com.bargainhunter.bargainhunterws.models.DTOs;

/**
 * Created by Achilleas Naoumidis on 11/15/14.
 */
public class OfferDTO {
    private Long offerId;
    private String title;
    private String description;
    private double price;
    private Long storeId;

    public OfferDTO() {}

    public OfferDTO(Long offerId, String title, String description, double price, Long storeId) {
        this.offerId = offerId;
        this.title = title;
        this.description = description;
        this.price = price;
        this.storeId = storeId;
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

    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }
}
