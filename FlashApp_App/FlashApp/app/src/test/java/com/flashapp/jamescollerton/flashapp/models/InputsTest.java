package com.flashapp.jamescollerton.flashapp.models;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Created by JamesCollerton on 15/10/2017.
 */
public class InputsTest {

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
