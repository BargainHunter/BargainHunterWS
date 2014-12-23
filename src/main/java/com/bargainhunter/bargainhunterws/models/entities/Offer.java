package com.bargainhunter.bargainhunterws.models.entities;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Set;

@Entity
@Table(name = "OFFER")
public class Offer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "offer_id")
    private Long offerId;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "price")
    private Double price;

    @Column(name = "old_price")
    private Double oldPrice;

    @Column(name = "start_date")
    private Calendar startDate;

    @Column(name = "exp_date")
    private Calendar expDate;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "branch_id")
    private Branch branch;

    @ManyToMany
    @JoinTable(name="OFFER_SUBCATEGORY",
            joinColumns=
            @JoinColumn(name="offer_id", referencedColumnName="offer_id"),
            inverseJoinColumns=
            @JoinColumn(name="subcategory_id", referencedColumnName="subcategory_id")
    )
    private Set<Subcategory> subcategories;

    public Offer() {
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

    public Calendar getStartDate() {
        return startDate;
    }

    public void setStartDate(Calendar startDate) {
        this.startDate = startDate;
    }

    public Calendar getExpDate() {
        return expDate;
    }

    public void setExpDate(Calendar expDate) {
        this.expDate = expDate;
    }

    public Branch getBranch() {
        return branch;
    }

    public void setBranch(Branch branch) {
        this.branch = branch;
    }

    public Set<Subcategory> getSubcategories() {
        return subcategories;
    }

    public void setSubcategories(Set<Subcategory> subcategories) {
        this.subcategories = subcategories;
    }
}
