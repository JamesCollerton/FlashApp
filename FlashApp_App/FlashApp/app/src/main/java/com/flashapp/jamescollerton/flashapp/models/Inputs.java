package com.flashapp.jamescollerton.flashapp.models;

/**
 * Created by JamesCollerton on 27/09/2017.
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
