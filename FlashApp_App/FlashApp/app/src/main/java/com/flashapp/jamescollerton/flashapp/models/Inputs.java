package com.flashapp.jamescollerton.flashapp.models;

/**
 * This is essentially a model which has values for each of the different things we can enter in
 * the UI. It is used to store the inputs on a screen whenever we press one of the buttons.
 */
public class Inputs {

    private Integer guideNumber;
    private Integer ISO;
    private Integer power;
    private Float distance;
    private Float aperture;

    public Inputs(Integer guideNumber, Integer ISO, Integer power, Float distance, Float aperture){
        this.guideNumber = guideNumber;
        this.ISO = ISO;
        this.power = power;
        this.distance = distance;
        this.aperture = aperture;
    }

    public Integer getGuideNumber() {
        return guideNumber;
    }

    public Integer getISO() {
        return ISO;
    }

    public Integer getPower() {
        return power;
    }

    public Float getDistance() {
        return distance;
    }

    public Float getAperture() {
        return aperture;
    }

    public void setGuideNumber(Integer guideNumber) { this.guideNumber = guideNumber; }

    public void setISO(Integer ISO) {
        this.ISO = ISO;
    }

    public void setPower(Integer power) {
        this.power = power;
    }

    public void setDistance(Float distance) {
        this.distance = distance;
    }

    public void setAperture(Float aperture) {
        this.aperture = aperture;
    }
}
