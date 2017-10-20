package com.flashapp.jamescollerton.flashapp.helpers;

import com.flashapp.jamescollerton.flashapp.models.Inputs;

/**
 * Created by JamesCollerton on 02/10/2017.
 */
public class CalculationFormula {

    public static Float calculateAperture(Inputs inputs) throws IllegalArgumentException {

        Float apertureAdjustment = new Float(inputs.getPower());

        checkApertureInputs(inputs);

        Double ISOFactor = Math.sqrt(new Double(inputs.getISO()) / new Double(100));
        Float apertureRawValue = (new Float(inputs.getGuideNumber()) * new Float(ISOFactor)) / inputs.getDistance();
        return apertureRawValue + apertureAdjustment;
    }

    private static void checkSharedInputs(Inputs inputs) throws IllegalArgumentException {
        if(inputs.getPower() == null ||
           inputs.getISO() == null ||
           inputs.getGuideNumber() == null){
            throw new IllegalArgumentException();
        }
    }

    private static void checkApertureInputs(Inputs inputs) throws IllegalArgumentException {
        checkSharedInputs(inputs);
        if(inputs.getDistance() == null ||
           inputs.getDistance() == 0){
            throw new IllegalArgumentException();
        }
    }

    public static Float calculateDistance(Inputs inputs){

        Float apertureAdjustment = new Float(inputs.getPower());

        checkDistanceInputs(inputs, apertureAdjustment);

        double ISOFactor = Math.sqrt(new Double(inputs.getISO()) / new Double(100));
        Float distance = (new Float(inputs.getGuideNumber()) * new Float(ISOFactor)) / (inputs.getAperture() + apertureAdjustment);
        return distance;
    }

    private static void checkDistanceInputs(Inputs inputs, Float apertureAdjustment) throws IllegalArgumentException {
        checkSharedInputs(inputs);
        if(inputs.getAperture() == null ||
           inputs.getAperture() + apertureAdjustment == 0){
            throw new IllegalArgumentException();
        }
    }

}
