package com.bargainhunter.bargainhunterws.models.DTOs.searchService;

import java.io.Serializable;
import java.util.Collection;

public class SearchInRadiusDTO implements Serializable {
    private Double latitude;
    private Double longitude;
    private Double radius;

    private Collection<BranchDTO> branches;

    public SearchInRadiusDTO() {}

    public SearchInRadiusDTO(Double latitude, Double longitude, Double radius, Collection<BranchDTO> branches) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.radius = radius;
        this.branches = branches;
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

    public Double getRadius() {
        return radius;
    }

    public void setRadius(Double radius) {
        this.radius = radius;
    }

    public Collection<BranchDTO> getBranches() {
        return branches;
    }

    public void setBranches(Collection<BranchDTO> branches) {
        this.branches = branches;
    }
}
