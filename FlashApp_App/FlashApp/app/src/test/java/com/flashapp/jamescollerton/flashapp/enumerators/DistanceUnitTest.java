package com.flashapp.jamescollerton.flashapp.enumerators;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * This is used to test all of the distance unit enumerations to make sure they return the right
 * things
 */
public class DistanceUnitTest {

    /**
     * This sets up the distance unit tests. It is used to take a distance unit and make sure that
     * it returns the right conversion unit and string value
     *
     * @param distanceUnit Unit we are testing
     * @param conversionUnit The conversion unit we expect to have returned
     * @param string The string we want to represent the unit
     */
    private void distanceUnitTest(DistanceUnit distanceUnit, Float conversionUnit, String string){
        assertEquals(distanceUnit.getConversionUnit(), conversionUnit);
        assertEquals(distanceUnit.toString(), string);
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
