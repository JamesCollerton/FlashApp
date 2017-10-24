package com.flashapp.jamescollerton.flashapp.enumerators;

/**
 * This is used to hold all of the different distance units we can have
 */
public enum DistanceUnit {

    METRES("metres", new Float(1)),
    FEET("feet", new Float(3.28084));

    /**
     * The unit is the string representing how the unit will be displayed. The conversion unit is
     * how we convert from metres to that unit via multiplication.
     */
    private final String unit;
    private final Float conversionUnit;

    DistanceUnit(String unit, Float conversionUnit){
        this.unit = unit;
        this.conversionUnit = conversionUnit;
    }

    public Float getConversionUnit(){
        return conversionUnit;
    }

    /**
     * We override to string in order to have the unit displayed correctly in the spinner.
     *
     * @return The unit part of the data object
     */
    @Override
    public String toString(){
        return unit;
    }

}
