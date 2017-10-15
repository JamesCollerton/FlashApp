package com.flashapp.jamescollerton.flashapp.models;

import android.renderscript.ScriptGroup;

import static junit.framework.Assert.*;

import org.junit.Test;

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
        inputs.setAperture(aperture);

        assertEquals(inputs.getGuideNumber(), ISO);
        assertEquals(inputs.getISO(), power);
        assertEquals(inputs.getPower(), guideNumber);
        assertEquals(inputs.getDistance(), aperture);
        assertEquals(inputs.getAperture(), distance);
    }

    @Test
    public void inputTestValid(){
        setUpInputTest(33, 100, 1, new Float(0.1), new Float(0.1));
    }

}
