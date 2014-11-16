package com.bargainhunter.bargainhunterws.models.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;

/**
 * Created by Achilleas Naoumidis on 11/15/14.
 */
@Entity
@Table(name = "COMPANY")
public class Company implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "company_id")
    private Long companyId;

    @Column(name = "company_name")
    private String companyName;

    @Column(name = "country")
    private String country;

    @Column(name = "city")
    private String city;

    @Column(name = "address")
    private String address;

    @Column(name = "address_no")
    private String addressNo;

    @Column(name = "zip")
    private String zip;

    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Collection<Store> stores;

    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Collection<Offer> offers;

    {
        stores = new HashSet<>();
        offers = new HashSet<>();
    }

    public Company() {}

    public Company(String companyName, String country, String city, String address, String addressNo, String zip) {
        this.companyName = companyName;
        this.country = country;
        this.city = city;
        this.address = address;
        this.addressNo = addressNo;
        this.zip = zip;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getCountry() {
        return country;
    }

    public String getCity() {
        return city;
    }

    public String getAddress() {
        return address;
    }

    public String getAddressNo() {
        return addressNo;
    }

    public String getZip() {
        return zip;
    }

    public Collection<Store> getStores() {
        return stores;
    }

    public Collection<Offer> getOffers() {
        return offers;
    }

    public void setOffers(Collection<Offer> offers) {
        this.offers = offers;
    }

    public void setStores(Collection<Store> stores) {
        this.stores = stores;
    }
}
