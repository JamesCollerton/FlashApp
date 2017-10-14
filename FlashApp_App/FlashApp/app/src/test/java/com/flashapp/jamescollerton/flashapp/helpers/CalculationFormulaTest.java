package com.flashapp.jamescollerton.flashapp.helpers;

import com.flashapp.jamescollerton.flashapp.fragments.GuideNumberFragment;
import com.flashapp.jamescollerton.flashapp.models.Inputs;

import testUtils.TestResults;

/**
 * Created by JamesCollerton on 14/10/2017.
 */
public class CalculationFormulaTest {

    private void calculationFormulatApertureTest(TestResults testResults){
        Inputs input = new Inputs(
                GuideNumberFragment.testResults.getGuideNumber()),
                InputValidation.parseIntegerFromString(testResults.getISO(),
                        testResults.getPower().getValue(),
                        testResults.getDistance(),
                        testResults.getAperture()
                );
    }

    private void calculationFormulatDistanceTest(TestResults testResults){

    }

}
