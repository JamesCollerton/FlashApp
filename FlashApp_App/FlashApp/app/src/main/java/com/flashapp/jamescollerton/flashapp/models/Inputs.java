package com.flashapp.jamescollerton.flashapp.models;

/**
 * Created by JamesCollerton on 27/09/2017.
 */
public class Inputs {

    int guideNumber;
    int ISO;
    int power;
    float distance;
    float aperture;

    Inputs(int guideNumber, int ISO, int power, int distance, int aperture){
        this.guideNumber = guideNumber;
        this.ISO = ISO;
        this.power = power;
        this.distance = distance;
        this.aperture = aperture;
    }

    public int getGuideNumber() {
        return guideNumber;
    }

    public int getISO() {
        return ISO;
    }

    public int getPower() {
        return power;
    }

    public float getDistance() {
        return distance;
    }

    public float getAperture() {
        return aperture;
    }

    public void setGuideNumber(int guideNumber) {
        this.guideNumber = guideNumber;
    }

    public void setISO(int ISO) {
        this.ISO = ISO;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public void setDistance(float distance) {
        this.distance = distance;
    }

    public void setAperture(float aperture) {
        this.aperture = aperture;
    }
}
