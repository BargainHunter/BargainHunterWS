package com.bargainhunter.bargainhunterws.models.DTOs;

import java.io.Serializable;

public class AboutDTO implements Serializable {
    private String name;
    private String version;

    public AboutDTO(String version) {
        this.name = "Bargain Hunter WS";
        this.version = version;
    }

    public AboutDTO(String name, String version) {
        this.name = name;
        this.version = version;
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
}
