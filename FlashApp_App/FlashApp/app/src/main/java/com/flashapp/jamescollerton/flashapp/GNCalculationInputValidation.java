package com.flashapp.jamescollerton.flashapp;

import java.util.ArrayList;
import java.util.NoSuchElementException;

/**
 * Created by JamesCollerton on 21/12/2016.
 */
public class GNCalculationInputValidation {

    private static final int GUIDE_NUMBER_INDEX   = 0;
    private static final int DISTANCE_INDEX       = 1;
    private static final int ISO_INDEX            = 2;
    private static final int APERTURE_INDEX       = 3;

    private ArrayList<String> inputs;

    private String guideNumberInput;
    private String distanceInput;
    private String ISOInput;
    private String apertureInput;

    private int guideNumber;
    private int ISO;
    private float distance;
    private float aperture;

    public GNCalculationInputValidation(ArrayList<String> inputs){

        this.inputs = inputs;

        setUpInputs();

    }

    private void setUpInputs(){

        guideNumberInput = inputs.get(GUIDE_NUMBER_INDEX);
        distanceInput    = inputs.get(DISTANCE_INDEX);
        ISOInput         = inputs.get(ISO_INDEX);
        apertureInput    = inputs.get(APERTURE_INDEX);

    }

    public boolean validateForAperture(){

        boolean integerTestResult   = parseApertureIntegers();
        boolean floatTestResult     = parseApertureFloats();

        return integerTestResult && floatTestResult;

    }

    public boolean validateForDistance(){

        boolean integerTestResult   = parseDistanceIntegers();
        boolean floatTestResult     = parseDistanceFloats();

        return integerTestResult && floatTestResult;

    }

    public boolean parseApertureIntegers(){

        try {
            guideNumber = parseIntegerFromString(guideNumberInput);
            ISO         = parseIntegerFromString(ISOInput);
        } catch(NumberFormatException e){
            return false;
        }

        return true;

    }

    public boolean parseDistanceIntegers(){

        try {
            guideNumber = parseIntegerFromString(guideNumberInput);
            ISO         = parseIntegerFromString(ISOInput);
        } catch(NumberFormatException e){
            return false;
        }

        return true;

    }

    public int parseIntegerFromString(String toParse) throws NumberFormatException{

        return Integer.parseInt(toParse);

    }

    public boolean parseApertureFloats() {

        try{
            distance = parseFloatFromString(distanceInput);
        } catch (NumberFormatException e){
            return false;
        }

        return true;
    }

    public boolean parseDistanceFloats() {

        try{
            aperture = parseFloatFromString(apertureInput);
        } catch (NumberFormatException e){
            return false;
        }

        return true;
    }

    public float parseFloatFromString(String toParse) throws NumberFormatException{

        return Float.parseFloat(toParse);

    }

    public int getGuideNumber() {
        if(guideNumber != 0) {
            return guideNumber;
        } else {
            throw new NoSuchElementException("Need to validate before returning guide number.");
        }
    }

    public float getDistance() {
        if(distance != 0) {
            return distance;
        } else {
            throw new NoSuchElementException("Need to validate for aperture before returning distance.");
        }
    }

    public int getISO() {
        if(ISO != 0) {
            return ISO;
        } else {
            throw new NoSuchElementException("Need to validate before returning ISO");
        }
    }

    public float getAperture() {
        if(aperture != 0) {
            return aperture;
        } else{
            throw new NoSuchElementException("Need to validate for distance before returning aperture.");
        }
    }

}
