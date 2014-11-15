package com.bargainhunter.bargainhunterws.models.entities;

import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;

/**
 * Created by Tommy on 11/9/2014.
 */
@Entity
public class Store {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long storeId;

    private String storeName;
    private String country;
    private String city;
    private String address;
    private String addressNo;
    private double latitude;
    private double longitude;
    private String zip;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id")
    private Company company;

    protected Store() {}

    public Store(String storeName, String country, String city, String address, String addressNo, String zip, double latitude, double longitude, Company company) {
        this.addressNo = addressNo;
        this.address = address;
        this.latitude = latitude;
        this.longitude = longitude;
        this.city = city;
        this.country = country;
        this.storeName = storeName;
        this.zip = zip;
        this.company = company;
    }

    public String getStoreName() {
        return storeName;
    }

    public String getCity() {
        return city;
    }

    public Long getStoreId() {
        return storeId;
    }

    public String getAddress() {
        return address;
    }

    public String getAddressNo() {
        return addressNo;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public String getCountry() {
        return country;
    }

    public String getZip() {
        return zip;
    }

    public Company getCompany() {
        return company;
    }
}