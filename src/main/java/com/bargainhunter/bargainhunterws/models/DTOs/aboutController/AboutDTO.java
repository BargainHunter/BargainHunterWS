package com.bargainhunter.bargainhunterws.models.DTOs.aboutController;

import java.io.Serializable;

public class AboutDTO implements Serializable {
    private String name;
    private String version;
    private String apiVersion;

    public AboutDTO() {
    }

    public AboutDTO(String name, String version, String apiVersion) {
        this.name = name;
        this.version = version;
        this.apiVersion = apiVersion;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getApiVersion() {
        return apiVersion;
    }

    public void setApiVersion(String apiVersion) {
        this.apiVersion = apiVersion;
    }
}
