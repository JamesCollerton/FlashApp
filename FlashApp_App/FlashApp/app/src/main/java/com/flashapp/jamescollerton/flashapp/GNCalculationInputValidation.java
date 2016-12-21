package com.flashapp.jamescollerton.flashapp;

import java.util.ArrayList;

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
    private int distance;
    private int ISO;
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

    public boolean validate(){

        boolean integerTestResult   = parseIntegers();
        boolean floatTestResult     = parseFloats();

        return integerTestResult && floatTestResult;
    }

    public boolean parseIntegers(){

        try {
            guideNumber = parseIntegerFromString(guideNumberInput);
            distance = parseIntegerFromString(distanceInput);
            ISO = parseIntegerFromString(ISOInput);
        } catch(NumberFormatException e){
            return false;
        }

        return true;

    }

    public int parseIntegerFromString(String toParse) throws NumberFormatException{

        return Integer.parseInt(toParse);

    }

    public boolean parseFloats() {

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

}
