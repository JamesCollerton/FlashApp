package com.flashapp.jamescollerton.flashapp.models;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * This is used to check that the input object is initialised correctly and returns what we expect.
 */
public class InputsTest {

    /**
     * This method is used to set up and test an input. We feed in values for the various values
     * in the Input, then check they are returned. Finally we swap some values around using the
     * setters and check they still return the correct thing.
     *
     * @param guideNumber
     * @param ISO
     * @param power
     * @param distance
     * @param aperture
     */
    private void setUpInputTest(Integer guideNumber, Integer ISO, Integer power, Float distance, Float aperture){
        Inputs inputs = new Inputs(
                guideNumber,
                ISO,
                power,
                distance,
                aperture
        );
        assertEquals(inputs.getGuideNumber(), guideNumber);
        assertEquals(inputs.getISO(), ISO);
        assertEquals(inputs.getPower(), power);
        assertEquals(inputs.getDistance(), distance);
        assertEquals(inputs.getAperture(), aperture);

        // Change some fields and assert worked
        inputs.setGuideNumber(ISO);
        inputs.setISO(power);
        inputs.setPower(guideNumber);
        inputs.setDistance(aperture);
        inputs.setAperture(distance);

        assertEquals(inputs.getGuideNumber(), ISO);
        assertEquals(inputs.getISO(), power);
        assertEquals(inputs.getPower(), guideNumber);
        assertEquals(inputs.getDistance(), aperture);
        assertEquals(inputs.getAperture(), distance);
    }

    @Test
    public void inputTestValidGN33ISO100Power1Aperture0Distance0(){
        setUpInputTest(33, 100, 1, new Float(0.1), new Float(0.1));
    }

    @Test
    public void inputTestValidGN33ISO10PowerNeg1Aperture0Distance0(){
        setUpInputTest(0, 10, -1, new Float(0.11111111111111111), new Float(0.111111111111111));
    }

    @Test
    public void inputTestValidGNNeg1ISONeg10PowerNeg1Aperture1Distance2(){
        setUpInputTest(-1, -10, -1, new Float(1), new Float(2));
    }

}
