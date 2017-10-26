package com.flashapp.jamescollerton.flashapp.enumerators;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by JamesCollerton on 26/10/2017.
 */
public class DistanceUnitTest {

    private void distanceUnitTest(DistanceUnit power, Float conversionUnit, String string){
        assertEquals(power.getConversionUnit(), conversionUnit);
        assertEquals(power.toString(), string);
    }

    @Test
    public void testDistanceUnitFeet(){
        distanceUnitTest(DistanceUnit.FEET, new Float(3.28084), "feet");
    }

    @Test
    public void testDistanceUnitMetres() {
        distanceUnitTest(DistanceUnit.METRES, new Float(1), "metres");
    }
}
