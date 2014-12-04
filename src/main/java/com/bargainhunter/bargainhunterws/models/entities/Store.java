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

    @Column(name = "country")
    private String country;

    @Column(name = "city")
    private String city;

    @Column(name = "address")
    private String address;

    @Column(name = "address_no")
    private String addressNo;

    @Column(name = "latitude")
    private Double latitude;

    @Column(name = "longitude")
    private Double longitude;

    @Column(name = "zip")
    private String zip;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "branch_id")
    private Branch branch;

    protected Store() {}

    public Store(String country, String city, String address, String addressNo, String zip, Double latitude, Double longitude, Branch branch) {
        this.addressNo = addressNo;
        this.address = address;
        this.latitude = latitude;
        this.longitude = longitude;
        this.city = city;
        this.country = country;
        this.zip = zip;
        this.branch = branch;
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

    public Double getLatitude() {
        return latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public String getCountry() {
        return country;
    }

    public String getZip() {
        return zip;
    }

    public Branch getBranch() {
        return branch;
    }
}