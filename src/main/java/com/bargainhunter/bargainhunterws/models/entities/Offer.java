package com.bargainhunter.bargainhunterws.models.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
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
    private Date startDate;

    @Column(name = "exp_date")
    private Date expDate;

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
    public Set<Subcategory> subcategories;

    protected Offer() {}

    public Offer(String title, String description, Double price, Double oldPrice, Date startDate, Date expDate, Branch branch, Set<Subcategory> subcategories) {
        this.title = title;
        this.description = description;
        this.price = price;
        this.oldPrice = oldPrice;
        this.startDate = startDate;
        this.expDate = expDate;
        this.branch = branch;
        this.subcategories = subcategories;
    }

    public Long getOfferId() {
        return offerId;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Double getPrice() {
        return price;
    }

    public Double getOldPrice() {
        return oldPrice;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getExpDate() {
        return expDate;
    }

    public Branch getBranch() {
        return branch;
    }

    public Set<Subcategory> getSubcategories() {
        return subcategories;
    }

    public void setSubcategories(Set<Subcategory> subcategories) {
        this.subcategories = subcategories;
    }
}
