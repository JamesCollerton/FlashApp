package com.flashapp.jamescollerton.flashapp.helpers;

import com.flashapp.jamescollerton.flashapp.fragments.ApertureFragment;
import com.flashapp.jamescollerton.flashapp.fragments.DistanceFragment;
import com.flashapp.jamescollerton.flashapp.fragments.GuideNumberFragment;
import com.flashapp.jamescollerton.flashapp.fragments.ISOFragment;
import com.flashapp.jamescollerton.flashapp.fragments.PowerFragment;
import com.flashapp.jamescollerton.flashapp.models.Inputs;

import org.junit.Test;
import org.mockito.Mockito;

import testUtils.TestResults;

import static org.junit.Assert.assertEquals;

public class CalculationFormulaTest {


    private DistanceFragment setUpDistanceMock(TestResults testResults){

        DistanceFragment distanceFragment = Mockito.mock(DistanceFragment.class);
        Mockito.when(distanceFragment.getDistanceUnit()).thenReturn(testResults.getDistanceUnit());
        Mockito.when(distanceFragment.validateInput(testResults.getDistance())).thenCallRealMethod();
        Mockito.when(distanceFragment.validateOutput(new Float(0))).thenCallRealMethod();

        return distanceFragment;
    }

    private void calculationFormulaApertureTest(TestResults testResults){

        DistanceFragment distanceFragment = setUpDistanceMock(testResults);

        Inputs input = new Inputs(
                GuideNumberFragment.newInstance().validateInput(testResults.getGuideNumber()),
                ISOFragment.newInstance().validateInput(testResults.getISO()),
                PowerFragment.newInstance().validateInput(testResults.getPower()),
                distanceFragment.validateInput(testResults.getDistance()),
                ApertureFragment.newInstance().validateInput(testResults.getAperture())
                );
        Float rawAperture = CalculationFormula.calculateAperture(input);
        assertEquals(rawAperture.toString(), testResults.getAperture());
    }

    private void calculationFormulaDistanceTest(TestResults testResults){

        DistanceFragment distanceFragment = setUpDistanceMock(testResults);

        Inputs input = new Inputs(
                GuideNumberFragment.newInstance().validateInput(testResults.getGuideNumber()),
                ISOFragment.newInstance().validateInput(testResults.getISO()),
                PowerFragment.newInstance().validateInput(testResults.getPower()),
                distanceFragment.validateInput(testResults.getDistance()),
                ApertureFragment.newInstance().validateInput(testResults.getAperture())
        );
        Float rawDistance = CalculationFormula.calculateDistance(input);

        Mockito.when(distanceFragment.validateOutput(rawDistance)).thenCallRealMethod();

        Float convertedDistance = distanceFragment.validateOutput(rawDistance);

        assertEquals(convertedDistance.toString(), testResults.getDistance());
    }

    /*
    Metres
     */

    /*
    Aperture Tests
     */
    @Test
    public void testApertureGN33ISO100Power0Distance5Aperture6Metres(){
        calculationFormulaApertureTest(TestResults.GN33ISO100Power0Distance5Aperture6Metres);
    }

    @Test
    public void testApertureGN33ISO100Power0Distance10Aperture3Metres(){
        calculationFormulaApertureTest(TestResults.GN33ISO100Power0Distance10Aperture3Metres);
    }

    @Test
    public void testApertureGN33ISO100Power0Distance15Aperture2Metres(){
        calculationFormulaApertureTest(TestResults.GN33ISO100Power0Distance15Aperture2Metres);
    }

    @Test
    public void testApertureGN66ISO100Power0Distance10Aperture6Metres(){
        calculationFormulaApertureTest(TestResults.GN66ISO100Power0Distance10Aperture6Metres);
    }

    @Test
    public void testApertureGN99ISO100Power0Distance10Aperture9Metres(){
        calculationFormulaApertureTest(TestResults.GN99ISO100Power0Distance10Aperture9Metres);
    }

    @Test
    public void testApertureGN122ISO100Power0Distance10Aperture12Metres(){
        calculationFormulaApertureTest(TestResults.GN122ISO100Power0Distance10Aperture12Metres);
    }

    @Test
    public void testApertureGN33ISO200Power0Distance10Aperture4Metres(){
        calculationFormulaApertureTest(TestResults.GN33ISO200Power0Distance10Aperture4Metres);
    }

    @Test
    public void testApertureGN33ISO400Power0Distance10Aperture6Metres(){
        calculationFormulaApertureTest(TestResults.GN33ISO400Power0Distance10Aperture6Metres);
    }

    @Test
    public void testApertureGN33ISO1600Power0Distance10Aperture13Metres(){
        calculationFormulaApertureTest(TestResults.GN33ISO1600Power0Distance10Aperture13Metres);
    }

    /*
    Distance Tests
     */
    @Test
    public void testDistanceGN33ISO100Power0Distance5Aperture6Metres(){
        calculationFormulaDistanceTest(TestResults.GN33ISO100Power0Distance5Aperture6Metres);
    }

    @Test
    public void testDistanceGN33ISO100Power0Distance10Aperture3Metres(){
        calculationFormulaDistanceTest(TestResults.GN33ISO100Power0Distance10Aperture3Metres);
    }

