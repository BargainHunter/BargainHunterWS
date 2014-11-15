package com.bargainhunter.bargainhunterws.models.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;

/**
 * Created by Tommy on 11/9/2014.
 */
@Entity
// @JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, scope = Store.class)
public class Store {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long storeId;
    private String country;
    private String city;
    private String address;
    private String addressNo;
    private double latitude;
    private double longitude;
    private String zip;
    @OneToMany(mappedBy = "store", fetch = FetchType.LAZY)
    @JsonManagedReference
    private Collection<Offer> offers;

    {
        offers = new HashSet<>();
    }

    protected Store() {}

    public Store(String country, String city,  String address, String addressNo, String zip, double latitude, double longitude) {
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

    public Collection<Offer> getOffers() {
        return offers;
    }

    public void setOffers(Collection<Offer> offers) {
        this.offers = offers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Store)) return false;

        Store store = (Store) o;

        if (!addressNo.equals(store.addressNo)) return false;
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
        result = 31 * result + addressNo.hashCode();
        temp = Double.doubleToLongBits(latitude);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(longitude);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + zip.hashCode();
        return result;
    }
}