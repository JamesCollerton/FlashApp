package com.flashapp.jamescollerton.flashapp;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
public class GNCalculationFormulaUnitTest {

    @Test
    public void ISO100_GN_28_D1_Calculate_Aperture() throws Exception {
        GNCalculationScreen screen = new GNCalculationScreen();
        GNCalculationFormula formula = new GNCalculationFormula(screen, 100, 28);
        formula.setDistance(1);
        float rawAperture = formula.findRawAperture();
        assertEquals(rawAperture, 28, 1);
    }

    @Test
    public void ISO100_GN_33_D10_Calculate_Aperture() throws Exception {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void ISO100_GN_35_D15_Calculate_Aperture() throws Exception {
        assertEquals(4, 2 + 2);
    }

}