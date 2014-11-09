package com.bargainhunter.bargainhunterws.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by Tommy on 11/9/2014.
 */
@Entity
public class Store {

    @Id
    @GeneratedValue
    private Long id;
    private String country;
    private String city;
    private String address;
    private int addressNo;
    private double latitude;
    private double longitude;


    private String zip;

    protected Store() {}

    public Store(String country, String city,  String address, int addressNo, String zip, double latitude, double longitude) {
        this.addressNo = addressNo;
        this.address = address;
        this.latitude = latitude;
        this.longitude = longitude;
        this.city = city;
        this.country = country;
        this.zip = zip;
    }

    public String getCity() {
        return city;
    }

    public Long getId() {
        return id;
    }

    public String getAddress() {
        return address;
    }

    public int getAddressNo() {
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
}