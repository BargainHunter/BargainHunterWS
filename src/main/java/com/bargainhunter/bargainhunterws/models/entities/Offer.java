package com.bargainhunter.bargainhunterws.models.entities;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Johnny on 11/11/14.
 */
@Entity
public class Offer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long offerId;
    private String title;
    private String description;
    private double price;
    private Date startDate;
    private Date expDate;
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "store_id")
    private Store store;

    protected Offer() {}

    public Offer(String title, String description, double price, Date startDate, Date expDate) {
        this.title = title;
        this.description = description;
        this.price = price;
        this.startDate = startDate;
        this.expDate = expDate;
    }

    public String getTitle() {
        return title;
    }

    public Long getOfferId() {
        return offerId;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getExpDate() {
        return expDate;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Offer)) return false;

        Offer offer = (Offer) o;

        if (Double.compare(offer.price, price) != 0) return false;
        if (!description.equals(offer.description)) return false;
        if (!expDate.equals(offer.expDate)) return false;
        if (!offerId.equals(offer.offerId)) return false;
        if (!startDate.equals(offer.startDate)) return false;
        if (!title.equals(offer.title)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = offerId.hashCode();
        result = 31 * result + title.hashCode();
        result = 31 * result + description.hashCode();
        temp = Double.doubleToLongBits(price);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + startDate.hashCode();
        result = 31 * result + expDate.hashCode();
        return result;
    }
}
