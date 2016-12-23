package com.flashapp.jamescollerton.flashapp;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
public class GNCalculationFormulaUnitTest {

    String[] apertureStrings = new String[] {
            "1.7",
            "2.8",
            "4",
            "5.6",
            "8",
            "11",
            "16",
            "22"
    };

    private void setUpApertureTest(int ISO, int guideNumber, float distance, float expectedAperture, String expectedApertureOption){
        GNCalculationScreen screen = new GNCalculationScreen();
        GNCalculationFormula formula = new GNCalculationFormula(screen, ISO, guideNumber);
        formula.setDistance(distance);
        float rawAperture = formula.findRawAperture();
        assertEquals(rawAperture, expectedAperture, 1);
        formula.setApertureOptions(apertureStrings);
        int apertureIndex = formula.findApertureFromOptions(rawAperture);
        assertEquals(apertureIndex, Arrays.asList(apertureStrings).indexOf(expectedApertureOption));
    }

    @Test
    public void ISO100_GN_28_D1_Calculate_Aperture() throws Exception {
        setUpApertureTest(100, 28, 1, 28, "22");
    }

    @Test
    public void ISO100_GN_33_D10_Calculate_Aperture() throws Exception {
        setUpApertureTest(100, 33, 10, (float) 3.3, "2.8");
    }

    @Test
    public void ISO100_GN_35_D15_Calculate_Aperture() throws Exception {
        setUpApertureTest(100, 35, 15, (float) 2.33, "2.8");
    }

    @Test
    public void ISO200_GN_28_D1_Calculate_Aperture() throws Exception {
        setUpApertureTest(200, 28, 1, (float) 39.6, "22");
    }

    @Test
    public void ISO200_GN_33_D10_Calculate_Aperture() throws Exception {
        setUpApertureTest(200, 33, 10, (float) 4.67, "4");
    }

    @Test
    public void ISO200_GN_35_D15_Calculate_Aperture() throws Exception {
        setUpApertureTest(200, 35, 15, (float) 3.3, "2.8");
    }

    @Test
    public void ISO800_GN_28_D1_Calculate_Aperture() throws Exception {
        setUpApertureTest(800, 28, 1, (float) 79.2, "22");
    }

    @Test
    public void ISO800_GN_33_D10_Calculate_Aperture() throws Exception {
        setUpApertureTest(800, 33, 10, (float) 9.33, "8");
    }

    @Test
    public void ISO800_GN_35_D15_Calculate_Aperture() throws Exception {
        setUpApertureTest(800, 35, 15, (float) 6.6, "5.6");
    }


}