package com.bargainhunter.bargainhunterws.models.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "OFFER")
public class Offer implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "offer_id")
    private Long offerId;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "price")
    private double price;

    @Column(name = "start_date")
    private Date startDate;

    @Column(name = "exp_date")
    private Date expDate;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id")
    private Company company;

    @ManyToMany
    @JoinTable(name="OFFER_SUBCATEGORY",
            joinColumns=
            @JoinColumn(name="offer_id", referencedColumnName="offer_id"),
            inverseJoinColumns=
            @JoinColumn(name="subcategory_id", referencedColumnName="subcategory_id")
    )
    public Set<Subcategory> subcategories;

    protected Offer() {}

    public Offer(String title, String description, double price, Date startDate, Date expDate, Company company) {
        this.title = title;
        this.description = description;
        this.price = price;
        this.startDate = startDate;
        this.expDate = expDate;
        this.company = company;
    }

    public Offer(String title, String description, double price, Date startDate, Date expDate, Company company, Set<Subcategory> subcategories) {
        this.title = title;
        this.description = description;
        this.price = price;
        this.startDate = startDate;
        this.expDate = expDate;
        this.company = company;
        this.subcategories = subcategories;
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

    public Set<Subcategory> getSubcategories() {
        return subcategories;
    }
}
