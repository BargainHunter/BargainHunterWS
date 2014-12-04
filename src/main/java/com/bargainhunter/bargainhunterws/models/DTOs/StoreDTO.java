package com.bargainhunter.bargainhunterws.models.DTOs;

public class StoreDTO {
    private Long storeId;
    private String storeName;
    private String city;
    private String address;
    private String addressNo;
    private Double latitude;
    private Double longitude;
    private Long branchId;

    public StoreDTO() {}

    public StoreDTO(Long storeId, String storeName, String city, String address, String addressNo, Double latitude, Double longitude, Long branchId) {
        this.storeId = storeId;
        this.storeName = storeName;
        this.city = city;
        this.address = address;
        this.addressNo = addressNo;
        this.latitude = latitude;
        this.longitude = longitude;
        this.branchId = branchId;
    }

    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddressNo() {
        return addressNo;
    }

    public void setAddressNo(String addressNo) {
        this.addressNo = addressNo;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Long getBranchId() {
        return branchId;
    }

    public void setBranchId(Long branchId) {
        this.branchId = branchId;
    }
}