    @Test
    public void testDistanceGN33ISO100Power0Distance15Aperture2Metres(){
        calculationFormulaDistanceTest(TestResults.GN33ISO100Power0Distance15Aperture2Metres);
    }

    @Test
    public void testDistanceGN66ISO100Power0Distance10Aperture6Metres(){
        calculationFormulaDistanceTest(TestResults.GN66ISO100Power0Distance10Aperture6Metres);
    }

    @Test
    public void testDistanceGN99ISO100Power0Distance10Aperture9Metres(){
        calculationFormulaDistanceTest(TestResults.GN99ISO100Power0Distance10Aperture9Metres);
    }

    @Test
    public void testDistanceGN122ISO100Power0Distance10Aperture12Metres(){
        calculationFormulaDistanceTest(TestResults.GN122ISO100Power0Distance10Aperture12Metres);
    }

    @Test
    public void testDistanceGN33ISO200Power0Distance10Aperture4Metres(){
        calculationFormulaDistanceTest(TestResults.GN33ISO200Power0Distance10Aperture4Metres);
    }

    @Test
    public void testDistanceGN33ISO400Power0Distance10Aperture6Metres(){
        calculationFormulaDistanceTest(TestResults.GN33ISO400Power0Distance10Aperture6Metres);
    }

    @Test
    public void testDistanceGN33ISO1600Power0Distance10Aperture13Metres(){
        calculationFormulaDistanceTest(TestResults.GN33ISO1600Power0Distance10Aperture13Metres);
    }

    /*
    Feet
     */

    /*
    Aperture
     */
    @Test
    public void testApertureGN33ISO100Power0Distance5Aperture21Feet(){
        calculationFormulaApertureTest(TestResults.GN33ISO100Power0Distance5Aperture21Feet);
    }

    @Test
    public void testApertureGN33ISO100Power0Distance10Aperture3Feet(){
        calculationFormulaApertureTest(TestResults.GN33ISO100Power0Distance10Aperture3Feet);
    }

    @Test
    public void testApertureGN33ISO100Power0Distance15Aperture2Feet(){
        calculationFormulaApertureTest(TestResults.GN33ISO100Power0Distance15Aperture2Feet);
    }

    @Test
    public void testApertureGN66ISO100Power0Distance10Aperture6Feet(){
        calculationFormulaApertureTest(TestResults.GN66ISO100Power0Distance10Aperture6Feet);
    }

    @Test
    public void testApertureGN99ISO100Power0Distance10Aperture9Feet(){
        calculationFormulaApertureTest(TestResults.GN99ISO100Power0Distance10Aperture9Feet);
    }

    @Test
    public void testApertureGN122ISO100Power0Distance10Aperture12Feet(){
        calculationFormulaApertureTest(TestResults.GN122ISO100Power0Distance10Aperture12Feet);
    }

    @Test
    public void testApertureGN33ISO200Power0Distance10Aperture4Feet(){
        calculationFormulaApertureTest(TestResults.GN33ISO200Power0Distance10Aperture4Feet);
    }

    @Test
    public void testApertureGN33ISO400Power0Distance10Aperture6Feet(){
        calculationFormulaApertureTest(TestResults.GN33ISO400Power0Distance10Aperture6Feet);
    }

    @Test
    public void testApertureGN33ISO1600Power0Distance10Aperture13Feet(){
        calculationFormulaApertureTest(TestResults.GN33ISO1600Power0Distance10Aperture13Feet);
    }

    /*
    Distance
     */
    @Test
    public void testDistanceGN33ISO100Power0Distance5Aperture21Feet(){
        calculationFormulaDistanceTest(TestResults.GN33ISO100Power0Distance5Aperture21Feet);
    }

    @Test
    public void testDistanceGN33ISO100Power0Distance10Aperture3Feet(){
        calculationFormulaDistanceTest(TestResults.GN33ISO100Power0Distance10Aperture3Feet);
    }

    @Test
    public void testDistanceGN33ISO100Power0Distance15Aperture2Feet(){
        calculationFormulaDistanceTest(TestResults.GN33ISO100Power0Distance15Aperture2Feet);
    }

    @Test
    public void testDistanceGN66ISO100Power0Distance10Aperture6Feet(){
        calculationFormulaDistanceTest(TestResults.GN66ISO100Power0Distance10Aperture6Feet);
    }

    @Test
    public void testDistanceGN99ISO100Power0Distance10Aperture9Feet(){
        calculationFormulaDistanceTest(TestResults.GN99ISO100Power0Distance10Aperture9Feet);
    }

    @Test
    public void testDistanceGN122ISO100Power0Distance10Aperture12Feet(){
        calculationFormulaDistanceTest(TestResults.GN122ISO100Power0Distance10Aperture12Feet);
    }

    @Test
    public void testDistanceGN33ISO200Power0Distance10Aperture4Feet(){
        calculationFormulaDistanceTest(TestResults.GN33ISO200Power0Distance10Aperture4Feet);
    }

    @Test
    public void testDistanceGN33ISO400Power0Distance10Aperture6Feet(){
        calculationFormulaDistanceTest(TestResults.GN33ISO400Power0Distance10Aperture6Feet);
    }

    @Test
    public void testDistanceGN33ISO1600Power0Distance10Aperture13Feet(){
        calculationFormulaDistanceTest(TestResults.GN33ISO1600Power0Distance10Aperture13Feet);
    }

}
