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
    @JoinColumn(name = "company_id")
    private Company company;

    protected Offer() {}

    public Offer(String title, String description, double price, Date startDate, Date expDate, Company company) {
        this.title = title;
        this.description = description;
        this.price = price;
        this.startDate = startDate;
        this.expDate = expDate;
        this.company = company;
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

    public Company getCompany() {
        return company;
    }
}
