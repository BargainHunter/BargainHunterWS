package com.bargainhunter.bargainhunterws.models.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "BRANCH")
public class Branch {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "branch_id")
    private Long branchId;

    @Column(name = "branch_name")
    private String branchName;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id")
    private Company company;

    @OneToMany(mappedBy = "branch", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Store> stores;

    @OneToMany(mappedBy = "branch", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Offer> offers;

    {
        stores = new HashSet<>();
        offers = new HashSet<>();
    }

    public Branch() {
    }

    public Branch(String branchName, Company company, Set<Store> stores, Set<Offer> offers) {
        this.branchName = branchName;
        this.company = company;
        this.stores = stores;
        this.offers = offers;
    }

    public Long getBranchId() {
        return branchId;
    }

    public String getBranchName() {
        return branchName;
    }

    public Company getCompany() {
        return company;
    }

    public Set<Store> getStores() {
        return stores;
    }

    public Set<Offer> getOffers() {
        return offers;
    }

    public void setStores(Set<Store> stores) {
        this.stores = stores;
    }

    public void setOffers(Set<Offer> offers) {
        this.offers = offers;
    }
}
