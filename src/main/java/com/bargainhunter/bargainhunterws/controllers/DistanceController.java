package com.bargainhunter.bargainhunterws.controllers;

/**
 * Created by Tommy on 11/22/2014.
 */
public class DistanceController {
    
    /**
     * Calculates the calcDistance between two points (given the
     * latitude/longitude of those points)
     * @param lat1
     * @param lon1
     * @param lat2
     * @param lon2
     * @return
     */
    public double calcDistance(double lat1, double lon1, double lat2, double lon2) {
        double theta = lon1 - lon2;
        double dist = Math.sin(deg2rad(lat1)) * Math.sin(deg2rad(lat2)) + Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2)) * Math.cos(deg2rad(theta));
        dist = Math.acos(dist);
        dist = rad2deg(dist);
        dist = dist * 60 * 1.1515;

        return (dist);
    }

    /**
     * This function converts decimal degrees to radians
     * @param deg
     * @return
     */
    private double deg2rad(double deg) {
        return (deg * Math.PI / 180.0);
    }

    /**
     * This function converts radians to decimal degrees
     * @param rad
     * @return
     */
    private double rad2deg(double rad) {
        return (rad * 180 / Math.PI);
    }
}
