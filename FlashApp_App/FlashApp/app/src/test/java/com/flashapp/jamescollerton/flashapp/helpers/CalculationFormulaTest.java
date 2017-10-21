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

/**
 * Created by JamesCollerton on 14/10/2017.
 */
public class CalculationFormulaTest {


    private DistanceFragment setUpDistanceMock(TestResults testResults){

        DistanceFragment distanceFragment = Mockito.mock(DistanceFragment.class);
        Mockito.when(distanceFragment.getDistanceUnit()).thenReturn(testResults.getDistanceUnit());
        Mockito.when(distanceFragment.validate(testResults.getDistance())).thenCallRealMethod();

        return distanceFragment;
    }

    private void calculationFormulaApertureTest(TestResults testResults){

        DistanceFragment distanceFragment = setUpDistanceMock(testResults);

        Inputs input = new Inputs(
                GuideNumberFragment.newInstance().validate(testResults.getGuideNumber()),
                ISOFragment.newInstance().validate(testResults.getISO()),
                PowerFragment.newInstance().validate(testResults.getPower()),
                distanceFragment.validate(testResults.getDistance()),
                ApertureFragment.newInstance().validate(testResults.getAperture())
                );
        Float rawAperture = CalculationFormula.calculateAperture(input);
        assertEquals(rawAperture.toString(), testResults.getAperture());
    }

    private void calculationFormulaDistanceTest(TestResults testResults){

        DistanceFragment distanceFragment = setUpDistanceMock(testResults);

        Inputs input = new Inputs(
                GuideNumberFragment.newInstance().validate(testResults.getGuideNumber()),
                ISOFragment.newInstance().validate(testResults.getISO()),
                PowerFragment.newInstance().validate(testResults.getPower()),
                distanceFragment.validate(testResults.getDistance()),
                ApertureFragment.newInstance().validate(testResults.getAperture())
        );
        Float rawDistance = CalculationFormula.calculateDistance(input);
        assertEquals(rawDistance.toString(), testResults.getDistance());
    }

    /*
    Aperture Tests
     */
    @Test
    public void testApertureGN33ISO100Power0Distance5Aperture6(){
        calculationFormulaApertureTest(TestResults.GN33ISO100Power0Distance5Aperture6Metres);
    }

    @Test
    public void testApertureGN33ISO100Power0Distance10Aperture3(){
        calculationFormulaApertureTest(TestResults.GN33ISO100Power0Distance10Aperture3Metres);
    }

    @Test
    public void testApertureGN33ISO100Power0Distance15Aperture2(){
        calculationFormulaApertureTest(TestResults.GN33ISO100Power0Distance15Aperture2Metres);
    }

    @Test
    public void testApertureGN66ISO100Power0Distance10Aperture6(){
        calculationFormulaApertureTest(TestResults.GN66ISO100Power0Distance10Aperture6Metres);
    }

    @Test
    public void testApertureGN99ISO100Power0Distance10Aperture9(){
        calculationFormulaApertureTest(TestResults.GN99ISO100Power0Distance10Aperture9Metres);
    }

    @Test
    public void testApertureGN122ISO100Power0Distance10Aperture12(){
        calculationFormulaApertureTest(TestResults.GN122ISO100Power0Distance10Aperture12Metres);
    }

    @Test
    public void testApertureGN33ISO200Power0Distance10Aperture4(){
        calculationFormulaApertureTest(TestResults.GN33ISO200Power0Distance10Aperture4Metres);
    }

    @Test
    public void testApertureGN33ISO400Power0Distance10Aperture6(){
        calculationFormulaApertureTest(TestResults.GN33ISO400Power0Distance10Aperture6Metres);
    }

    @Test
    public void testApertureGN33ISO1600Power0Distance10Aperture13(){
        calculationFormulaApertureTest(TestResults.GN33ISO1600Power0Distance10Aperture13Metres);
    }

    /*
    Distance Tests
     */
    @Test
    public void testDistanceGN33ISO100Power0Distance5Aperture6(){
        calculationFormulaDistanceTest(TestResults.GN33ISO100Power0Distance5Aperture6Metres);
    }

    @Test
    public void testDistanceGN33ISO100Power0Distance10Aperture3(){
        calculationFormulaDistanceTest(TestResults.GN33ISO100Power0Distance10Aperture3Metres);
    }

    @Test
    public void testDistanceGN33ISO100Power0Distance15Aperture2(){
        calculationFormulaDistanceTest(TestResults.GN33ISO100Power0Distance15Aperture2Metres);
    }

    @Test
    public void testDistanceGN66ISO100Power0Distance10Aperture6(){
        calculationFormulaDistanceTest(TestResults.GN66ISO100Power0Distance10Aperture6Metres);
    }

    @Test
    public void testDistanceGN99ISO100Power0Distance10Aperture9(){
        calculationFormulaDistanceTest(TestResults.GN99ISO100Power0Distance10Aperture9Metres);
    }

    @Test
    public void testDistanceGN122ISO100Power0Distance10Aperture12(){
        calculationFormulaDistanceTest(TestResults.GN122ISO100Power0Distance10Aperture12Metres);
    }

    @Test
    public void testDistanceGN33ISO200Power0Distance10Aperture4(){
        calculationFormulaDistanceTest(TestResults.GN33ISO200Power0Distance10Aperture4Metres);
    }

    @Test
    public void testDistanceGN33ISO400Power0Distance10Aperture6(){
        calculationFormulaDistanceTest(TestResults.GN33ISO400Power0Distance10Aperture6Metres);
    }

    @Test
    public void testDistanceGN33ISO1600Power0Distance10Aperture13(){
        calculationFormulaDistanceTest(TestResults.GN33ISO1600Power0Distance10Aperture13Metres);
    }

}
