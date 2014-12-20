package com.bargainhunter.bargainhunterws.models.entities;

import org.hibernate.annotations.Type;
import org.springframework.data.geo.Point;

import javax.persistence.*;

@Entity
@Table(name = "STORE")
public class Store {
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

    @Column(name = "coordinates", columnDefinition = "Point")
    @Type(type = "com.bargainhunter.bargainhunterws.models.hibernate.PointUserType")
    private Point coordinates;

    @Column(name = "zip")
    private String zip;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "branch_id")
    private Branch branch;

    protected Store() {
    }

    public Store(String country, String city, String address, String addressNo, String zip, Point coordinates, Branch branch) {
        this.addressNo = addressNo;
        this.address = address;
        this.coordinates = coordinates;
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

    public Point getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Point coordinates) {
        this.coordinates = coordinates;
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