package com.flashapp.jamescollerton.flashapp.enumerators;

/**
 * Created by JamesCollerton on 18/10/2017.
 */
public enum DistanceUnit {

    METRES("metres", new Float(1)),
    FEET("feet", new Float(3.28084));

    private final String unit;
    private final Float conversionUnit;

    DistanceUnit(String unit, Float conversionUnit){
        this.unit = unit;
        this.conversionUnit = conversionUnit;
    }

    public Float getConversionUnit(){
        return conversionUnit;
    }

    public String toString(){
        return unit;
    }

}
