package com.flashapp.jamescollerton.flashapp.enumerators;

/**
 * Created by JamesCollerton on 18/10/2017.
 */
public enum DistanceUnit {

    METRES("metres"),
    FEET("feet");

    private final String unit;

    DistanceUnit(String unit){
        this.unit = unit;
    }

    public String toString(){
        return unit;
    }

}
