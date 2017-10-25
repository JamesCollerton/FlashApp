package com.flashapp.jamescollerton.flashapp.helpers;

import com.flashapp.jamescollerton.flashapp.models.Inputs;

/**
 * This is used to actually do calculations for apertures and distances.
 */
public class CalculationFormula {

    /**
     * If we have all of the inputs for a calculation then this takes them and turns them into
     * an aperture
     *
     * @param inputs
     * @return
     * @throws IllegalArgumentException
     */
    public static Float calculateAperture(Inputs inputs) throws IllegalArgumentException {

        Float apertureAdjustment = new Float(inputs.getPower());

        checkApertureInputs(inputs);

        Double ISOFactor = Math.sqrt(new Double(inputs.getISO()) / new Double(100));
        Float apertureRawValue = (new Float(inputs.getGuideNumber()) * new Float(ISOFactor)) / inputs.getDistance();
        return apertureRawValue + apertureAdjustment;
    }

    /**
     * This is used to check we have actually entered things into the fields we need to have
     * entered things into. We need a power, ISO and guide number for both aperture and distance
     * calculations.
     *
     * @param inputs Inputs corresponding to what has been entered on the screen
     * @throws IllegalArgumentException
     */
    private static void checkSharedInputs(Inputs inputs) throws IllegalArgumentException {
        if(inputs.getPower() == null ||
           inputs.getISO() == null ||
           inputs.getGuideNumber() == null){
            throw new IllegalArgumentException();
        }
    }

    /**
     * If we are calculating an aperture we also need to make sure the distance is not missing or
     * zero. If it is zero then we divide by zero.
     *
     * @param inputs
     * @throws IllegalArgumentException
     */
    private static void checkApertureInputs(Inputs inputs) throws IllegalArgumentException {
        checkSharedInputs(inputs);
        if(inputs.getDistance() == null ||
           inputs.getDistance() == 0){
            throw new IllegalArgumentException();
        }
    }

    /**
     * Given some inputs this is used to calculate the distance.
     *
     * @param inputs Inputs from the UI
     * @return the distance calculated from the inputs
     */
    public static Float calculateDistance(Inputs inputs){

        Float apertureAdjustment = new Float(inputs.getPower());

        checkDistanceInputs(inputs, apertureAdjustment);

        double ISOFactor = Math.sqrt(new Double(inputs.getISO()) / new Double(100));
        Float distance = (new Float(inputs.getGuideNumber()) * new Float(ISOFactor)) / (inputs.getAperture() + apertureAdjustment);
        return distance;
    }

    /**
     * This is used to check that the aperture has been populated and we aren't going to end up
     * with a divide by zero error.
     *
     * @param inputs The inputs to the screen
     * @param apertureAdjustment This is calculated from the power
     * @throws IllegalArgumentException
     */
    private static void checkDistanceInputs(Inputs inputs, Float apertureAdjustment) throws IllegalArgumentException {
        checkSharedInputs(inputs);
        if(inputs.getAperture() == null ||
           inputs.getAperture() + apertureAdjustment == 0){
            throw new IllegalArgumentException();
        }
    }

}
