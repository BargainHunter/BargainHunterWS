package com.bargainhunter.bargainhunterws.models.entities;

import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;

/**
 * Created by Achilleas Naoumidis on 11/15/14.
 */
@Entity
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long companyId;

    private String companyName;
    private String country;
    private String city;
    private String address;
    private String addressNo;
    private String zip;

    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Collection<Store> stores;

    {
        stores = new HashSet<>();
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

    public void setStores(Collection<Store> stores) {
        this.stores = stores;
    }
}
