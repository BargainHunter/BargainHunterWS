package com.bargainhunter.bargainhunterws.models.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "SUBCATEGORY")
public class Subcategory implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "subcategory_id")
    private Long subcategoryId;

    @Column(name = "description")
    private String description;

    @OneToMany(mappedBy = "subcategory", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Offer> offers;

    {
        offers = new HashSet<>();
    }

    public Subcategory() {}

    public Subcategory(String description) {
        this.description = description;
    }

    public Long getSubcategoryId() {
        return subcategoryId;
    }

    public String getDescription() {
        return description;
    }

    public Set<Offer> getOffers() {
        return offers;
    }

    public void setOffers(Set<Offer> offers) {
        this.offers = offers;
    }
}