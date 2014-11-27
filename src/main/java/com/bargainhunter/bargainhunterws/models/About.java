package com.bargainhunter.bargainhunterws.models;

/**
 * Created by Achilleas Naoumidis on 11/26/14.
 */
public class About {
    private String name;
    private String version;

    public About(String version) {
        this.name = "Bargain Hunter WS";
        this.version = version;
    }

    public About(String name, String version) {
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
