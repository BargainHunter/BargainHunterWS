package com.bargainhunter.bargainhunterws.models.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;

@Entity
@Table(name = "STORE")
public class Store implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "store_id")
    private Long storeId;

    @Column(name = "store_name")
    private String storeName;

    @Column(name = "country")
    private String country;

    @Column(name = "city")
    private String city;

    @Column(name = "address")
    private String address;

    @Column(name = "address_no")
    private String addressNo;

    @Column(name = "latitude")
    private double latitude;

    @Column(name = "longitude")
    private double longitude;

    @Column(name = "zip")
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