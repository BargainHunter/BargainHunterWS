package com.bargainhunter.bargainhunterws.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tommy on 11/9/2014.
 */
@Entity
public class Store {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long storeId;
    private String country;
    private String city;
    private String address;
    private int addressNo;
    private double latitude;
    private double longitude;
    private String zip;
    @OneToMany(mappedBy = "store", cascade = CascadeType.ALL)
    private List<Offer> offers;

    {
        offers = new ArrayList<>();
    }

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

    public Long getStoreId() {
        return storeId;
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

    public List<Offer> getOffers() {
        return offers;
    }

    public void setOffers(List<Offer> offers) {
        this.offers = offers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Store)) return false;

        Store store = (Store) o;

        if (addressNo != store.addressNo) return false;
        if (Double.compare(store.latitude, latitude) != 0) return false;
        if (Double.compare(store.longitude, longitude) != 0) return false;
        if (!address.equals(store.address)) return false;
        if (!city.equals(store.city)) return false;
        if (!country.equals(store.country)) return false;
        if (!storeId.equals(store.storeId)) return false;
        if (!zip.equals(store.zip)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = storeId.hashCode();
        result = 31 * result + country.hashCode();
        result = 31 * result + city.hashCode();
        result = 31 * result + address.hashCode();
        result = 31 * result + addressNo;
        temp = Double.doubleToLongBits(latitude);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(longitude);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + zip.hashCode();
        return result;
    }
}